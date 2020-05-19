package model.schwimmbad;

import model.useController.UseController;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class Manager {
    private UseController useController;
    private ArrayList<String> nachrichten = new ArrayList<>();
    private File kundenbriefePath = new File(".\\src\\resources\\kundenbriefe\\");
    //ctr
    public Manager(UseController useController){
        this.useController = useController;
    } //end ctr

    public void gebeNeueNachrichtEin(String s){
        nachrichten.add(s);
    }

    public void vernichteBeschwerden(ActionEvent actionEvent){
        useController.getRahmen_3_manager().getAnzeigeList().removeAll();
        //Quelle: http://openbook.rheinwerk-verlag.de/java7/1507_05_001.html#dodtpefa0026c-44f2-4b2a-b426-8282d545d0ce
        if (kundenbriefePath.exists()&&kundenbriefePath.isDirectory()) {
            File[] fileArray = kundenbriefePath.listFiles();
            for (File pFile : fileArray) {
                pFile.delete();
            }
            System.out.println("LOG Manager: Beschwerden werden vernichtet");
            Thread erfolgsMeldung = new Thread(() -> {
                useController.getRahmen_3_manager()
                        .getAnzeigeList().removeAll();
                useController.getRahmen_3_manager()
                        .getAnzeigeList()
                        .add(useController.getSchwimmbadZeigerU().getSprachmodulS().getManagerBeschwerdenVernichtetSFV());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                useController.getRahmen_3_manager().getAnzeigeList().removeAll();
            });
            erfolgsMeldung.start();
        }//end if
    }//end vernichteBeschwerden()

    public void liesBeschwerden(ActionEvent actionEvent){
        useController.getRahmen_3_manager().getAnzeigeList().removeAll();
        if (kundenbriefePath.exists() && kundenbriefePath.isDirectory()){
            File[] fileArray = kundenbriefePath.listFiles();

            String gesamtText ="";
            ArrayList<String> arrayListSubStrings = new ArrayList<>();

            for (File pFile : fileArray) {
                try {
                    Reader reader = new FileReader(pFile);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String string1 = "";
                    while ((string1 = bufferedReader.readLine()) != null){
                        //Zeile wird aus Beschwerdetext herausgenommen.
                        if (string1.equals("Bitte um Ihr Feedback:") ^ string1.equals("Give us your feedback:")){
                            continue;
                        }
                        gesamtText = gesamtText + string1 + " ";
                    }//end while
                    bufferedReader.close();
                    reader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String restString = gesamtText;
                //Validierung (sonst Laufzeit-Fehlermeldung bei Erstellen eines Substring mit 100 Stellen
                if (restString.length() > 99) {
                    //restString wird so lange geteilt, bis alle Teile höchstens 100 Stellen haben.
                    while (restString.length() > 99){
                        //ermittle Index letztes Leerzeichen vor der 100sten Stelle
                        String s1 = restString.substring(0,100);
                        int lastIndex = s1.lastIndexOf(" ");
                        String zeile1 = restString.substring(0,(lastIndex+1));
                        arrayListSubStrings.add(zeile1);
                        //Neudefinition restString für nächsten Schleifendurchlauf
                        restString = restString.substring((lastIndex+1));
                        //Größe restString hat sich geändert
                        if(restString.length() <= 99){
                            arrayListSubStrings.add(restString);
                        }
                    }
                    //ist die erste Zeile kurz, kommt nur diese in die Arraylist
                }else{
                    arrayListSubStrings.add(restString);
                }//end if
                //Übergabe der arrayListSubStrings an die List im Rahmen:
                for (String subString:arrayListSubStrings) {
                    useController.getRahmen_3_manager().getAnzeigeList().add(subString);
                }
                useController.getRahmen_3_manager().getAnzeigeList().add("");
                arrayListSubStrings.clear();
                gesamtText = "";
            }//end  for (File pFile : fileArray)
        }//end if
    }//end liesBeschwerden()


    //Getter
    public ArrayList<String> getNachrichten() {
        return nachrichten;
    }
}//end class Manager
