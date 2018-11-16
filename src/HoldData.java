import java.util.ArrayList;

public class HoldData {

    private String holdNavn;
    private String tidspunkt;
    private String lokale;
    private String niveau;
    private String traener;
    private int antalMuligeDeltager;
    private int tilmeldte;
    private ArrayList<Ovelse> ovelser;

    /*    ( Til senere brug)
    //Bruger
    public void Bruger(String username, int password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public  void setFullName (String fullName){
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }
    public int getPassword() {
        return password;
    }
    public String getFullName() {
        return fullName;
    }
*/

    //Hold
    public HoldData() {
        opretOvelser();
    }
    public HoldData(String holdNavn, String tidspunkt, String lokale, String niveau, String traener, int antalMuligeDeltager) {
        this.holdNavn = holdNavn;
        this.tidspunkt = tidspunkt;
        this.lokale = lokale;
        this.niveau = niveau;
        this.traener = traener;
        this.antalMuligeDeltager = antalMuligeDeltager;
        // tilføj evt senere til constructor  this.tilmeldte = tilmeldte;
        this.ovelser = new ArrayList<Ovelse>();

        opretOvelser();
    }
    // Opret HoldData:
    // private void opretHoldData(){
    //  HoldData()
    //}
    // Opret bestemte øvelser til et hold.
    private void opretOvelser() {
        this.addOvelser(new Ovelse(20, "Armbøjninger"));
        this.addOvelser(new Ovelse(40, "Løb"));
        this.addOvelser(new Ovelse(5, "Sprint"));
        this.addOvelser(new Ovelse(10, "Sjipning"));

    }

    public void setHoldNavn(String holdNavn) {
        this.holdNavn = holdNavn;
    }
    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }
    public void setLokale(String lokale) {
        this.lokale = lokale;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public void setTraener(String traener) { this.traener = traener;
    }
    public void setAntalMuligeDeltager(int antalMuligeDeltager) {
        this.antalMuligeDeltager = antalMuligeDeltager;
    }
    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }
    public void setOvelser(ArrayList<Ovelse> ovelser) {
        this.ovelser = ovelser;
    }

    public String getHoldNavn() {
        return holdNavn;
    }
    public String getTidspunkt() {
        return tidspunkt;
    }
    public String getLokale() {
        return lokale;
    }
    public String getNiveau() {
        return niveau;
    }
    public String getTraener() {
        return traener;
    }
    public int getAntalMuligeDeltager() {
        return antalMuligeDeltager;
    }
    public int getTilmeldte() {
        return tilmeldte;
    }
    public ArrayList<Ovelse> getOvelser() {
        return ovelser;
    }

    public void addOvelser (Ovelse ovelse) {
        ovelser.add(ovelse);
    }
}
