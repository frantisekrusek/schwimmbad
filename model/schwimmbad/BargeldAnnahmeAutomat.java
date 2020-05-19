package model.schwimmbad;

public class BargeldAnnahmeAutomat {
    //Warum statische Eigenschaften? - Es gibt nur eine Instanz.
    private static double einnahmenCounter;
    private static double einnahmenStandBeiLetzterEntleerung = 0.0;
    private static double einnahmenStandKontrolliert = 0.0;
    private String zeitstempelEntleerung = " ---";
    private String zeitstempelKontrolle = " ---";

    //Logik
    public double zeigeDifferenz(){
        return einnahmenStandBeiLetzterEntleerung - einnahmenStandKontrolliert;
    }

    //Getter und Setter
    public void setZeitstempelEntleerung(String zeitstempel) {
        this.zeitstempelEntleerung = zeitstempel;
    }
    public String getZeitstempelEntleerung() {
        return zeitstempelEntleerung;
    }
    public String getZeitstempelKontrolle() {
        return zeitstempelKontrolle;
    }
    public void SetZeitstempelKontrolle(String zeitstempelKontrolle) {
        this.zeitstempelKontrolle = zeitstempelKontrolle;
    }
    public static void setEinnahmenStandBeiLetzterEntleerung(double einnahmenStandBeiLetzterEntleerung) {
        BargeldAnnahmeAutomat.einnahmenStandBeiLetzterEntleerung = einnahmenStandBeiLetzterEntleerung;
    }
    public static double getEinnahmenStandBeiLetzterEntleerung() {
        return einnahmenStandBeiLetzterEntleerung;
    }
    public static void setEinnahmenStandKontrolliert(double einnahmenStandKontrolliert) {
        BargeldAnnahmeAutomat.einnahmenStandKontrolliert = einnahmenStandKontrolliert;
    }
    public static double getEinnahmenCounter() {
        return einnahmenCounter;
    }
    public static void setEinnahmenCounter(double einnahmenCounter) {
        BargeldAnnahmeAutomat.einnahmenCounter = einnahmenCounter;
    }
}
