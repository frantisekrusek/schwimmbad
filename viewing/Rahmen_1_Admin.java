package viewing;

import model.useController.UseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rahmen_1_Admin extends JFrame {
    private UseController useControllerZeiger;

    //ctr
    public Rahmen_1_Admin(UseController u){
        this.useControllerZeiger = u;

        JButton buttonHaustechnik = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getHaustechRahmen_1SFV());
        JButton buttonBargeldautomat = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getBargeldRahmen_1SFV());
        JButton buttonManager = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getManagerRahmen_1SFV());
        JButton buttonZurueck = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getZurueck());

        this.setLayout(new GridLayout(4,1));
        this.add(buttonManager);
        this.add(buttonBargeldautomat);
        this.add(buttonHaustechnik);
        this.add(buttonZurueck);

        buttonHaustechnik.addActionListener(useControllerZeiger::leiteZu_2_CodeabfrageHaustechnik);
        buttonBargeldautomat.addActionListener(useControllerZeiger::leiteZu_2_CodeabfrageAutomatBetreuer);
        buttonManager.addActionListener(useControllerZeiger::leiteZu_2_CodeabfrageManager);
        buttonZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useControllerZeiger.zurueckSchreiten3und5AlleNach0();
                Rahmen_1_Admin.this.dispose();
            }
        });

        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getWohinRahm_1SFV());
        this.setResizable(false);
        this.setSize(233,320);
        this.setLocationRelativeTo(null);
        //Benutzer haben nicht die Berechtigung, das Programm zu beenden.
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }//end ctr

}//end class
