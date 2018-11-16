import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);

    private Bruger currentUser;
    Data databasen = new Data(); //sådan som koden er lige nu, er det 2 Data objekter, det kan vi diskturere om er en god ide, evt kan man have 2, men kun oprette det som der er brug for i hvert,
    //evt kan man lave 2 forskellige måder at instantiere data objekter på, så vi ikke har redundant data i hvert objekt, ellers skal vi finde en måde at gøre så login
    //kan se data oprettet i controller


    public Bruger getCurrentUser() {
        return currentUser;
    }


    public Bruger koerLogin() {
        currentUser = null; //currentuser sættes til null for at nulstille den, dette føres fordi at currentBruger bliver sat lig currentuser i linje 38 af controller
        //hvis ikke man gjorde dette, vil programmet altid tro at den forrigt korrekt indtastede bruger er den nuværende bruger.
        System.out.print("Indtast brugernavn: ");
        String inputNavn = input.next();

        System.out.print("Indtast kode: ");
        int inputKode = input.nextInt();


//nedenstående kode er rykket til kontroller, og er redundant
        if(brugerVerificering(inputNavn, inputKode)) { //Hvis input tilsvarer en af brugerens login, så gør dette:

            if(currentUser.getisAdmin()){
                System.out.println("Velkommen tilbage, Administrator: " + currentUser.getNavn());
                return currentUser;
            } else {
                System.out.println("Velkommen tilbage, " + currentUser.getNavn());
            }

        } else
            System.out.println("Forkert brugernavn eller password!\t Prøv igen!");

        return currentUser;
    }

    private boolean brugerVerificering (String brugerNavn, int kode){  //Denne metode validerer om brugeren eksisterer
        for (Bruger bruger : databasen.getUsers()) { //Denne for-løkke kører objekt af bruger igennem i arraylisten
            if (bruger.getBrugerNavn().equals(brugerNavn) && bruger.getKode() == kode) {
                this.currentUser = bruger;
                return true;
            }
            //Hvis det matcher bruger fra db, vil currentUser være "brugeren" der logger in

        }
        return false;
    }

}
