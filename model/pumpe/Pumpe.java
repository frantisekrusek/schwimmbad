package model.pumpe;

import model.schwimmbad.Schwimmbad;

//eine Umwälzpumpe pumpt das Badewasser in einen Kreislauf, in dem es durchgängig
//gereinigt werden kann
public class Pumpe {
    //Umlaufgeschwindigkeit erhöht sich und sinkt mit veränderter Zahl der Badegäste:
    //500l/min Standardbetrieb
    //550l/min ab 2 Badegästen
    //600l/min ab 10 Badegästen
    private boolean betrieb;
    //Warum statische Eigenschaften? - Es gibt nur eine Instanz.
    private static int umlaufGeschwindigkeit;

    //ctr
    public Pumpe() {
        this.betrieb = true;
        this.umlaufGeschwindigkeit = 500;
    }//end ctr

    //sobald ein Schwimmer das Bad betritt oder verlässt, werden BesucherCounter überprüft und umlaufGeschwindigkeit
    //angepasst
    public static void setPassendeUmlaufGeschwindigkeit() {
        if(Schwimmbad.getAnwesendeBesucherCounter() < 2) {
            Pumpe.umlaufGeschwindigkeit = 500;
        }else if(Schwimmbad.getAnwesendeBesucherCounter() >= 2 && Schwimmbad.getAnwesendeBesucherCounter() < 10) {
            Pumpe.umlaufGeschwindigkeit = 550;
        }else if(Schwimmbad.getAnwesendeBesucherCounter() >= 10) {
            Pumpe.umlaufGeschwindigkeit = 600;
        }
    }

    //Getter und Setter:
    public boolean isBetrieb() {
        return betrieb;
    }
    public void setBetrieb(boolean betrieb) {
        this.betrieb = betrieb;
    }
    public static int getUmlaufGeschwindigkeit() {
        return umlaufGeschwindigkeit;
    }
    public static void setUmlaufGeschwindigkeit(int umlaufGeschwindigkeit) {
        Pumpe.umlaufGeschwindigkeit = umlaufGeschwindigkeit;
    }
}//end Pumpe






