package viewing;

import model.schwimmbad.BargeldAnnahmeAutomat;
import model.schwimmer.Schwimmer;
import model.useController.UseController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rahmen_3_Manager extends JFrame{
    private UseController useControllerZeiger;
    private List anzeigeList = new List();

    //ctr
    public Rahmen_3_Manager(UseController u){
        this.useControllerZeiger = u;
        useControllerZeiger.setRahmen_3_manager(this);

        JPanel northpanel = new JPanel(new GridLayout(3,2));
        JPanel centerpanel = new JPanel(new GridLayout(1,3));
        JPanel southpanel = new JPanel(new GridLayout(3,3));

        JLabel nLabel1 = new JLabel("1");
        //JLabel nLabel2 = new JLabel("");
        JTextField werbeNachrichtenEingabe = new JTextField();
        JLabel nLabel3 = new JLabel("");
        //JLabel nLabel4 = new JLabel("");
        JLabel nLabel5 = new JLabel("");
        JLabel nLabel6 = new JLabel("");

        JLabel sLabel5 = new JLabel("");
        JLabel sLabel6 = new JLabel("");
        JLabel sLabel7 = new JLabel("");
        JLabel sLabel8 = new JLabel("");
        JLabel sLabel9 = new JLabel("");
        JPanel panelBeschwerden = new JPanel();
        panelBeschwerden.setLayout(new GridLayout(2,1));

        nLabel1.setText(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().meldeRahm_3MannLabel1setText());

        JButton neueNachrichtButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManNeuerWerbeSFV());
        //Quelle icon & Lizenz: Icon made by Freepik (https://www.freepik.com/) from www.flaticon.com
        Icon megafonIcon = new ImageIcon(".//src//resources//bullhorn.png");
        neueNachrichtButton.setIcon(megafonIcon);
        JButton zurueck = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getZurueck());
        JButton zeigeAnwesendeBesucherButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManZeigeBesucherSFV());
        JButton errechneUmsatzanteileButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManErrechneUmsatzSFV());
        JButton besuchsdauer_nach_tarifgruppenButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManZeigeBesuchsdauerSFV());
        JButton pruefeKasseButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManPruefeKasseSFV());
        JButton liesBeschwerdenButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManLiesBeschwerdenSFV());
        JButton vernichteBeschwerdenButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManEntsorgeBeschwerdenSFV());
        //Quelle icon & Lizenz: http://icons8.com, http://www.iconarchive.com/show/windows-8-icons-by-icons8/Household-Waste-icon.html
        Icon mistkuebelIcon = new ImageIcon(".//src//resources//Household-Waste-icon.png");
        vernichteBeschwerdenButton.setIcon(mistkuebelIcon);

        neueNachrichtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String neu = werbeNachrichtenEingabe.getText();
                useControllerZeiger.getManagerZeigerU().gebeNeueNachrichtEin(neu);
                werbeNachrichtenEingabe.setText("");
                System.out.println("LOG: " + useControllerZeiger.getManagerZeigerU().getNachrichten().size());

            }
        });

        besuchsdauer_nach_tarifgruppenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeigeList.removeAll();
                anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManVollzahlerSFV() + " - " + "\t\t\t" +
                        useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManDurchschnittDauerSFV() + useControllerZeiger.getSchwimmbadZeigerU().schnittDauerAusgebenVollzahler());
                anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManSeniorenSFV() + " - " + "\t\t\t" +
                        useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManDurchschnittDauerSFV() + useControllerZeiger.getSchwimmbadZeigerU().schnittDauerAusgebenSenioren());
                anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManSchuelerSFV() + " - " + "\t\t\t" +
                        useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManDurchschnittDauerSFV() + useControllerZeiger.getSchwimmbadZeigerU().schnittDauerAusgebenSchueler());
            }
        });

        pruefeKasseButton.addActionListener(e -> {
            double diff = useControllerZeiger.getSchwimmbadZeigerU().getBargeldAnnahmeAutomat().zeigeDifferenz();
            anzeigeList.removeAll();
            anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManLetztePruefungSFV() + useControllerZeiger.getSchwimmbadZeigerU().getBargeldAnnahmeAutomat().getZeitstempelKontrolle());
            anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManLetzteEntleerungSFV() + useControllerZeiger.getSchwimmbadZeigerU().getBargeldAnnahmeAutomat().getZeitstempelEntleerung());
            anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManSeitDerLetzten1SFV() + diff + useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManSeitDerLetzten2SFV());
            anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManZurBankGebrachtSFV());
            anzeigeList.add("");
            anzeigeList.add(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3ManGleicheAbSFV());
            useControllerZeiger.reSetZeitstempelKontrolle();
            BargeldAnnahmeAutomat.setEinnahmenStandKontrolliert(BargeldAnnahmeAutomat.getEinnahmenStandBeiLetzterEntleerung());
        });

        zurueck.addActionListener(e -> {
            useControllerZeiger.zurueckSchreiten3und5AlleNach0();
            Rahmen_3_Manager.this.dispose();
        });
        //Liste aktueller Besucher ausgeben:
        zeigeAnwesendeBesucherButton.addActionListener(e -> {
            anzeigeList.removeAll();
            String zeile;
            for(Schwimmer schwimmer:useControllerZeiger.getSchwimmbadZeigerU().getAnwesendeBesucherArrayList()){
                zeile = schwimmer.toString();
                anzeigeList.add(zeile);
            }
        });

        errechneUmsatzanteileButton.addActionListener(e -> {
            anzeigeList.removeAll();
            for(String zeile:useControllerZeiger.listeAnteileAnEinnahmenNachTarifgruppenU()){
                anzeigeList.add(zeile);
            }
        });

        vernichteBeschwerdenButton.addActionListener(useControllerZeiger.getManagerZeigerU()::vernichteBeschwerden);
        liesBeschwerdenButton.addActionListener(useControllerZeiger.getManagerZeigerU()::liesBeschwerden);

        this.setLayout(new GridLayout(3,1));

        this.add(northpanel);
        this.add(centerpanel);
        this.add(southpanel);

        northpanel.add(nLabel1);
        northpanel.add(werbeNachrichtenEingabe);
        northpanel.add(nLabel3);
        northpanel.add(neueNachrichtButton);
        northpanel.add(nLabel5);
        northpanel.add(nLabel6);

        centerpanel.add(anzeigeList);

        southpanel.add(zeigeAnwesendeBesucherButton);           southpanel.add(errechneUmsatzanteileButton);  southpanel.add(pruefeKasseButton);
        southpanel.add(besuchsdauer_nach_tarifgruppenButton);   southpanel.add(sLabel6);                      southpanel.add(sLabel7);
        southpanel.add(panelBeschwerden);                       southpanel.add(sLabel9);                      southpanel.add(zurueck);

        panelBeschwerden.add(liesBeschwerdenButton);
        panelBeschwerden.add(vernichteBeschwerdenButton);
        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getManagerRahmen_1SFV());
        this.setResizable(false);
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }//end ctr

    //GETTER
    public List getAnzeigeList() {
        return anzeigeList;
    }
}//end class
