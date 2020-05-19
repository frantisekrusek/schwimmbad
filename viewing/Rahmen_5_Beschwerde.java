package viewing;

import model.beschwerde.Beschwerde;
import model.useController.UseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Rahmen_5_Beschwerde extends JFrame{
    private UseController useController;
    private JLabel jLabel1;
    //todo: textArea Zeicheneingabe Anzahl beschränken.

    //ctr
    public Rahmen_5_Beschwerde(UseController pUseController) {
        this.useController = pUseController;
        jLabel1 = new JLabel("", SwingConstants.CENTER);
        JButton buttonSendeBeschwerde = new JButton(useController.getSchwimmbadZeigerU().getSprachmodulS().getButtonSendeRahmen_5SFV());
        JButton buttonZurueck = new JButton(useController.getSchwimmbadZeigerU().getSprachmodulS().getZurueck());

        JPanel panel = new JPanel();
        //Umgang mit JTextArea: https://www.java-tutorial.org/jtextarea.html
        JTextArea beschwerdeTextarea = new JTextArea(useController.getSchwimmbadZeigerU().getSprachmodulS().getFeedbackRahmen_5SFV(),5,20);
        beschwerdeTextarea.setLineWrap(true);
        beschwerdeTextarea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(beschwerdeTextarea);
        panel.add(scrollPane);

        buttonSendeBeschwerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Beschwerde beschwerde;
                try {
                    String beschwString = beschwerdeTextarea.getText();
                    System.out.println("LOG Rahmen: " + beschwString);
                    beschwerde = new Beschwerde(Rahmen_5_Beschwerde.this, beschwString);
                    beschwerde.setBeschwerdeText("");
                    //TextArea leeren
                    beschwerdeTextarea.setText(useController.getSchwimmbadZeigerU().getSprachmodulS().getFeedbackRahmen_5SFV());
                    // für 1,5 Sekunden erscheint eine Eingangsbestätigung.
                    Thread bestaetigung = new Thread(new Bestaetigung());
                    bestaetigung.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }//end actionPerformed
        });

        buttonZurueck.addActionListener(e -> {
            this.dispose();
            useController.zurueckSchreiten3und5AlleNach0();
        });

        this.add(jLabel1);
        this.add(buttonSendeBeschwerde);
        this.add(panel);
        this.add(buttonZurueck);

        this.setLayout(new GridLayout(4,2));
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }//end ctr

    //inner class
    private class Bestaetigung implements Runnable{
        @Override
        public void run(){
            jLabel1.setText(useController.getSchwimmbadZeigerU().getSprachmodulS().getDankeMitteilungRahmen_5SFV());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jLabel1.setText("");
        }//end run
    }
}//end class
