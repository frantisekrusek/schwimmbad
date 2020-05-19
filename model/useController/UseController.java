package model.useController;

import model.schwimmbad.Manager;
import model.schwimmbad.Schwimmbad;
import model.schwimmbad.Sprachmodul;
import model.schwimmer.Schwimmer;
import model.schwimmer.schueler.Schueler;
import viewing.*;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseController{
    private Schwimmbad schwimmbadZeigerU;
    private Rahmen_0 rahmen_0ZeigerU;
    private Rahmen_1_Admin rahmenAdmin1ZeigerU;
    private Rahmen_2_Codeabfrage rahmen_2_Codeabfrage;
    private Rahmen_3_Haustechnik rahmen_3_Haustechnik;
    private Rahmen_3_Manager rahmen_3_manager;
    private Manager managerZeigerU;
    private Rahmen_4_nachzahlen rahmen_4_nachzahlen;
    private Rahmen_5_Beschwerde rahmen_5_beschwerdeZeigerU;
    private Format format = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
    private boolean nachZahlBedingung;

    //Konstruktor
    public UseController(){
        schwimmbadZeigerU = new Schwimmbad(this);
        managerZeigerU = new Manager(this);
        rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
    }//end ctr

    //Vollzahler und Senioren betreten das Schwimmbad über inner-anonym- bzw. lambda- implementierung
    //des Actionlistener in der Rahmen-Klasse selbst.
    //Bei Eintreten eines Schülers hingegen wird in der Rahmen-Klasse über method-reference auf die
    //im Folgenden implementierte Logik verwiesen:
    public void schuelerEintreten(ActionEvent e){
        Schwimmer schwimmerZeigerU;
        if (rahmen_0ZeigerU.getValueCheckBoxKurzzeit()) {
            schwimmerZeigerU = new Schueler(true, schwimmbadZeigerU);
            schwimmbadZeigerU.eintreten(schwimmerZeigerU);
            System.out.println("LOG: Schueler(Kurzzeit) eintritt, ID: " + schwimmerZeigerU.getArmbandID());
        }else {
            schwimmerZeigerU = new Schueler(false, schwimmbadZeigerU);
            schwimmbadZeigerU.eintreten(schwimmerZeigerU);
            System.out.println("LOG: Schueler eintritt, ID: " + schwimmerZeigerU.getArmbandID());
        }
        schwimmbadZeigerU.vermittleSetPassendeUmlaufGeschwindigkeit();
    }
    //Auch bei Verlassen eines Besuchers wird über method reference auf den UseController verwiesen.
    //Besucher werden anhand ihrer Chiparmband-ID identifizert und aus der schwimmerArrayList entfernt.
    //Die Geschwindigkeit der Umlaufpumpe zur Wasserreinigung wird erforderlichenfalls reduziert.
    public void verlassenU_1(ActionEvent e){
        //initialisieren auf einen Wert, den armbandID von Schwimmer nie haben wird.
        int armbandIDScanner = -1;
        //Programmabbruch bei ungültiger ID vermeiden
        try {
            armbandIDScanner = rahmen_0ZeigerU.getValuetextArmbandID();
        }catch (Exception ex){
            System.out.println("LOG: " + ex);
        }
        try {
            schwimmbadZeigerU.verlassenSchw_2(armbandIDScanner);
            if (nachZahlBedingung){
                System.out.println("LOG: Aufzahlen");
                //es könnte ein Song der Beatles gestartet werden, um dem Besucher zu
                //verdeutlichen, was von ihm verlangt wird.
//                final URI uri = new URI("https://www.youtube.com/watch?v=_awAH-JJx1k");
//                Desktop.getDesktop().browse(uri);
                rahmen_0ZeigerU.setTextArmbandID("");
                rahmen_0ZeigerU.setLabel5Text("ID " + armbandIDScanner + schwimmbadZeigerU.getSprachmodulS().getUseCoZahlaufforderungSFV());
            }else{
            rahmen_0ZeigerU.setLabel5Text(schwimmbadZeigerU.getInfoID());
            rahmen_0ZeigerU.setTextArmbandID("");}
        }catch (Exception ex){
            System.out.println("LOG: " + ex);
        }
        schwimmbadZeigerU.vermittleSetPassendeUmlaufGeschwindigkeit();
        //Wiederherstellen Ausgangslage:
        nachZahlBedingung = false;
    }

    public String[] listeAnteileAnEinnahmenNachTarifgruppenU(){
        String zeilenArray[] = {schwimmbadZeigerU.errechneAnteileAnEinnahmenVollzahler(),
                schwimmbadZeigerU.errechneAnteileAnEinnahmenSenioren(),
                schwimmbadZeigerU.errechneAnteileAnEinnahmenSchueler()};
        return zeilenArray;
    }

    //******************
    //Betreuung und Kontrolle des Bargeldannahmeautomaten:
    //******************
    public void leereGeldBehaelter(){
        Date date = new Date();
        format.format(date);
        System.out.println("LOG:" + format.format(date));
        String zeitstempel = format.format(date);
        schwimmbadZeigerU.getBargeldAnnahmeAutomat().setZeitstempelEntleerung(zeitstempel);
    }

    public void reSetZeitstempelKontrolle(){
        Date date = new Date();
        format.format(date);
        System.out.println("LOG:" + format.format(date));
        String zeitstempel = format.format(date);
        schwimmbadZeigerU.getBargeldAnnahmeAutomat().SetZeitstempelKontrolle(zeitstempel);
    }

    //******************
    //GUI Fensterwechsel:
    //******************
    //Weiterleitung nach Schaltfläche 'Administration'
    public void leiteZu_1_Admin(ActionEvent e){
        rahmen_0ZeigerU.dispose();
        rahmenAdmin1ZeigerU = new Rahmen_1_Admin(this);
    }

    public void leiteZu_5_Beschwerde(ActionEvent e){
        rahmen_0ZeigerU.dispose();
        rahmen_5_beschwerdeZeigerU = new Rahmen_5_Beschwerde(this);
    }

    //Logik Button 'Haustechnik' in RahmenAdmin1

    public void leiteZu_2_CodeabfrageHaustechnik(ActionEvent e){
        rahmenAdmin1ZeigerU.dispose();
        rahmen_2_Codeabfrage = new Rahmen_2_Codeabfrage(this);
        rahmen_2_Codeabfrage.labelSetText(schwimmbadZeigerU.getSprachmodulS().getZugangscodeUseCoSFV() + "99");
    }

    public void leiteZu_2_CodeabfrageManager(ActionEvent e){
        rahmenAdmin1ZeigerU.dispose();
        rahmen_2_Codeabfrage = new Rahmen_2_Codeabfrage(this);
        rahmen_2_Codeabfrage.labelSetText(schwimmbadZeigerU.getSprachmodulS().getZugangscodeUseCoSFV() + "11");
    }

    public void leiteZu_2_CodeabfrageAutomatBetreuer(ActionEvent e){
        rahmenAdmin1ZeigerU.dispose();
        rahmen_2_Codeabfrage = new Rahmen_2_Codeabfrage(this);
        rahmen_2_Codeabfrage.labelSetText(schwimmbadZeigerU.getSprachmodulS().getZugangscodeUseCoSFV() + "66");
    }

    public void leiteZuRahmen_3_Anwender(ActionEvent e){
    String eingabe = rahmen_2_Codeabfrage.textCodeEingabeGetText();
                switch(eingabe) {
        case "99":
            rahmen_2_Codeabfrage.dispose();
            rahmen_3_Haustechnik = new Rahmen_3_Haustechnik(this);
            break;
        case "11":
            rahmen_2_Codeabfrage.dispose();
            Rahmen_3_Manager rahmen_3_manager = new Rahmen_3_Manager(this);
            break;
        case "66":
            rahmen_2_Codeabfrage.dispose();
            Rahmen_3_AutomatBetreuer rahmen_3_AutomatBetreuer = new Rahmen_3_AutomatBetreuer(this);
            break;
        default:
            rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
            rahmen_2_Codeabfrage.dispose();
    }
}
    //Logik Button 'Zurück' für alle Rahmen auf Ebene 3
    public void zurueckSchreiten3und5AlleNach0(){
        rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
    }

    //Wechsel der Sprache
    public void wechsleZuDeutsch(ActionEvent e){
        rahmen_0ZeigerU.dispose();
        schwimmbadZeigerU.setSprachmodulS(new Sprachmodul(Sprachmodul.Sprache.DEU, this.schwimmbadZeigerU));
        rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
    }

    public void wechsleZuEnglisch(ActionEvent e){
        rahmen_0ZeigerU.dispose();
        schwimmbadZeigerU.setSprachmodulS(new Sprachmodul(Sprachmodul.Sprache.ENG, this.schwimmbadZeigerU));
        rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
    }

    public void wechsleZuRussisch(ActionEvent e){
        rahmen_0ZeigerU.dispose();
        schwimmbadZeigerU.setSprachmodulS(new Sprachmodul(Sprachmodul.Sprache.RUS, this.schwimmbadZeigerU));
        rahmen_0ZeigerU = new Rahmen_0(this, schwimmbadZeigerU);
    }


    //VERMITTLER, GETTER UND SETTER
    public Rahmen_0 getRahmen_0ZeigerU() {
        return rahmen_0ZeigerU;
    }
    public void setNachZahlBedingung(boolean nachZahlbedingung) {
        this.nachZahlBedingung = nachZahlbedingung;
    }
    public int getRufePumpeUG(){
        return schwimmbadZeigerU.rufePumpeUG();
    }
    //Vermittelt aktuelleBesucherCounter (Aufruf über Schwimmbad an Pumpe)
    public int getaktuelleBesucherCounterU(){
        return Schwimmbad.getAnwesendeBesucherCounter();
    }
    public int getGesamtBesucherCounterU(){
        return schwimmbadZeigerU.getGesamtBesucherCounter();
    }
    public Schwimmbad getSchwimmbadZeigerU() {
        return schwimmbadZeigerU;
    }
    public Manager getManagerZeigerU() {
        return managerZeigerU;
    }
    public Rahmen_3_Manager getRahmen_3_manager() {
        return rahmen_3_manager;
    }
    public void setRahmen_3_manager(Rahmen_3_Manager rahmen_3_manager) {
        this.rahmen_3_manager = rahmen_3_manager;
    }

    //Haustechniker kann die Umlaufpumpe für Wartungsarbeiten ab- und wieder einschalten.
    public void pumpeAnhaltenEinschalten(ActionEvent e){
        if(schwimmbadZeigerU.vermittleIsBetrieb()) {
            schwimmbadZeigerU.vermittleSetUmlaufGeschwindigkeit(0);
            rahmen_3_Haustechnik.labelUmlaufGeschwindigkeitSetText(schwimmbadZeigerU.getSprachmodulS().meldeUseConLabelUmlaufGeschwindigkeitSetText());
            schwimmbadZeigerU.vermittleSetBetrieb(false);
        }else{
            schwimmbadZeigerU.vermittleSetPassendeUmlaufGeschwindigkeit();
            schwimmbadZeigerU.vermittleSetBetrieb(true);
            rahmen_3_Haustechnik.labelUmlaufGeschwindigkeitSetText(schwimmbadZeigerU.getSprachmodulS().meldeUseConLabelUmlaufGeschwindigkeitSetText());
        }
    }

}//end UseControler
