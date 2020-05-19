package start;

import model.schwimmbad.Manager;
import model.useController.UseController;

public class Start {
    public static void main(String[] args) {
        //UseController startet Rahmen_0, welcher als Bedienfeld des Automaten
        //am Eingang und Ausgang des Schwimmbades sowie am Desktop im Büro des
        //Managers folgenden Gruppen Zugriff auf Programmfunktionen gewährt:
        //-Besucher
        //-Manager
        //-Haustechniker
        //-Automatenbetreuuer
        new UseController();
        }//end main

    }//end Start
