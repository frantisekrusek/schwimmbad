package model.schwimmbad;

import model.schwimmer.Schwimmer;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Sprachmodul {
    private Schwimmbad schwimmbad;

    public enum Sprache {DEU, ENG, RUS}
    private Sprache sprache;


    //Bei Hinzufügung weiterer Sprache sind SchriftFestlegungsVariablen dieser Klasse neu zu belegen
    // und die 'melde..'-Methoden zu erweitern.
    //Darüber hinaus zu Beachten:
    //Manager.liesBeschwerden()
    //..SFV steht für SchriftFestlegungsVariable

    private String vollTarifgruppeSFV, seniorTarifgruppeSFV, schuelerTarifgruppeSFV;
    private String zurueck;
    //Rahmen_0
    private String rahmen_0titleSFV,
            vollzahlerButtonSFV, seniorButtonSFV, schuelerButtonSFV,
            checkBoxKurzzeitSFV,
            beschwerdeSFV,
            werbung00SFV, werbung011SFV, werbung012SFV, werbung013SFV,
            werbung02SFV, werbung10SFV, werbung11SFV, werbung12SFV,
            werbung13SFV, werbung14SFV, werbung15SFV, werbung16SFV,
            werbung17SFV,
            administrationSFV,
            label7SFV, buttonVerlassenSFV, schwBadAbschiedSFV,
            schwimmerBesuchsdauerSFV,
            useCoZahlaufforderungSFV,
            buttonFeueralarmSFV, label5FluchtSFV, label5ChipleseFehlerSFV,
            label5BadLeerSFV, tooltipAnhaltenSFV;
    //Rahmen_1
    private String haustechRahmen_1SFV, bargeldRahmen_1SFV, managerRahmen_1SFV, wohinRahm_1SFV;
    //Rahmen_2
    private String rahmen_2titleSFV, rahm_2weiterSFV;
    //Rahmen_3_AutomatBetreuer
    private String rahmen_3AutoTitleSFV, rahm_3AutoleereSFV;
    //Rahmen_3_Haus
    private String rahmen_3HausTitleSFV, rahmen_3HausOnOffSFV, rahmen_3HausBesucherDerzeitSFV;
    //Rahmen_3_Manager
    private String schwibaEinnahmenVonSFV, schwibaVollzahlernSFV, schwibaSeniorenSFV,
            schwibaSchuelernSFV, schwibaProzentSFV, rahmen_3ManNeuerWerbeSFV, rahmen_3ManZeigeBesucherSFV,
            rahmen_3ManErrechneUmsatzSFV, rahmen_3ManZeigeBesuchsdauerSFV, rahmen_3ManPruefeKasseSFV,
            rahmen_3ManLiesBeschwerdenSFV, rahmen_3ManEntsorgeBeschwerdenSFV, rahmen_3ManVollzahlerSFV,
            rahmen_3ManSeniorenSFV, rahmen_3ManSchuelerSFV, rahmen_3ManDurchschnittDauerSFV, rahmen_3ManLetztePruefungSFV,
            rahmen_3ManLetzteEntleerungSFV, rahmen_3ManSeitDerLetzten1SFV, rahmen_3ManSeitDerLetzten2SFV,
            rahmen_3ManZurBankGebrachtSFV, rahmen_3ManGleicheAbSFV, managerBeschwerdenVernichtetSFV;
    //Rahmen_4
    private String label1UeberschrittenSFV, naGutSFV, rahmen_4titleSFV;
    //Rahmen_5
    private String buttonSendeRahmen_5SFV, feedbackRahmen_5SFV, dankeMitteilungRahmen_5SFV;
    //useController
    private String zugangscodeUseCoSFV;



    //ctr
    public Sprachmodul(Sprache pCtrSprache, Schwimmbad pSchwimmbad){
        this.schwimmbad = pSchwimmbad;
        this.sprache = pCtrSprache;
        this.waehleSprache(pCtrSprache);
    }//end ctr

    public Sprache waehleSprache (Sprache pWaehSprache){
        switch (pWaehSprache){
            case DEU:
                zurueck = "Zurück";
                // RAHMEN_0
                // Links
                rahmen_0titleSFV = "    Herzlich Willkommen in Franzis Sportbad!                           *Java-Projekt František Rusek 2020*";
                vollzahlerButtonSFV = "Vollpreis €10,0 (€8,0 kurz)";
                seniorButtonSFV = "Senioren €6,0 (€4,0 kurz)";
                schuelerButtonSFV = "Schüler €5,0 (€3,0 kurz)";
                checkBoxKurzzeitSFV = "<html><body>Kurzzeit (zu Demonstrationszweck<br/>auf 3 Sekunden gesetzt.)</body></html>";
                beschwerdeSFV = "Beschwerde";
                // Mitte
                //WERBE-THREAD
                werbung00SFV = "Guten Tag!";
                werbung011SFV = "~ Alle Schwimmbahnen unbesetzt ~";
                werbung012SFV = "~ Noch viele Bahnen frei ~";
                werbung013SFV = "Bahnen derzeit gut ausgelastet.";
                werbung02SFV = "Ermäßigung für Kurzzeitbesucher.";
                werbung10SFV = "und jetzt WERBUNG:";
                werbung11SFV = "Threading.";
                werbung12SFV = "Polymorphie.";
                werbung13SFV = "<html><body>Abschlussprojekt WIFI-Kurs<br/>" +
                        "Software Developer Java.<br/>" +
                        "František Rusek, April 2020.</body></html>";
                werbung14SFV = "Streams.";
                werbung15SFV = "<html><body>Nachzahlung bei Zeitüberschreitung<br/>" +
                        "Kurzzeitbesucher.</body></html>";
                werbung16SFV = "<html><body>Besucherstatistiken<br/>" +
                        "(Manageransicht)</body></html>";
                werbung17SFV = "Wir freuen uns über Ihren Besuch!";
                administrationSFV = "Administration";
                //Rechts
                label7SFV = "<html><body>Durch Zifferneingabe der ArmbandID<br>" +
                        "wird das Auslesen des Chiparmbandes " +
                        "per Sensor simuliert</body></html>"; //34 chars per row
                buttonVerlassenSFV = "Bad verlassen";
                schwBadAbschiedSFV = "Auf Wiedersehen ";
                schwimmerBesuchsdauerSFV = ", Besuchsdauer: ";
                useCoZahlaufforderungSFV = ", bitte aufzahlen";
                vollTarifgruppeSFV = "Vollzahler";
                seniorTarifgruppeSFV = "Senior";
                schuelerTarifgruppeSFV = "Schüler";
                buttonFeueralarmSFV = "Feueralarm";
                label5FluchtSFV = "<html><body>Alle Besucher verlassen <br/>das Schwimmbad \uD83D\uDE10</body></html>";
                label5ChipleseFehlerSFV = "Chiparmband nicht erkannt.";
                label5BadLeerSFV = "Das Bad ist schon leer! ";
                tooltipAnhaltenSFV = "bitte halten Sie das Chiparmband an den Sensor";
                //Rahmen_1
                haustechRahmen_1SFV = "Haustechnik";
                bargeldRahmen_1SFV = "Bargeldautomat";
                managerRahmen_1SFV = "Manager";
                wohinRahm_1SFV = "Wohin?";
                //Rahmen_2
                rahmen_2titleSFV = "Code";
                rahm_2weiterSFV = "Weiter";
                //Rahmen_3_AutomatBetreuer
                rahmen_3AutoTitleSFV = "Betreuer";
                rahm_3AutoleereSFV = "Entleere Geldbehälter";
                //Rahmen_3 Haustechnik
                rahmen_3HausTitleSFV = "Haustechnik:";
                rahmen_3HausOnOffSFV = "Pumpe ON/OFF";
                rahmen_3HausBesucherDerzeitSFV = "Besucher im Bad derzeit: ";
                //Rahmen_3_Manager
                schwibaEinnahmenVonSFV = "Einnahmen von ";
                schwibaVollzahlernSFV = " Vollzahler(n) ";
                schwibaSeniorenSFV = " Senioren ";
                schwibaSchuelernSFV = " Schüler(n) ";
                schwibaProzentSFV = "% der Gesamteinnahmen";
                rahmen_3ManNeuerWerbeSFV = "Neuer Werbetext";
                rahmen_3ManZeigeBesucherSFV = "zeige anwesende Besucher";
                rahmen_3ManErrechneUmsatzSFV = "Errechne Umsatzanteile";
                rahmen_3ManZeigeBesuchsdauerSFV = "Zeige Besuchsdauer nach Tarifgruppen";
                rahmen_3ManPruefeKasseSFV = "Prüfe Kasse";
                rahmen_3ManLiesBeschwerdenSFV = "Lies Beschwerden";
                rahmen_3ManEntsorgeBeschwerdenSFV = "Entsorge Beschwerden";
                rahmen_3ManVollzahlerSFV = "Vollzahler";
                rahmen_3ManSeniorenSFV = "Senioren";
                rahmen_3ManSchuelerSFV = "Schüler";
                rahmen_3ManDurchschnittDauerSFV = "Durchschnittliche Besuchsdauer:   ";
                rahmen_3ManLetztePruefungSFV = "Letzte Überprüfung: ";
                rahmen_3ManLetzteEntleerungSFV = "Letzte Entleerung:  ";
                rahmen_3ManSeitDerLetzten1SFV = "Seit der letzten Überprüfung wurden €";
                rahmen_3ManSeitDerLetzten2SFV = " der Kasse entnommen.";
                rahmen_3ManZurBankGebrachtSFV = "Der Automatenbetreuuer hat das entnommene Bargeld zur Bank gebracht.";
                rahmen_3ManGleicheAbSFV = "Manager, gleiche den Betrag mit deinen Kontoeingängen ab! ";
                managerBeschwerdenVernichtetSFV = "Alle Beschwerde-Dateien erfolgreich gelöscht!";

                //Rahmen_4
                label1UeberschrittenSFV = "<html><body>Kurzzeit überschritten, <br/>bitte aufzahlen!</body><html>";
                naGutSFV = "na gut, aufzahlen";
                rahmen_4titleSFV = "Nachzahlen";
                buttonSendeRahmen_5SFV = "Sende Beschwerde";
                feedbackRahmen_5SFV = "Bitte um Ihr Feedback:\n";
                dankeMitteilungRahmen_5SFV = "Danke für Ihre Mitteilung!";
                //useController
                zugangscodeUseCoSFV = "Zugangscode ";

                //end DEU
                break;
            case ENG:
                zurueck = "Back";
                // RAHMEN_0
                // Links
                rahmen_0titleSFV = "    Welcome to Franzi´s Sports Pool!                           *Java-Project František Rusek 2020*";
                vollzahlerButtonSFV = "Full Price €10,0 (€8,0 Short)"; //29 chars
                seniorButtonSFV = "Senior €6,0 (€4,0 Short)";
                schuelerButtonSFV = "Student €5,0 (€3,0 Short)";
                checkBoxKurzzeitSFV = "<html><body>Short-Time (Set to 3 seconds for<br/>demonstration purposes.)</body></html>";
                beschwerdeSFV = "<html><body>Write<br/>Complaint<body><html>";
                // Mitte
                //WERBE-THREAD
                werbung00SFV = "We wish you a good day!";
                werbung011SFV = "~ All swimming lanes empty ~";
                werbung012SFV = "<html><body>~ Unoccupied swimming lanes<br/>available ~<body><html>";
                werbung013SFV = "Lanes might be full";
                werbung02SFV = "Discount for short-term visitors.";
                werbung10SFV = "now ADVERTISEMENT:";
                werbung11SFV = "Multithreading.";
                werbung12SFV = "Polymorphism.";
                werbung13SFV = "<html><body>Exam project WIFI-Course<br/>" +
                        "Software Developer Java.<br/>" +
                        "František Rusek, April 2020.</body></html>";
                werbung14SFV = "Streams.";
                werbung15SFV = "<html><body>\n" +
                        "Subsequent payment<br/>if time is exceeded<br/>" +
                        "by short-term visitors.</body></html>";
                werbung16SFV = "<html><body>Visitor Statistics<br/>" +
                        "(Manager View)</body></html>";
                werbung17SFV = "We thank you for visiting!";
                administrationSFV = "Administration";
                //Rechts
                label7SFV = "<html><body>Entering the number of the<br/>" +
                        "wristband ID simulates the reading<br/>" +
                        "of the chip-wristband by a sensor<br>"; //34 chars per row
                buttonVerlassenSFV = "Leave Swimming Bath";
                schwBadAbschiedSFV = "Goodbye ";
                schwimmerBesuchsdauerSFV = ", Duration of Stay: ";
                useCoZahlaufforderungSFV = ", additional payments required!";
                vollTarifgruppeSFV = "Fullprice";
                seniorTarifgruppeSFV = "Senior";
                schuelerTarifgruppeSFV = "Student";
                buttonFeueralarmSFV = "Fire alarm";
                label5FluchtSFV = "<html><body>All visitors leave the Bath. \uD83D\uDE10</body></html>";
                label5ChipleseFehlerSFV = "Chip Reading Error.";
                label5BadLeerSFV = "Swimming Bath is empty! ";
                tooltipAnhaltenSFV = "please hold the chip-wristband to the sensor";
                //Rahmen_4
                label1UeberschrittenSFV = "<html><body>Time exceeded, <br/>please add up!</body><html>";
                naGutSFV = "Ok, I pay the surcharge";
                rahmen_4titleSFV = "Surcharge";
                //Rahmen_5
                buttonSendeRahmen_5SFV = "Send complaint";
                feedbackRahmen_5SFV = "Give us your feedback:\n";
                dankeMitteilungRahmen_5SFV = "Thank you for your notification!";
                //Rahmen_1
                haustechRahmen_1SFV = "House Engineer";
                bargeldRahmen_1SFV = "Teller Machine";
                managerRahmen_1SFV = "Manager";
                wohinRahm_1SFV = "Select:";
                //Rahmen_2
                rahmen_2titleSFV = "Code";
                rahm_2weiterSFV = "Continue";
                //Rahmen_3_AutomatBetreuer
                rahmen_3AutoTitleSFV = "Cashier";
                rahm_3AutoleereSFV = "Collect Money";
                zugangscodeUseCoSFV = "Access code ";
                //Rahmen_3 Haustechnik
                rahmen_3HausTitleSFV = "House Engineer:";
                rahmen_3HausOnOffSFV = "Turn Pump ON/OFF";
                rahmen_3HausBesucherDerzeitSFV = "Visitors at the moment: ";
                //Rahmen_3_Manager
                schwibaEinnahmenVonSFV = "Revenue from ";
                schwibaVollzahlernSFV = " Full Price Visitor(s) ";
                schwibaSeniorenSFV = " Senior Visitor(s) ";
                schwibaSchuelernSFV = " Student Visitor(s) ";
                schwibaProzentSFV = "% of Total Revenue";
                rahmen_3ManNeuerWerbeSFV = "Customize Promotion";
                rahmen_3ManZeigeBesucherSFV = "List present Visitors";
                rahmen_3ManErrechneUmsatzSFV = "Calculate Sales Proportion";
                rahmen_3ManZeigeBesuchsdauerSFV = "Duration of visit by tariff group";
                rahmen_3ManPruefeKasseSFV = "Check cash register";
                rahmen_3ManLiesBeschwerdenSFV = "Read complaints";
                rahmen_3ManEntsorgeBeschwerdenSFV = "Dispose complaints";
                rahmen_3ManVollzahlerSFV = "Full Price Visitors";
                rahmen_3ManSeniorenSFV = "Senior Visitors";
                rahmen_3ManSchuelerSFV = "Student Visitors";
                rahmen_3ManDurchschnittDauerSFV = "average length of visit:   ";
                rahmen_3ManLetztePruefungSFV = "Last Review: ";
                rahmen_3ManLetzteEntleerungSFV = "Last Collection:  ";
                rahmen_3ManSeitDerLetzten1SFV = "€ ";
                rahmen_3ManSeitDerLetzten2SFV = " have been collected since the last Review.";
                rahmen_3ManZurBankGebrachtSFV = "The money collector has brought the collected money to the bank.";
                rahmen_3ManGleicheAbSFV = "Manager, compare the amount with your bankaccount receipts! ";
                managerBeschwerdenVernichtetSFV = "All complaint files were deleted successfully!";


                //end case ENG
                break;

            case RUS:
                zurueck = "К сожалению я не говорю по русски";
                // RAHMEN_0
                // Links
                rahmen_0titleSFV = "    Добро пожаловать в бассейн Франци!                           *Java проект Франтишек Русек 2020*";
                vollzahlerButtonSFV = "К сожалению я не говорю по русски";
                seniorButtonSFV = "К сожалению я не говорю по русски";
                schuelerButtonSFV = "К сожалению я не говорю по русски";
                checkBoxKurzzeitSFV = "К сожалению я не говорю по русски";
                beschwerdeSFV = "<html><body>Написать<br/>жалобу<body><html>";
                // Mitte
                //WERBE-THREAD
                werbung00SFV = "Добрый день!!";
                werbung011SFV = "К сожалению я не говорю по русски";
                werbung012SFV = "К сожалению я не говорю по русски";
                werbung013SFV = "К сожалению я не говорю по русски";
                werbung02SFV = "К сожалению я не говорю по русски";
                werbung10SFV = "К сожалению я не говорю по русски";
                werbung11SFV = "К сожалению я не говорю по русски";
                werbung12SFV = "К сожалению я не говорю по русски";
                werbung13SFV = "<html><body>Окончательный проект WIFI-Kurs<br/>" +
                        "Software Developer Java.<br/>" +
                        "František Rusek, April 2020.</body></html>";
                werbung14SFV = "К сожалению я не говорю по русски";
                werbung15SFV = "К сожалению я не говорю по русски";
                werbung16SFV = "К сожалению я не говорю по русски";
                werbung17SFV = "Мы с нетерпением ждем вашего визита!";
                administrationSFV = "администрация";
                //Rechts
                label7SFV = "<html><body>К сожалению<br>" +
                        "я не говорю " +
                        "по русски</body></html>"; //34 chars per row
                buttonVerlassenSFV = "К сожалению я не говорю по русски";
                schwBadAbschiedSFV = "До свидания ";
                schwimmerBesuchsdauerSFV = ", Продолжительность визита: ";
                useCoZahlaufforderungSFV = ", платить!";
                vollTarifgruppeSFV = "К сожалению я не говорю по русски";
                seniorTarifgruppeSFV = "старший";
                schuelerTarifgruppeSFV = "студент";
                buttonFeueralarmSFV = "Пожарная сигнализация";
                label5FluchtSFV = "<html><body>К сожалению я не<br/>говорю по русски \uD83D\uDE10</body></html>";
                label5ChipleseFehlerSFV = "К сожалению я не говорю по русски";
                label5BadLeerSFV = "В ванной комнате уже пусто! ";
                tooltipAnhaltenSFV = "К сожалению я не говорю по русски";
                //Rahmen_1
                haustechRahmen_1SFV = "домашняя техника";
                bargeldRahmen_1SFV = "К сожалению я не говорю по русски";
                managerRahmen_1SFV = "менеджер";
                wohinRahm_1SFV = "Куда?";
                //Rahmen_2
                rahmen_2titleSFV = "К сожалению я не говорю по русски";
                rahm_2weiterSFV = "более";
                //Rahmen_3_AutomatBetreuer
                rahmen_3AutoTitleSFV = "К сожалению я не говорю по русски";
                rahm_3AutoleereSFV = "К сожалению я не говорю по русски";
                //Rahmen_3 Haustechnik
                rahmen_3HausTitleSFV = "К сожалению я не говорю по русски";
                rahmen_3HausOnOffSFV = "насос ON/OFF";
                rahmen_3HausBesucherDerzeitSFV = "К сожалению я не говорю по русски";
                //Rahmen_3_Manager
                schwibaEinnahmenVonSFV = "К сожалению я не говорю по русски";
                schwibaVollzahlernSFV = "К сожалению я не говорю по русски";
                schwibaSeniorenSFV = "К сожалению я не говорю по русски";
                schwibaSchuelernSFV = "К сожалению я не говорю по русски";
                schwibaProzentSFV = "К сожалению я не говорю по русски";
                rahmen_3ManNeuerWerbeSFV = "К сожалению я не говорю по русски";
                rahmen_3ManZeigeBesucherSFV = "К сожалению я не говорю по русски";
                rahmen_3ManErrechneUmsatzSFV = "К сожалению я не говорю по русски";
                rahmen_3ManZeigeBesuchsdauerSFV = "К сожалению я не говорю по русски";
                rahmen_3ManPruefeKasseSFV = "К сожалению я не говорю по русски";
                rahmen_3ManLiesBeschwerdenSFV = "Читать жалобы";
                rahmen_3ManEntsorgeBeschwerdenSFV = "К сожалению я не говорю по русски";
                rahmen_3ManVollzahlerSFV = "К сожалению я не говорю по русски";
                rahmen_3ManSeniorenSFV = "К сожалению я не говорю по русски";
                rahmen_3ManSchuelerSFV = "К сожалению я не говорю по русски";
                rahmen_3ManDurchschnittDauerSFV = "К сожалению я не говорю по русски";
                rahmen_3ManLetztePruefungSFV = "К сожалению я не говорю по русски";
                rahmen_3ManLetzteEntleerungSFV = "К сожалению я не говорю по русски";
                rahmen_3ManSeitDerLetzten1SFV = "К сожалению я не говорю по русски";
                rahmen_3ManSeitDerLetzten2SFV = "К сожалению я не говорю по русски";
                rahmen_3ManZurBankGebrachtSFV = "К сожалению я не говорю по русски";
                rahmen_3ManGleicheAbSFV = "К сожалению я не говорю по русски";
                managerBeschwerdenVernichtetSFV = "К сожалению я не говорю по русски";

                //Rahmen_4
                label1UeberschrittenSFV = "<html><body>Превышено короткое время, <br/>bitte aufzahlen!</body><html>";
                naGutSFV = "К сожалению я не говорю по русски";
                rahmen_4titleSFV = "приплачивать";
                buttonSendeRahmen_5SFV = "Отправить жалобу";
                feedbackRahmen_5SFV = "Спросите свой отзыв:\n";
                dankeMitteilungRahmen_5SFV = "Спасибо за ваше сообщение!";
                //useController
                zugangscodeUseCoSFV = "Код доступа ";

                //end RUS
                break;
        }
        return pWaehSprache;
    }//end waehleSprache()

    //String soll aktuelle Uhrzeit wiedergeben, daher dynamisch über Methodenaufruf
    public String meldeRahm_3Label1EntnahmeSFM(){
        String ausgabe = "";
        switch (sprache){
            case DEU:
                ausgabe = "<html><body>" + schwimmbad.getBargeldAnnahmeAutomat().getZeitstempelEntleerung() +" Uhr" + "<br/>" +
                        "Entnahme von € " +
                        (BargeldAnnahmeAutomat.getEinnahmenCounter() - BargeldAnnahmeAutomat.getEinnahmenStandBeiLetzterEntleerung()) + "<br/>" +
                        "Zähler wurde zurückgesetzt!";
                break;
            case ENG:
                ausgabe = "<html><body>" + "Time: " + schwimmbad.getBargeldAnnahmeAutomat().getZeitstempelEntleerung() + "<br/>" +
                        "€ " +
                        (BargeldAnnahmeAutomat.getEinnahmenCounter() - BargeldAnnahmeAutomat.getEinnahmenStandBeiLetzterEntleerung()) + " collected." + "<br/>" +
                        "Counter has been reset!";
                break;
            case RUS:
                ausgabe = "<html><body>" + "Time: " + schwimmbad.getBargeldAnnahmeAutomat().getZeitstempelEntleerung() + "<br/>" +
                        "€ " +
                        (BargeldAnnahmeAutomat.getEinnahmenCounter() - BargeldAnnahmeAutomat.getEinnahmenStandBeiLetzterEntleerung()) + " collected." + "<br/>" +
                        "К сожалению я не говорю по русски";
                break;
        }
        return ausgabe;
    }//end setRahm_3Label1EntnahmeSFV

    public String meldeUseConLabelUmlaufGeschwindigkeitSetText(){
        String ausgabe = "";
        switch (sprache){
            case DEU:
                ausgabe = "<html><body>Pumpe Geschwindigkeit<br>derzeit: " + schwimmbad.rufePumpeUG() + "l/min" + "</body></html>";
                break;
            case ENG:
                //todo: auf Gallonen umrechnen:  Gallone entspricht genau 4,54609 l
                ausgabe = "<html><body>Current Pump Speed:<br> " + schwimmbad.rufePumpeUG() + " liters/min" + "</body></html>";
                break;
            case RUS:
                ausgabe = "<html><body>\"К сожалению я не говорю по русски\"<br> " + schwimmbad.rufePumpeUG() + " литров / мин" + "</body></html>";
                break;
        }
        return ausgabe;
    }

    public String meldeRahm_3MannLabel1setText(){
        String ausgabe = "";
        switch (sprache){
            case DEU:
                ausgabe = "<html><body>Wir hatten insgesamt " + schwimmbad.getUseControllerS().getGesamtBesucherCounterU() + " Besucher.<br/>" +
                        "Zur Zeit " + schwimmbad.getUseControllerS().getaktuelleBesucherCounterU()   + " Besucher im Bad.<br/>" +
                        "Wir haben € " + BargeldAnnahmeAutomat.getEinnahmenCounter() + " eingenommen.";
                break;
            case ENG:
                ausgabe = "<html><body>We had " + schwimmbad.getUseControllerS().getGesamtBesucherCounterU() + " Visitor(s) in total.<br/>" +
                        "There are " + schwimmbad.getUseControllerS().getaktuelleBesucherCounterU()   + " Visitor(s) in the Swimming Bath at the moment.<br/>" +
                        "Total incomings so far: € " + BargeldAnnahmeAutomat.getEinnahmenCounter() + ".";
                break;
            case RUS:
                ausgabe = "<html><body>We had " + schwimmbad.getUseControllerS().getGesamtBesucherCounterU() + "К сожалению я не говорю по русски<br/>" +
                        schwimmbad.getUseControllerS().getaktuelleBesucherCounterU()   + "К сожалению я не говорю по русски.<br/>" +
                        "К сожалению я не говорю по русски. € " + BargeldAnnahmeAutomat.getEinnahmenCounter() + ".";
                break;
        }
        return ausgabe;
    }

    public String meldeTarifBezeichner(Schwimmer schwimmer){
        String ausgabe = "";
        switch (sprache){
            case DEU:
                //Achtung, diese implementierung gilt NUR für 'DEU', Vorlage für weitere Sprachen siehe 'ENG'
                ausgabe = schwimmer.getTarifGruppe();
                break;
            case ENG:
                switch (schwimmer.getTarifGruppe()){
                    case "Vollzahler":
                        ausgabe = "Full Price";
                        break;
                    case "Senior":
                        ausgabe = "Senior";
                        break;
                    default:
                        ausgabe = "Student";
                        break;
                }
                break;
            case RUS:
                switch (schwimmer.getTarifGruppe()){
                    case "Vollzahler":
                        ausgabe = "Full Price";
                        break;
                    case "Senior":
                        ausgabe = "старший";
                        break;
                    default:
                        ausgabe = "студент";
                        break;
                }
                break;
        }
        return ausgabe;
    }

    public String meldeKurzzeit(Schwimmer schwimmer){
        String ausgabe = "";
        switch (sprache){
            case DEU:
                if(schwimmer.isKurzzeit()) {
                    ausgabe = ", Kurzzeitkarte";
                }
                break;
            case ENG:
                if(schwimmer.isKurzzeit()) {
                    ausgabe = ", short-time";
            }
                break;
            case RUS:
                if(schwimmer.isKurzzeit()) {
                    ausgabe = ", Краткосрочная карта";
                }
                break;
                }
        return ausgabe;
    }



    //GETTER
    public String getRahmen_0titleSFV() {
        return rahmen_0titleSFV;
    }
    public String getVollzahlerButtonSFV() {
        return vollzahlerButtonSFV;
    }
    public String getSeniorButtonSFV() {
        return seniorButtonSFV;
    }
    public String getSchuelerButtonSFV() {
        return schuelerButtonSFV;
    }
    public String getButtonVerlassenSFV() {
        return buttonVerlassenSFV;
    }    public String getBeschwerdeSFV() {
        return beschwerdeSFV;
    }
    public String getCheckBoxKurzzeitSFV() {
        return checkBoxKurzzeitSFV;
    }
    public String getWerbung00SFV() {
        return werbung00SFV;
    }
    public String getWerbung011SFV() {
        return werbung011SFV;
    }
    public String getWerbung012SFV() {
        return werbung012SFV;
    }
    public String getWerbung013SFV() {
        return werbung013SFV;
    }
    public String getWerbung02SFV() {
        return werbung02SFV;
    }
    public String getWerbung10SFV() {
        return werbung10SFV;
    }
    public String getWerbung11SFV() {
        return werbung11SFV;
    }
    public String getWerbung12SFV() {
        return werbung12SFV;
    }
    public String getWerbung13SFV() {
        return werbung13SFV;
    }
    public String getWerbung14SFV() {
        return werbung14SFV;
    }
    public String getWerbung15SFV() {
        return werbung15SFV;
    }
    public String getWerbung16SFV() {
        return werbung16SFV;
    }
    public String getWerbung17SFV() {
        return werbung17SFV;
    }
    public String getAdministrationSFV() {
        return administrationSFV;
    }
    public String getLabel7SFV() {
        return label7SFV;
    }
    public String getSchwBadAbschiedSFV() {
        return schwBadAbschiedSFV;
    }
    public String getSchwimmerBesuchsdauerSFV() {
        return schwimmerBesuchsdauerSFV;
    }
    public String getVollTarifgruppeSFV() {
        return vollTarifgruppeSFV;
    }
    public String getSeniorTarifgruppeSFV() {
        return seniorTarifgruppeSFV;
    }
    public String getSchuelerTarifgruppeSFV() {
        return schuelerTarifgruppeSFV;
    }
    public String getUseCoZahlaufforderungSFV() {
        return useCoZahlaufforderungSFV;
    }
    public String getButtonFeueralarmSFV() {
        return buttonFeueralarmSFV;
    }
    public String getLabel5FluchtSFV() {
        return label5FluchtSFV;
    }
    public String getLabel5ChipleseFehlerSFV() {
        return label5ChipleseFehlerSFV;
    }
    public String getLabel5BadLeerSFV() {
        return label5BadLeerSFV;
    }
    public String getLabel1UeberschrittenSFV() {
        return label1UeberschrittenSFV;
    }
    public String getNaGutSFV() {
        return naGutSFV;
    }
    public String getRahmen_4titleSFV() {
        return rahmen_4titleSFV;
    }
    public String getTooltipAnhaltenSFV() {
        return tooltipAnhaltenSFV;
    }
    public String getButtonSendeRahmen_5SFV() {
        return buttonSendeRahmen_5SFV;
    }
    public String getZurueck() {
        return zurueck;
    }
    public String getFeedbackRahmen_5SFV() {
        return feedbackRahmen_5SFV;
    }
    public String getDankeMitteilungRahmen_5SFV() {
        return dankeMitteilungRahmen_5SFV;
    }
    public String getHaustechRahmen_1SFV() {
        return haustechRahmen_1SFV;
    }
    public String getBargeldRahmen_1SFV() {
        return bargeldRahmen_1SFV;
    }
    public String getManagerRahmen_1SFV() {
        return managerRahmen_1SFV;
    }
    public String getWohinRahm_1SFV() {
        return wohinRahm_1SFV;
    }
    public String getRahmen_2titleSFV() {
        return rahmen_2titleSFV;
    }
    public String getRahm_2weiterSFV() {
        return rahm_2weiterSFV;
    }
    public String getRahmen_3AutoTitleSFV() {
        return rahmen_3AutoTitleSFV;
    }
    public String getRahm_3AutoleereSFV() {
        return rahm_3AutoleereSFV;
    }
    public String getZugangscodeUseCoSFV() {
        return zugangscodeUseCoSFV;
    }
    public String getRahmen_3HausTitleSFV() {
        return rahmen_3HausTitleSFV;
    }
    public String getRahmen_3HausOnOffSFV() {
        return rahmen_3HausOnOffSFV;
    }
    public String getRahmen_3HausBesucherDerzeitSFV() {
        return rahmen_3HausBesucherDerzeitSFV;
    }
    public String getSchwibaEinnahmenVonSFV() {
        return schwibaEinnahmenVonSFV;
    }
    public String getSchwibaVollzahlernSFV() {
        return schwibaVollzahlernSFV;
    }
    public String getSchwibaSeniorenSFV() {
        return schwibaSeniorenSFV;
    }
    public String getSchwibaSchuelernSFV() {
        return schwibaSchuelernSFV;
    }
    public String getSchwibaProzentSFV() {
        return schwibaProzentSFV;
    }
    public String getRahmen_3ManNeuerWerbeSFV() {
        return rahmen_3ManNeuerWerbeSFV;
    }
    public String getRahmen_3ManZeigeBesucherSFV() {
        return rahmen_3ManZeigeBesucherSFV;
    }
    public String getRahmen_3ManErrechneUmsatzSFV() {
        return rahmen_3ManErrechneUmsatzSFV;
    }
    public String getRahmen_3ManZeigeBesuchsdauerSFV() {
        return rahmen_3ManZeigeBesuchsdauerSFV;
    }
    public String getRahmen_3ManPruefeKasseSFV() {
        return rahmen_3ManPruefeKasseSFV;
    }
    public String getRahmen_3ManLiesBeschwerdenSFV() {
        return rahmen_3ManLiesBeschwerdenSFV;
    }
    public String getRahmen_3ManEntsorgeBeschwerdenSFV() {
        return rahmen_3ManEntsorgeBeschwerdenSFV;
    }
    public String getRahmen_3ManVollzahlerSFV() {
        return rahmen_3ManVollzahlerSFV;
    }
    public String getRahmen_3ManSeniorenSFV() {
        return rahmen_3ManSeniorenSFV;
    }
    public String getRahmen_3ManSchuelerSFV() {
        return rahmen_3ManSchuelerSFV;
    }
    public String getRahmen_3ManDurchschnittDauerSFV() {
        return rahmen_3ManDurchschnittDauerSFV;
    }
    public String getRahmen_3ManLetztePruefungSFV() {
        return rahmen_3ManLetztePruefungSFV;
    }
    public String getRahmen_3ManLetzteEntleerungSFV() {
        return rahmen_3ManLetzteEntleerungSFV;
    }
    public String getRahmen_3ManSeitDerLetzten1SFV() {
        return rahmen_3ManSeitDerLetzten1SFV;
    }
    public String getRahmen_3ManSeitDerLetzten2SFV() {
        return rahmen_3ManSeitDerLetzten2SFV;
    }
    public String getRahmen_3ManZurBankGebrachtSFV() {
        return rahmen_3ManZurBankGebrachtSFV;
    }
    public String getRahmen_3ManGleicheAbSFV() {
        return rahmen_3ManGleicheAbSFV;
    }
    public String getManagerBeschwerdenVernichtetSFV() {
        return managerBeschwerdenVernichtetSFV;
    }
    public Sprache getSprache() {
        return sprache;
    }
}//end class
