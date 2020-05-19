package viewing;

import model.useController.UseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rahmen_3_Haustechnik extends JFrame {
    private UseController useControllerZeiger;
    private JLabel labelUmlaufGeschwindigkeit = new JLabel();

   //ctr
    public Rahmen_3_Haustechnik(UseController u){
        this.useControllerZeiger = u;

        JLabel besucher = new JLabel();

        JButton buttonPumpeAnhaltenEinschalten = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3HausOnOffSFV());
        JButton zurueck = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getZurueck());

        besucher.setText(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3HausBesucherDerzeitSFV()
                + useControllerZeiger.getaktuelleBesucherCounterU());
        labelUmlaufGeschwindigkeit.setText(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().meldeUseConLabelUmlaufGeschwindigkeitSetText());

        this.add(besucher);
        this.add(labelUmlaufGeschwindigkeit);
        this.add(buttonPumpeAnhaltenEinschalten);
        this.add(zurueck);

        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useControllerZeiger.zurueckSchreiten3und5AlleNach0();
                Rahmen_3_Haustechnik.this.dispose();
            }
        });

        buttonPumpeAnhaltenEinschalten.addActionListener(useControllerZeiger::pumpeAnhaltenEinschalten);

        this.setLayout(new GridLayout(4,1));
        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_3HausTitleSFV());
        this.setResizable(false);
        this.setSize(300,320);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }// end ctr

    public void labelUmlaufGeschwindigkeitSetText(String s){
        this.labelUmlaufGeschwindigkeit.setText(s);
    }

}//end Rahmen_3_Haustechnik
