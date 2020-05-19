package model.beschwerde;

import viewing.Rahmen_0;
import viewing.Rahmen_5_Beschwerde;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Beschwerde {
    //todo:

    //Instanzenzähler
    private static int counter = 0;
    //String zum speichern von eingelesenem Text
    private String beschwerdeText = "So eine Gemeinheit!";
    private String counterString;
    private Rahmen_5_Beschwerde rahmen_5_Beschwerde;

    //ctr
    public Beschwerde(Rahmen_5_Beschwerde pRahmen_5_Beschwerde, String pText) throws IOException {
        this.rahmen_5_Beschwerde = pRahmen_5_Beschwerde;
        this.beschwerdeText = pText;
        try{
            this.counterAktualisieren();
        }catch (IOException e){
            System.out.println("LOG Beschwerde: " + e);
        }
        this.sichBeschweren();
    }//end ctr

    // counter wird persistiert, damit dieser und die Dateinamen auch nach Programm-Neustart
    //fortlaufend nummeriert werden.
        public void counterAktualisieren()throws IOException{
        File counterFile = new File(".\\src\\resources\\beschwerden_counter.txt");
        System.out.println("LOG Beschwerde: " + counterFile.getAbsolutePath());
        //Datei wird nur erstellt, falls keine existiert.
        counterFile.createNewFile();
        FileInputStream counterInput = new FileInputStream(counterFile);
        int zeichen= 0;
        String charZeichenkette = "";
        //read() liest jeweils nächstes Zeichen als ASCII (??) ein - liefert ASCII-Code als int
        while ((zeichen = counterInput.read()) != -1){
            charZeichenkette += (char)zeichen;
        }
        counterInput.close();
        //System.out.println("LOG: counter vor neuer Beschwerde: " + charZeichenkette);
        counter = Integer.parseInt(charZeichenkette) + 1;
        //System.out.println("LOG: diese Zahl wird die neue Beschwerde haben: " + counter);
        FileOutputStream counterOutput = new FileOutputStream(counterFile);
        //int wird zu String, String wird zu einem Byte-Array
            //Byte-Array wird als Byte-Stream in Textdatei geschrieben.
        counterOutput.write(String.valueOf(counter).getBytes());
        counterOutput.flush();
        counterOutput.close();
    }

    //Textdatei wird erzeugt, mit fortlaufender Nummer benannt.
    //Zeitpunkt der Texterstellung und Beschwerdetext werden in Textdatei geschrieben.
    public void sichBeschweren() throws IOException {
        DecimalFormat format = new DecimalFormat("0000");
        String dateiNr = format.format(counter);
        File file = new File(".\\src\\resources\\kundenbriefe\\KundenBrief_" + dateiNr + ".txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //Quellenangabe: https://stackoverflow.com/questions/25229124/format-instant-to-string
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
        bufferedWriter.write(dateTimeFormatter.format(Instant.now()) + "\n"+ "\n");

        bufferedWriter.write(beschwerdeText);
        bufferedWriter.flush();
        bufferedWriter.close();
        //fileWriter.flush();
        fileWriter.close();
    }//end sichBeschweren

    //SETTER
    public void setBeschwerdeText(String beschwerdeText) {
        this.beschwerdeText = beschwerdeText;
    }
}
