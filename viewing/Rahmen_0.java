package viewing;

import model.pumpe.Pumpe;
import model.schwimmbad.Schwimmbad;
import model.schwimmer.Schwimmer;
import model.schwimmer.senior.Senior;
import model.schwimmer.vollzahler.Vollzahler;
import model.useController.UseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Rahmen_0 extends JFrame {
    private UseController useControllerZeigerR;
    private Schwimmbad schwimmbadZeigerR;
    private Schwimmer schwimmerZeigerR;
    private ArrayList<String> nachrichtenVonManager;

    private JCheckBox checkBoxKurzzeit; // = new JCheckBox(schwimmbadZeigerR.getSprachmodulS().getCheckBoxKurzzeitSFV());
    private JTextField textArmbandID = new JTextField();
    private JLabel label5 = new JLabel("");
    private JLabel label2 = new JLabel("", SwingConstants.CENTER);
    private JLabel label3 = new JLabel("", SwingConstants.CENTER);
    private JButton buttonSendeBeschwerde;

    //Konstruktor
    public Rahmen_0(UseController u, Schwimmbad s){
        this.useControllerZeigerR = u;
        this.schwimmbadZeigerR = s;
        this.nachrichtenVonManager = new ArrayList<>();
        for (String nachricht:useControllerZeigerR.getManagerZeigerU().getNachrichten()) {
            this.nachrichtenVonManager.add(nachricht);
        }
        checkBoxKurzzeit = new JCheckBox(schwimmbadZeigerR.getSprachmodulS().getCheckBoxKurzzeitSFV());
        //nebenläufige Programmierung -
        //Information für Badegäste wird auf Benutzeroberfläche angezeigt.
        Thread werbungThread = new Thread(new Werbung());
        werbungThread.start();
        Thread variableWerbung = new Thread(new VariableWerbung());
        variableWerbung.start();

        //Zeilenumbruch mithilfe von HTML - gefunden auf https://www.java-forum.org/thema/zeilenumbruch-in-einem-jlabel.82534/
        JButton buttonVollpreis = new JButton(schwimmbadZeigerR.getSprachmodulS().getVollzahlerButtonSFV());   JLabel label1 = new JLabel("", SwingConstants.CENTER);       JLabel label7 = new JLabel(schwimmbadZeigerR.getSprachmodulS().getLabel7SFV());
        JButton buttonSenioren = new JButton(schwimmbadZeigerR.getSprachmodulS().getSeniorButtonSFV());        /*JLabel label2 = new JLabel()*/;                                 JButton buttonVerlassen = new JButton(schwimmbadZeigerR.getSprachmodulS().getButtonVerlassenSFV());
        JButton buttonSchueler = new JButton((schwimmbadZeigerR.getSprachmodulS().getSchuelerButtonSFV()));    /*JLabel label3 = new JLabel();*/                                 /*label5*/
        /*checkboxKurz*/                                                                                       JLabel label4 = new JLabel();                                     JButton feueralarmButton = new JButton(schwimmbadZeigerR.getSprachmodulS().getButtonFeueralarmSFV());

        //Quelle Icon: http://www.iconarchive.com/show/ios7-icons-by-icons8/Sports-Swimming-icon.html
        //license: https://icons8.com
        Icon iconSchwimmer = new ImageIcon(".//src//resources//Sports-Swimming-icon.png");
        label1.setIcon(iconSchwimmer);

        JLabel label0 = new JLabel("");
        JButton administration = new JButton(schwimmbadZeigerR.getSprachmodulS().getAdministrationSFV());
        JPanel jPanel0 = new JPanel();
        jPanel0.setLayout(new GridLayout(2,2));
        buttonSendeBeschwerde = new JButton(schwimmbadZeigerR.getSprachmodulS().getBeschwerdeSFV());
        Font font = new Font("Helvetica", 20, 12);
        buttonSendeBeschwerde.setFont(font);
        JPanel panelSprachen = new JPanel();
        panelSprachen.setLayout(new GridLayout(2,4));
        JButton sprache1Button = new JButton();
        JButton sprache2Button = new JButton();
        JButton sprache3Button = new JButton();
        JButton sprache4Button = new JButton();
        //Quelle Icon: http://www.iconarchive.com/show/flags-icons-by-wikipedia/AT-Austria-Flag-icon.html
        //Artist: Wikipedia Authors, License: Public Domain
        Icon austriaIcon = new ImageIcon(".//src//resources//AT-Austria-Flag-icon 32p.png");
        sprache1Button.setIcon(austriaIcon);
        Icon englandIcon = new ImageIcon(".//src//resources//GB-United-Kingdom-Flag-icon 32p.png");
        sprache2Button.setIcon(englandIcon);
        Icon russlandIcon = new ImageIcon(".//src//resources//RU-Russia-Flag-icon 32p.png");
        sprache3Button.setIcon(russlandIcon);

        sprache1Button.addActionListener(useControllerZeigerR::wechsleZuDeutsch);
        sprache2Button.addActionListener(useControllerZeigerR::wechsleZuEnglisch);
        sprache3Button.addActionListener(useControllerZeigerR::wechsleZuRussisch);

        JLabel  leerLabel8 = new JLabel("");
        JLabel  leerLabel9 = new JLabel("");
        JLabel  leerLabel10 = new JLabel("");
        JLabel  leerLabel11 = new JLabel("");
        JLabel  leerLabel12 = new JLabel("");
        JLabel  leerLabel13 = new JLabel("");
        JLabel  leerLabel14 = new JLabel("");

        jPanel0.add(buttonSendeBeschwerde);
        jPanel0.add(leerLabel8);
        jPanel0.add(panelSprachen);
        jPanel0.add(leerLabel10);


        panelSprachen.add(leerLabel11);
        panelSprachen.add(leerLabel9);
        panelSprachen.add(leerLabel14);
        panelSprachen.add(leerLabel12);
        panelSprachen.add(sprache1Button);
        panelSprachen.add(sprache2Button);
        panelSprachen.add(sprache3Button);
        panelSprachen.add(leerLabel13);


        this.setLayout(new GridLayout(5,3));
        this.add(buttonVollpreis);  this.add(label1);           this.add(label7);
        this.add(buttonSenioren);   this.add(label2);           this.add(textArmbandID);
        this.add(buttonSchueler);   this.add(label3);           this.add(buttonVerlassen);
        this.add(checkBoxKurzzeit); this.add(label4);           this.add(label5);
        this.add(jPanel0);          this.add(administration);   this.add(feueralarmButton);

        this.setTitle(schwimmbadZeigerR.getSprachmodulS().getRahmen_0titleSFV());
        this.setResizable(false);

        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //*********************************************************************************************
        //Besucher verschiedener Tarifgruppen betreten das Schwimmbad.
        //Besucherzähler und Geldbetragszähler werden angepasst.
        //Die Geschwindigkeit der Umlaufpumpe zur Wasserreinigung wird erforderlichenfalls erhöht.
        //Zum Zweck der Demonstration der verschiedenen Möglichkeiten zur Nutzung eines Functional Interface
        //und seiner Methode werden im Folgenden der ActionListener und seine actionPerformed()-Methode
        // dreimal mit jeweils unterschiedlicher Syntax eingearbeitet.

        //*************
        //Inner anonym: Erzeugen einer Subklasse des ActionListener
        //*************
        buttonVollpreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Rahmen_0.this.getValueCheckBoxKurzzeit()) {
                    schwimmerZeigerR = new Vollzahler(true,schwimmbadZeigerR);
                    schwimmbadZeigerR.eintreten(schwimmerZeigerR);
                    System.out.println("LOG: Vollzahler(Kurzzeit) eintritt, ID: " + schwimmerZeigerR.getArmbandID());
                }else {
                    schwimmerZeigerR = new Vollzahler(false, schwimmbadZeigerR);
                    schwimmbadZeigerR.eintreten(schwimmerZeigerR);
                    System.out.println("LOG: Vollzahler eintritt, ID: " + schwimmerZeigerR.getArmbandID());
                }
                schwimmbadZeigerR.vermittleSetPassendeUmlaufGeschwindigkeit();
            }
        });
        //******************
        //lambda-expression:
        //******************
        buttonSenioren.addActionListener(e -> {
            if (Rahmen_0.this.getValueCheckBoxKurzzeit()) {
                schwimmerZeigerR = new Senior(true, schwimmbadZeigerR);
                schwimmbadZeigerR.eintreten(schwimmerZeigerR);
                System.out.println("LOG: Senior(Kurzzeit) eintritt, ID: "+ schwimmerZeigerR.getArmbandID());
            }else {
                schwimmerZeigerR = new Senior(false, schwimmbadZeigerR);
                schwimmbadZeigerR.eintreten(schwimmerZeigerR);
                System.out.println("LOG: Senior eintritt, ID: "+ schwimmerZeigerR.getArmbandID());
            }
            schwimmbadZeigerR.vermittleSetPassendeUmlaufGeschwindigkeit();
        });

        // Da so die gesamte Programmierlogik ausgelagert werden kann,
        // scheint die dritte Variante am besten zu passen:
        //****************
        //method reference
        //****************
        buttonSchueler.addActionListener(useControllerZeigerR::schuelerEintreten);

        //*********************************************************************************************
        //Besucher verlassen das Schwimmbad
        //method reference (Programmierlogik ist im UseController)
        buttonVerlassen.addActionListener(useControllerZeigerR::verlassenU_1);
        buttonVerlassen.setToolTipText(schwimmbadZeigerR.getSprachmodulS().getTooltipAnhaltenSFV());

        feueralarmButton.addActionListener(e -> {
            schwimmbadZeigerR.setFeueralarm(true);
            label5.setText(schwimmbadZeigerR.getSprachmodulS().getLabel5FluchtSFV());
            //Zur Vermeidung einer ConcurrentModificationException wird die ArrayList kopiert,
            //bevor alle Elemente entfernt werden.
            ArrayList<Schwimmer> anwesendeCopy = new ArrayList<>(useControllerZeigerR.getSchwimmbadZeigerU().getAnwesendeBesucherArrayList());
            for(Schwimmer fluechtender: anwesendeCopy){
                schwimmbadZeigerR.verlassenSchw_2(fluechtender.getArmbandID());
            }
            Pumpe.setPassendeUmlaufGeschwindigkeit();
            schwimmbadZeigerR.setFeueralarm(false);
        });

        //*********************************************************************************************
        //Haustechniker
        administration.addActionListener(useControllerZeigerR::leiteZu_1_Admin);

        buttonSendeBeschwerde.addActionListener(useControllerZeigerR::leiteZu_5_Beschwerde);
    }//end Konstruktor



    //inner Class, Implementierung der run() Methode für Thread werbungThread
    private class Werbung implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung00SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    //Schwimmer werden über Bahnen-Auslastung informiert,
                    //Anzeigetext passt sich an Besucherzahl an.
                    if (Schwimmbad.getAnwesendeBesucherCounter() == 0) {
                        setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung011SFV(), SwingConstants.CENTER);
                        Thread.sleep(1500);
                        setLabel2Text("", SwingConstants.CENTER);
                        Thread.sleep(500);
                    }else if(Schwimmbad.getAnwesendeBesucherCounter() > 0 && Schwimmbad.getAnwesendeBesucherCounter() < 5){
                        setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung012SFV(), SwingConstants.CENTER);
                        Thread.sleep(1500);
                        setLabel2Text("", SwingConstants.CENTER);
                        Thread.sleep(500);
                    }else{
                        setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung013SFV(), SwingConstants.CENTER);
                        Thread.sleep(1500);
                        setLabel2Text("", SwingConstants.CENTER);
                        Thread.sleep(500);
                    }
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung02SFV(), SwingConstants.CENTER);
                    Thread.sleep(1350);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);


                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung10SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung11SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung12SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung13SFV(), SwingConstants.CENTER);
                    Thread.sleep(2500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung14SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung15SFV(), SwingConstants.CENTER);
                    Thread.sleep(3000);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung16SFV(), SwingConstants.CENTER);
                    Thread.sleep(3000);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                    setLabel2Text(schwimmbadZeigerR.getSprachmodulS().getWerbung17SFV(), SwingConstants.CENTER);
                    Thread.sleep(1500);
                    setLabel2Text("", SwingConstants.CENTER);
                    Thread.sleep(500);
                }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
        }
    }

    //inner Class, Implementierung der run() Methode für Thread variableWerbung
    private class VariableWerbung implements Runnable{
        @Override
        public void run() {
                try {
                    while (true) {
                        for (String s : nachrichtenVonManager){
                            Thread.sleep(500);
                            setLabel3Text(s);
                            Thread.sleep(1000);
                            setLabel3Text("");
                        }
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
        }
    }//end VariableWerbung

    //Getter und Setter
    public boolean getValueCheckBoxKurzzeit() {
        return checkBoxKurzzeit.isSelected();
    }
    public int getValuetextArmbandID() {
        return Integer.parseInt(textArmbandID.getText());
    }
    public void setLabel5Text(String s){
        label5.setText(s);
    }
    public void setTextArmbandID(String s) {
        this.textArmbandID.setText(s);
    }
    public void setLabel2Text(String s, int center) {
        this.label2.setText(s);
    }
    public void setLabel3Text(String s) {
        this.label3.setText(s);
    }

}// end Rahmen
