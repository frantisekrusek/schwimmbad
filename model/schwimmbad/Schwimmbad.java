package model.schwimmbad;

import model.pumpe.Pumpe;
import model.schwimmer.Schwimmer;
import model.useController.UseController;
import viewing.Rahmen_4_nachzahlen;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Schwimmbad {
    //Warum statische Eigenschaften? - Es gibt nur eine Instanz.
    private static int gesamtBesucherCounter;
    private static int anwesendeBesucherCounter;
    private ArrayList<Schwimmer> anwesendeBesucherArrayList = new ArrayList<>();
    private ArrayList<Schwimmer> gesamtBesucherArrayList = new ArrayList<>();
    private Pumpe pumpe = new Pumpe();
    private UseController useControllerS;
    private Sprachmodul sprachmodulS;
    //Automat gibt Chip-armbänder gegen Bezahlung aus.
    //Unterschiedliche Farbe der Bänder nach Tarifgruppe (zb grün für Schüler, blau für Senioren, rot für Vollpreis)
    //Superklasse Schwimmer, Subklassen Tarifgruppen.
    //Preisstaffelung nach Schwimmdauer.
    private BargeldAnnahmeAutomat bargeldAnnahmeAutomat= new BargeldAnnahmeAutomat();
    private String infoIDfertigerSchwimmer = "";
    private DecimalFormat decimalFormat = new DecimalFormat("###0.##");
    private ArrayList<Duration> vollzahlerBesuche = new ArrayList<>();
    private ArrayList<Duration> seniorenBesuche = new ArrayList<>();
    private ArrayList<Duration> schuelerBesuche = new ArrayList<>();
    private boolean feueralarm;
    //ctr
    public Schwimmbad (UseController useController){
        this.useControllerS = useController;
        sprachmodulS = new Sprachmodul(Sprachmodul.Sprache.DEU, this);
    }
    //end ctr

    //bei Eintritt eines Besuchers werden Zaehler angepasst.
    public void eintreten(Schwimmer s){
        this.gesamtBesucherArrayList.add(s);
        this.anwesendeBesucherArrayList.add(s);
        BargeldAnnahmeAutomat.setEinnahmenCounter(getBargeldAnnahmeAutomat().getEinnahmenCounter() + s.getPreis());
        ++this.gesamtBesucherCounter;
        ++this.anwesendeBesucherCounter;
        s.setInstantEintreten(Instant.now());
        System.out.println("LOG: Geplante Besuchsdauer maximal " + s.getBesuchsDauer() + " Stunden");
    }//end eintreten

    public void verlassenSchw_2(int pId){
        Schwimmer fertigerSchwimmer = null;
        //Validierung - Anwesende im Bad?
        if (anwesendeBesucherCounter >0) {
            for (Schwimmer sc: anwesendeBesucherArrayList) {
                if (sc.getArmbandID() == pId) {
                    fertigerSchwimmer = sc;
                }
            }
            //Validierung - wurde ein Schwimmer übergeben?
            if (fertigerSchwimmer !=null) {
                fertigerSchwimmer.setInstantVerlassen(Instant.now());
                fertigerSchwimmer.setDuration(Duration.between(fertigerSchwimmer.getInstantEintreten(), fertigerSchwimmer.getInstantVerlassen()));
                fertigerSchwimmer.speichereDuration();
                System.out.println("LOG Schwimmbad: Dauer Aufenthalt in Sekunden : " + fertigerSchwimmer.getDuration().toSeconds());
                //Kurzzeit-Karten werden auf Zeitüberschreitung geprüft, gegebenenfalls zur Nachzahlung beim Ausgangs-Automaten aufgefordert bevor Austrittsschranke freigegeben wird.
                //Einnahmencounter und Eintrittspreis des betreffenden Schwimmers werden für statistische Verarbeitung entsprechend erhöht (siehe Rahmen_4_nachzahlen)
                if (fertigerSchwimmer.isKurzzeit() && fertigerSchwimmer.getDuration().toSeconds() > 3 && !feueralarm){
                    useControllerS.setNachZahlBedingung(true);
                    new Rahmen_4_nachzahlen(useControllerS, fertigerSchwimmer);
                }else {
                    System.out.println("LOG: Tschuess, ID " + fertigerSchwimmer.getArmbandID());
                    infoIDfertigerSchwimmer = "<html><body>" + getSprachmodulS().getSchwBadAbschiedSFV() + fertigerSchwimmer.getArmbandID() + "!<br/>"
                            + fertigerSchwimmer.gebeAusDuration() + "</html></body>";
                    anwesendeBesucherArrayList.remove(fertigerSchwimmer);
                    --this.anwesendeBesucherCounter;
                }
            }else{
                infoIDfertigerSchwimmer = sprachmodulS.getLabel5ChipleseFehlerSFV();
            }
        }else{
            infoIDfertigerSchwimmer = sprachmodulS.getLabel5BadLeerSFV();
        }
    }//end verlassen

    public void aufzahlenSchwimmbad(){
        --Schwimmbad.anwesendeBesucherCounter;
    }

    //Ausgabe durchschnittliche Besuchsdauer (nach Tarifgruppe)
    public String schnittDauerAusgebenVollzahler(){
        Duration sum = Duration.ZERO;
        for(Duration d: vollzahlerBesuche){
            sum = sum.plus(d);
            System.out.println("LOG:" + sum.toSeconds());
        }
        System.out.println("LOG: Elemente in VollzahlerBesucheArrList: " + vollzahlerBesuche.size());
        System.out.println("LOG: Summe aller Besuche in Sekunden: " + sum.toSeconds());
        //Gefahr Division durch 0
        //daher Exception Handling durch try-catch zur Vermeidung von Laufzeitfehlern.
        Duration average = Duration.ZERO;
        try {
            average = sum.dividedBy(vollzahlerBesuche.size());
        }catch (Exception e){
            System.out.println("LOG: " + e);
        }
        long h = average.toHours();
        long m = average.toMinutesPart();
        long s = average.toSecondsPart();
        String averageFormatiert = String.format("%02d:%02d:%02d",h,m,s);
        System.out.println("LOG: Schnitt aller Besuche in Sekunden: " + average.toSeconds());
        return averageFormatiert;
    }

    public String schnittDauerAusgebenSenioren(){
        Duration sum = Duration.ZERO;
        for(Duration d: seniorenBesuche){
            sum = sum.plus(d);
            System.out.println("LOG:" + sum.toSeconds());
        }
        System.out.println("LOG: Elemente in SeniorenBesucherArrList: " + seniorenBesuche.size());
        System.out.println("LOG: Summe aller Besuche in Sekunden: " + sum.toSeconds());
        Duration average = Duration.ZERO;
        //Gefahr Division durch 0
        try {
            average = sum.dividedBy(seniorenBesuche.size());
        }catch (Exception e){
            System.out.println("LOG: " + e);
        }
        long h = average.toHours();
        long m = average.toMinutesPart();
        long s = average.toSecondsPart();
        String averageFormatiert = String.format("%02d:%02d:%02d",h,m,s);
        System.out.println("LOG: Schnitt aller Besuche in Sekunden: " + average.toSeconds());
        return averageFormatiert;
    }

    public String schnittDauerAusgebenSchueler(){
        Duration sum = Duration.ZERO;
        for(Duration d: schuelerBesuche){
            sum = sum.plus(d);
            System.out.println("LOG:" + sum.toSeconds());
        }
        System.out.println("LOG: Elemente in SchuelerBesucherArrList: " + schuelerBesuche.size());
        System.out.println("LOG: Summe aller Besuche in Sekunden: " + sum.toSeconds());
        Duration average = Duration.ZERO;
        //Gefahr Division durch 0
        try {
            average = sum.dividedBy(schuelerBesuche.size());
        }catch (Exception e){
            System.out.println("LOG: " + e);
        }
        long h = average.toHours();
        long m = average.toMinutesPart();
        long s = average.toSecondsPart();
        String averageFormatiert = String.format("%02d:%02d:%02d",h,m,s);
        System.out.println("LOG: Schnitt aller Besuche in Sekunden: " + average.toSeconds());
        return averageFormatiert;
    }

    public double rechneProzent(double pGesamt, double pAnteil){
        return (pAnteil*100)/pGesamt;
    }

    public String errechneAnteileAnEinnahmenVollzahler(){
        long anzahlVollzahler = gesamtBesucherArrayList.stream().filter(schwimmer -> schwimmer.getTarifGruppe().equals("Vollzahler")).count();
        double preiseVollzahler = 0;
        //Stream mit 2 Intermediates
        //Anwendung der Functional Interfaces Predicate und Function
        preiseVollzahler = gesamtBesucherArrayList.stream()
                                    //filter() verlangt Subklasse von FI Predicate, Methode test(), Syntax lambda expression - aus allen Besuchern werden Vollzahler herausgefiltert.
                                    .filter(schwimmer -> schwimmer.getTarifGruppe().equals("Vollzahler"))
                                    //map() verlangt FI Function, dessen Methode apply() ruft
                                    //Schwimmer.getPreis() auf, Syntax method reference
                                    //Beträge Eintritt werden ermittelt
                                    .map(Schwimmer::getPreis)
                                    //Eintritte (Typ double) werden summiert und zurückgegeben.
                                    //Quellenangabe Summierung Double-Werte in terminal operation: https://www.baeldung.com/java-stream-sum
                                    .collect(Collectors.summingDouble(Double::doubleValue));
        double anteilEinnahmenVollzahler = rechneProzent(BargeldAnnahmeAutomat.getEinnahmenCounter(), preiseVollzahler);
        return sprachmodulS.getSchwibaEinnahmenVonSFV() + anzahlVollzahler + sprachmodulS.getSchwibaVollzahlernSFV() + "€"
                + preiseVollzahler + " - " + decimalFormat.format(anteilEinnahmenVollzahler) + sprachmodulS.getSchwibaProzentSFV();
    }

    public String errechneAnteileAnEinnahmenSenioren() {
        long anzahlSenioren = gesamtBesucherArrayList.stream().filter(schwimmer -> schwimmer.getTarifGruppe().equals("Senior")).count();
        double preiseSenioren = 0;
        //Stream mit 2 Intermediates
        //Anwendung der Functional Interfaces Predicate und Function
        preiseSenioren = gesamtBesucherArrayList.stream().filter(schwimmer -> schwimmer.getTarifGruppe().equals("Senior")).map(schwimmer -> schwimmer.getPreis()).collect(Collectors.summingDouble(Double::doubleValue));
        double anteilEinnahmenSenioren = rechneProzent(BargeldAnnahmeAutomat.getEinnahmenCounter(), preiseSenioren);
        return sprachmodulS.getSchwibaEinnahmenVonSFV() + anzahlSenioren + sprachmodulS.getSchwibaSeniorenSFV() + "€"
                + preiseSenioren + " - " + decimalFormat.format(anteilEinnahmenSenioren) + sprachmodulS.getSchwibaProzentSFV();
    }
    public String errechneAnteileAnEinnahmenSchueler(){
        long anzahlSchueler = gesamtBesucherArrayList.stream().filter(schwimmer -> schwimmer.getTarifGruppe().equals("Schueler")).count();
        double preiseSchueler;
        preiseSchueler = gesamtBesucherArrayList.stream().filter(schwimmer -> schwimmer.getTarifGruppe().equals("Schueler")).map(schwimmer -> schwimmer.getPreis()).collect(Collectors.summingDouble(Double::doubleValue));
        double anteilEinnahmenSchueler = rechneProzent(BargeldAnnahmeAutomat.getEinnahmenCounter(), preiseSchueler);
        return sprachmodulS.getSchwibaEinnahmenVonSFV() + anzahlSchueler + sprachmodulS.getSchwibaSchuelernSFV() + "€"
                + preiseSchueler + " - " + decimalFormat.format(anteilEinnahmenSchueler) + sprachmodulS.getSchwibaProzentSFV();
    }

    // Methoden leiten Nachrichten weiter (zB aus UseController an Pumpe.)
    public void vermittleSetBetrieb(boolean b){
        pumpe.setBetrieb(b);
    }
    public boolean vermittleIsBetrieb(){
        return pumpe.isBetrieb();
    }
    public void vermittleSetPassendeUmlaufGeschwindigkeit(){
        Pumpe.setPassendeUmlaufGeschwindigkeit();
    }
    public int rufePumpeUG(){
        return Pumpe.getUmlaufGeschwindigkeit();
    }
    public void vermittleSetUmlaufGeschwindigkeit(int i){
        Pumpe.setUmlaufGeschwindigkeit(i);
    }

    //Getter und Setter
    public void setFeueralarm(boolean feueralarm) {
        this.feueralarm = feueralarm;
    }
    public ArrayList<Schwimmer> getAnwesendeBesucherArrayList() {
        return anwesendeBesucherArrayList;
    }
    public String getInfoID() {
        return infoIDfertigerSchwimmer;
    }
    public BargeldAnnahmeAutomat getBargeldAnnahmeAutomat() {
        return bargeldAnnahmeAutomat;
    }
    public static int getAnwesendeBesucherCounter() {
        return anwesendeBesucherCounter;
    }
    public int getGesamtBesucherCounter() {
        return gesamtBesucherCounter;
    }
    public ArrayList<Duration> getSchuelerBesuche() {
        return schuelerBesuche;
    }
    public ArrayList<Duration> getVollzahlerBesuche() {
        return vollzahlerBesuche;
    }
    public ArrayList<Duration> getSeniorenBesuche() {
        return seniorenBesuche;
    }
    public Sprachmodul getSprachmodulS() {
        return sprachmodulS;
    }
    public void setSprachmodulS(Sprachmodul sprachmodulS) {
        this.sprachmodulS = sprachmodulS;
    }
    public UseController getUseControllerS() {
        return useControllerS;
    }
}//end class
