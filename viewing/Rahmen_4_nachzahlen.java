package viewing;

import model.schwimmbad.BargeldAnnahmeAutomat;
import model.schwimmbad.Schwimmbad;
import model.schwimmer.Schwimmer;
import model.useController.UseController;

import javax.swing.*;
import java.awt.*;

public class Rahmen_4_nachzahlen extends JFrame {
    private UseController useControllerZeiger;
    private Schwimmer schwimmerR_4;

    //ctr
    public Rahmen_4_nachzahlen(UseController u, Schwimmer fertiger) {
        this.useControllerZeiger = u;
        this.schwimmerR_4 = fertiger;

        JLabel label1 = new JLabel(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getLabel1UeberschrittenSFV());
        JLabel label2 = new JLabel();
        JButton aufzahlenButton = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getNaGutSFV());
        JLabel label3 = new JLabel();
        //JButton zurueck = new JButton("Zurück");

        this.add(label1);
        this.add(label2);
        this.add(aufzahlenButton);
        this.add(label3);

        aufzahlenButton.addActionListener(e -> {
            schwimmerR_4.setKurzzeit(false);
            BargeldAnnahmeAutomat.setEinnahmenCounter(BargeldAnnahmeAutomat.getEinnahmenCounter() + 2);
            schwimmerR_4.setPreis(schwimmerR_4.getPreis() + 2);
            Rahmen_4_nachzahlen.this.dispose();

            System.out.println("LOG: Tschuess, ID " + schwimmerR_4.getArmbandID());
            useControllerZeiger.getRahmen_0ZeigerU().setLabel5Text("<html><body>" + useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getSchwBadAbschiedSFV() + schwimmerR_4.getArmbandID() + "!<br/>"
                    + schwimmerR_4.gebeAusDuration() + "</html></body>");
            useControllerZeiger.getSchwimmbadZeigerU().getAnwesendeBesucherArrayList().remove(schwimmerR_4);
            useControllerZeiger.getSchwimmbadZeigerU().aufzahlenSchwimmbad();
        });

        this.setLayout(new GridLayout(4,1));

        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_4titleSFV());
        this.setResizable(false);
        this.setSize(300,320);
        //this.setLocation((int) useControllerZeiger.getRahmen_0ZeigerU().getLocation().getX() + 690, 139);
        //this.setLocationRelativeTo(useControllerZeiger.getRahmen_0ZeigerU());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }//end ctr
}//end class
