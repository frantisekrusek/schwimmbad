package model.schwimmer.schueler;

import model.schwimmbad.Schwimmbad;
import model.schwimmer.Schwimmer;

import java.net.SocketTimeoutException;
import java.time.Duration;

public class Schueler extends Schwimmer {
    //default Besuchsdauer entspricht der gesamten Öffnungszeit.
    //Bei Kauf "Kurzzeitkarte" wird die Besuchsdauer herabgesetzt.
    //Soll Kontrolle der tatsächlichen Besuchsdauer bei Verlassen des Bades
    //und allfällige Nachzahlung ermöglichen.
    //ctr
    public Schueler(boolean kurzzeit, Schwimmbad pSch){
        super("Schueler", 5.0, 12, kurzzeit, pSch);
        if (kurzzeit){
            this.setPreis(3.0);
            this.setBesuchsDauer(2);
            this.setKurzzeit(true);
        }//end if
        this.setTarifBezeichnung(getSchwimmbad().getSprachmodulS().getSchuelerTarifgruppeSFV());
    }//end ctr

    //Besuchsdauer wird der ArrayList<Duration> schuelerBesuche hinzugefügt.
    @Override
    public void speichereDuration(){
        this.getSchwimmbad().getSchuelerBesuche().add(this.getDuration());
    }

}//end class
