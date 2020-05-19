package viewing;

import model.useController.UseController;

import javax.swing.*;
import java.awt.*;

public class Rahmen_2_Codeabfrage extends JFrame {

    private UseController useControllerZeiger;
    private JLabel label = new JLabel("");
    private JTextField textCodeEingabe = new JTextField();

    //ctr
    public Rahmen_2_Codeabfrage(UseController u){
        useControllerZeiger = u;
        JButton buttonWeiter = new JButton(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahm_2weiterSFV());

        this.add(label);
        this.add(textCodeEingabe);
        this.add(buttonWeiter);

        buttonWeiter.addActionListener(useControllerZeiger::leiteZuRahmen_3_Anwender);

        this.setLayout(new GridLayout(3,1));
        this.setTitle(useControllerZeiger.getSchwimmbadZeigerU().getSprachmodulS().getRahmen_2titleSFV());
        this.setResizable(false);
        this.setSize(233,240);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
    //Getter und Setter
    public void labelSetText(String s){
        label.setText(s);
    }
    public String textCodeEingabeGetText() {
        return textCodeEingabe.getText();
    }
}
