import java.util.ArrayList;
public class Data {     //Denne klasse fungerer som en database for systemet

    private ArrayList<Bruger> users; //Opretter ArrayList af klassen "Bruger"
    private ArrayList<Hold> holdListe; //Opretter ArrayList af klassen Holddata

    public Data() { //Constructor

        this.users = new ArrayList<>();
        opretBrugere();
        this.holdListe = new ArrayList<>();
        opretHold();

    }


    public void opretBrugere() {


        //Vi opretter 4 bruger objekter, der senere bliver tilføjet til hold
        Bruger bruger1 = new Bruger("Hans", "Karlsmart27", 2020, false);
        Bruger bruger2 = new Bruger("Mathilde", "Seje20", 1010, false);
        Bruger bruger3 = new Bruger("Mads", "Ondskab123", 1999, false);
        Bruger bruger4 = new Bruger("Zarah", "Hejsa250", 2011, false);

        //4 admin objekter af Bruger oprettes
        // da disse personer skal have visse privilegier i systemet, sætter vi erDuAmin= true;

        Bruger admin1 = new Bruger("Walid", "ITeksperten123", 2301, true);
        Bruger admin2 = new Bruger("Mie", "Badgirl23", 7909, true);
        Bruger admin3 = new Bruger("Nicholas", "Hårdnegl22", 1166, true);
        Bruger admin4 = new Bruger("Kristian", "hej", 1, true);


        users.add(bruger1);
        users.add(bruger2);
        users.add(bruger3);
        users.add(bruger4);
        users.add(admin1);
        users.add(admin2);
        users.add(admin3);
        users.add(admin4);
        //Vi tilføjer bruger og admins til Arraylist "users"
    }


    public void opretHold() {
        Hold holdData1 = new Hold("CrossFit", "20:00", "Gården", "Svær", "Nicholas", 20);
        Hold holdData2 = new Hold("Max Strength", "8:00", "101", "Meget Svær", "Nicholas", 5);
        Hold holdData3 = new Hold("Boxing", "22:00", "Hallen", "let", "Walid", 40);

        holdListe.add(holdData1);
        holdListe.add(holdData2);
        holdListe.add(holdData3);
    }

    // Getters (og setters?)
    public ArrayList<Bruger> getUsers() {
        return users;
        //En  getter på Bruger arrayList oprettes
    }

    public ArrayList<Hold> getHoldListe() {
        return holdListe;
    }

    // Til senere brug, evt slet hvis det ikke bliver brugt. (Brugen er at opdatere dataklassen mellem de forskellige objekter)
    public void setHoldListe(ArrayList<Hold> holdListe) {
        this.holdListe = holdListe;
    }

    public void setUsers(ArrayList<Bruger> users) {
        this.users = users;
    }


}