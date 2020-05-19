package model.schwimmer.vollzahler;

import model.schwimmbad.Schwimmbad;
import model.schwimmer.Schwimmer;

public class Vollzahler extends Schwimmer {
    //default Besuchsdauer entspricht der gesamten Öffnungszeit.
    //Bei Kauf "Kurzzeitkarte" wird die Besuchsdauer herabgesetzt.
    //Soll Kontrolle der tatsächlichen Besuchsdauer bei Verlassen des Bades
    //und allfällige Nachzahlung ermöglichen.
    //ctr
    public Vollzahler(boolean kurzzeit, Schwimmbad pSch) {
        super("Vollzahler", 10.0, 12, kurzzeit, pSch);
        if (kurzzeit) {
            this.setPreis(8.0);
            this.setBesuchsDauer(2);
            this.setKurzzeit(true);
        }
        this.setTarifBezeichnung(getSchwimmbad().getSprachmodulS().getVollTarifgruppeSFV());
    }//end ctr

    //Besuchsdauer wird der ArrayList<Duration> vollzahlerBesuche hinzugefügt.
    @Override
    public void speichereDuration() {
        this.getSchwimmbad().getVollzahlerBesuche().add(this.getDuration());
    }

}//end class
