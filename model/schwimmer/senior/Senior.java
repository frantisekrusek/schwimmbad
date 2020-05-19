package model.schwimmer.senior;

import model.schwimmbad.Schwimmbad;
import model.schwimmer.Schwimmer;

public class Senior extends Schwimmer {
    //default Besuchsdauer entspricht der gesamten Öffnungszeit.
    //Bei Kauf "Kurzzeitkarte" wird die Besuchsdauer herabgesetzt.
    //Soll Kontrolle der tatsächlichen Besuchsdauer bei Verlassen des Bades
    //und allfällige Nachzahlung ermöglichen.
    //ctr
    public Senior(boolean kurzzeit, Schwimmbad pSch){
        super("Senior", 6.0, 12, kurzzeit, pSch);
        if (kurzzeit){
            this.setPreis(4.0);
            this.setBesuchsDauer(2);
            this.setKurzzeit(true);
        }
        this.setTarifBezeichnung(getSchwimmbad().getSprachmodulS().getSeniorTarifgruppeSFV());
    }//end ctr

    //Besuchsdauer wird der ArrayList<Duration> seniorenBesuche hinzugefügt.
    @Override
    public void speichereDuration(){
        this.getSchwimmbad().getSeniorenBesuche().add(this.getDuration());
    }
}//end class


