package model.schwimmer;

import model.schwimmbad.Schwimmbad;

import java.time.Duration;
import java.time.Instant;

public abstract class Schwimmer {
    //aus einem Bezahlautomaten werden Chiparmbänder in verschiedenen Farben ausgegeben.
    //Farbcodierung steht für unterschiedliche Tarife und soll stichprobenartige Kontrolle
    //ermöglichen.
    private String tarifGruppe;
    //tarifBezeichnung kann über Sprachmodul an Benutzer angepasst werden
    private String tarifBezeichnung;
    private double preis;
    private int besuchsDauer;
    private boolean kurzzeit;
    private static int idCounter = 0;
    private int armbandID;
    private Instant instantEintreten;
    private Instant instantVerlassen;
    private Duration duration;
    private Schwimmbad schwimmbad;

    //ctr
    public Schwimmer(String tarifGruppe, double preis, int besuchsDauer, boolean kurzzeit, Schwimmbad pSch){
        this.tarifGruppe = tarifGruppe;
        this.preis = preis;
        this.besuchsDauer = besuchsDauer;
        this.kurzzeit = kurzzeit;
        this.schwimmbad = pSch;
        this.armbandID = Schwimmer.idCounter++;
    }//end ctr




    public String gebeAusDuration(){
        long h = this.getDuration().toHours();
        long m = this.getDuration().toMinutesPart();
        long s = this.getDuration().toSecondsPart();
        //String format specifier: decimal integer, führende Nullen, 2 Stellen
        String durFormatiert = String.format("%02d:%02d:%02d", h, m, s);
        String tarifBezeichnung;
        switch (this.getTarifGruppe()){
            case "Vollzahler":
                tarifBezeichnung = schwimmbad.getSprachmodulS().getVollTarifgruppeSFV();
                break;
            case "Senior":
                tarifBezeichnung = schwimmbad.getSprachmodulS().getSeniorTarifgruppeSFV();
                break;
            default:
                tarifBezeichnung = schwimmbad.getSprachmodulS().getSchuelerTarifgruppeSFV();
                break;
        }
        String ausgabe = "(" + tarifBezeichnung + getSchwimmbad().getSprachmodulS().getSchwimmerBesuchsdauerSFV() + durFormatiert + ")";
        //System.out.println("LOG: " + durFormatiert);
        return ausgabe;
    }

    //abstrakte Methode
    public abstract void speichereDuration();

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String toString(){
        String tarif = schwimmbad.getSprachmodulS().meldeTarifBezeichner(this);
        String k = schwimmbad.getSprachmodulS().meldeKurzzeit(this);
        return "\nID " + armbandID + ": "
                + tarif
                + k;
    }

    //Getter und Setter
    public boolean isKurzzeit() {
        return kurzzeit;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public void setBesuchsDauer(int besuchsDauer) {
        this.besuchsDauer = besuchsDauer;
    }
    public void setKurzzeit(boolean kurzzeit) {
        this.kurzzeit = kurzzeit;
    }
    public double getPreis(){
        return this.preis;
    }

    public int getArmbandID() {
        return armbandID;
    }
    public String getTarifGruppe() {
        return tarifGruppe;
    }
    public void setTarifBezeichnung(String tarifBezeichnung) {
        this.tarifBezeichnung = tarifBezeichnung;
    }
    public Instant getInstantEintreten() {
        return instantEintreten;
    }
    public void setInstantEintreten(Instant instantEintreten) {
        this.instantEintreten = instantEintreten;
    }
    public Instant getInstantVerlassen() {
        return instantVerlassen;
    }
    public void setInstantVerlassen(Instant instantVerlassen) {
        this.instantVerlassen = instantVerlassen;
    }
    public Duration getDuration() {
        return duration;
    }
    public Schwimmbad getSchwimmbad() {
        return schwimmbad;
    }
    public int getBesuchsDauer() {
        return besuchsDauer;
    }
}//end class
