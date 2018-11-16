public class Bruger {

    private String navn;
    private String brugerNavn;
    private int kode;
    private boolean isAdmin;  //Skal afgøre om brugeren føres til AdminMenu eller brugerMenu efter Login



    public Bruger(String navn, String brugerNavn, int kode, boolean isAdmin ) { //Constructor

        this.navn = navn;
        this.brugerNavn = brugerNavn;
        this.kode= kode;
        this.isAdmin = isAdmin;
    }

    public String getNavn() {
        return navn;
    }

    public String getBrugerNavn() {
        return brugerNavn;
    }
    public int getKode()  {
        return kode;
    }

    public boolean getisAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setBrugerNavn(String brugerNavn) {
        this.brugerNavn = brugerNavn;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
