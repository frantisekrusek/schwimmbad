package viewing;

import model.schwimmbad.BargeldAnnahmeAutomat;
import model.useController.UseController;

import javax.swing.*;
import java.awt.*;

public class Rahmen_3_AutomatBetreuer extends JFrame {
    private UseController useControllerZeiger;

    //ctr
    public Rahmen_3_AutomatBetreuer(UseController u) {
        this.useControllerZeiger = u;

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JButton leereBehaelterButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahm_3AutoleereSFV());
        JButton zurueck = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getZurueck());

        this.add(label1);
        this.add(label2);
        this.add(leereBehaelterButton);
        this.add(zurueck);

        leereBehaelterButton.addActionListener(e -> {
            useControllerZeiger.leereGeldBehaelter();
            label1.setText(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().meldeRahm_3Label1EntnahmeSFM());
            //Zähler zu Einnahmen bei Entleerung wird aktualisiert
            //Aufruf statischer Methoden
            BargeldAnnahmeAutomat.setEinnahmenStandBeiLetzterEntleerung(BargeldAnnahmeAutomat.getEinnahmenCounter());
        });

        zurueck.addActionListener(e -> {
            useControllerZeiger.zurueckSchreiten3und5AlleNach0();
            Rahmen_3_AutomatBetreuer.this.dispose();
        });

        this.setLayout(new GridLayout(4,1));

        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3AutoTitleSFV());
        this.setResizable(false);
        this.setSize(300,320);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }//end ctr
}//end class
