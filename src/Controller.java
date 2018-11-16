import java.util.*;
import java.util.Scanner;
public class Controller extends Login{

    private Data db;
    private Scanner input;
    private Hold hold;
    public Bruger currentBruger;
    public Login login;

    public Controller() {
        db = new Data();
        input = new Scanner(System.in);
        login = new Login();

    }
    public void run(){
        int valgMenu = 0;
        Boolean koer = true;

        do {
            System.out.println("*************************************************" +
                    "\n**Velkommen til CBS-FITNESS digitale betjening!**\n******************************************" +
                    "*******");

            System.out.println("\ntast 1 for at logge ind");
            System.out.println("tast 2 for at se info om holdene");

            valgMenu = input.nextInt();

            switch (valgMenu) {

                case 1:
                    login.koerLogin();
                    break;
                case 2:
                    visOplysninger();
                    break;
                default:
                    System.out.println("Indtast venligst et gyldigt tal!");
                    break;

            }
           currentBruger = login.getCurrentUser();

        } while (currentBruger == null);

        if(currentBruger.getisAdmin()){
            System.out.println("\nVelkommen tilbage, Administrator: " + currentBruger.getNavn()+"!");
            System.out.println("Du har nu følgende valgmuligheder:");
            adminMenu();

        } else {
            System.out.println("\nVelkommen tilbage, " + currentBruger.getNavn()+ "!");
            System.out.println("Du har nu følgende valgmuligheder:");
            brugerMenu();

        }
    }

    public void adminMenu() {

        boolean koer = true;
        int valgMenu = 0;
        do {
            System.out.println("\n1) Opret et nyt hold");
            System.out.println("2) Tilføj øvelser til et hold");
            System.out.println("3) Ændr oplsyninger om et hold");
            System.out.println("4) Slet et hold");
            System.out.println("5) Vis alle oplysninger om et enkelt hold");
            System.out.println("6) Vis øvelserne for et bestemt hold");
            System.out.println("7) Vis alle oplysninger om alle hold");
            System.out.println("8) Log ud");
            System.out.println("9) Afslut programmet");
            valgMenu = input.nextInt();
            switch (valgMenu) {

                case 1: System.out.println("Du har valgt at oprette et nyt hold!");
                    opretHold(); //Færdig
                    break;

                case 2: System.out.println("Du har valgt at tilføje øvelser til et hold");
                    tilfojOvelser(); //Walid
                    break;

                case 3: System.out.println("Du har valgt at ændre et holds oplysninger");
                    changeHold();   //Mie
                    break;

                case 4: System.out.println("Du har valgt at slette et hold");
                    //   DeleteHold(); //Nicholas
                    break;

                case 5: System.out.println("Du får nu vist alle oplysninger om et enkelt hold");
                    //visHold();  //Nicholas
                    break;

                case 6: System.out.println("Du får nu vist øvelserne for et bestemt hold");
                    visOvelser(); //KRISTIAN
                    break;

                case 7: System.out.println("Du får nu vist alle oplysninger om alle hold");
                    visHold(); //Færdig
                    break;
                case 8: System.out.println("Du har valgt at logge ud... på gensyn!");
                    currentBruger = null;
                    run();

                case 9: System.out.println("Du har nu afsluttet programmet... På gensyn!");
                    koer = false;
                    break;

                default: System.out.println("Ugyldigt valg!");
                    break;

            }
        } while (koer == true);


    }
    public void brugerMenu() {

        boolean koer = true;


        do {
            printBrugerMenu();
            int valg = input.nextInt();


            switch (valg) {
                case 1:
                    visHold();
                    break;

                case 2:
                    visOvelser();
                    break;

                case 3:
                    logUd();
                    break;

                default:
                    System.out.println("Du tastede et ugyldigt input, tast 0, 1 eller 2");
                    break;
            }
        }
        while (koer == true);
    }

    private void printBrugerMenu() {
        System.out.println("\nDu har nu følgende valgmuligheder: \n");
        System.out.println("1) Se alle vores hold på CBS fitness");
        System.out.println("2) Se alle vores øvelser her på CBS fitness");
        System.out.println("3) At logge ud");
    }
    private boolean logUd() {
        boolean koer = false;
        System.out.println("Du er nu logget ud og er retuneret til Hovedmenuen");

        return koer;
    }
    private void visOplysninger() {

        if (db.getHoldListe().isEmpty()) {
            System.out.println("Der ikke oprettet nogle Hold på CBS Fitness endnu");
        } else {
        int i = 1;

        System.out.printf("-%10s %-40s %-30s\n","Nr","Antal Medlemmer", "Skema");
        for (Hold hold : db.getHoldListe()) {
            System.out.printf("%-10d %-40s %-30s\n",i,hold.getHoldNavn());
            i++;
        }
        vaelgHold();
    }
    }
    private void vaelgHold() {

        System.out.println("Du har nu muligheden for at vælge et hold og se alle oplysningerne om det eller at logge ud\n");
        int holdNr = input.nextInt();
        Hold holdValg = db.getHoldListe().get(--holdNr);

        System.out.printf(holdValg.getHoldNavn(), holdValg.getTraener(), holdValg.getNiveau(), holdValg.getTidspunkt());


    }
    private void changeHold() {


    }

    private void opretHold() {
        System.out.print("Hvilket navn skal holdet have?");
        String wantedTeam = input.next();
        System.out.print("Hvilke tidspunkter skal holdet spille på?");
        String wantedTime = input.next();
        System.out.print("Hvilket lokale skal holdet være i?");
        String wantedLokale = input.next();
        System.out.print("Hvilket niveau skal holdet være på?");
        String wantedLevel = input.next();
        System.out.print("Hvilken træner skal holdet have?");
        String wantedTrainer = input.next();
        System.out.print("Hvor mange medlemmer skal holdet have?");
        int wantedAmount = input.nextInt();

        //System.out.print("Hvilke øvelser skal holdet have?");
        //nythold.setTidspunkt(input.next());

        System.out.print("Du oprettede holdet:" + "\nHold: " + wantedTeam +"\nTidspunkt: " + wantedTime +
                "\nLokale: " + wantedLokale + "\nNiveau: " +wantedLevel +"\nTræner: " + wantedTrainer +
                "\nAntal medlemmer: " + wantedAmount + "\n");

        System.out.print("\nHoldet er nu oprettet!\n");

        Hold addedTeam = new Hold (wantedTeam, wantedTime,wantedLokale, wantedLevel,wantedTrainer, wantedAmount);
        db.getHoldListe().add(new Hold(wantedTeam, wantedTime, wantedLokale, wantedLevel, wantedTrainer, wantedAmount));


    }
    private void tilfojOvelser() {
        int i;
        Ovelse ovelse;

        System.out.print("Hvilken øvelse skal det være?");
        String o = input.next();
        System.out.print("Hvor lang tid skal øvelserne laves?");
        int t = input.nextInt();

        ovelse = new Ovelse(t,o);

        visHold();
        System.out.print("Hvilket nr hold vil du tilføje øvelser til?");
        i = input.nextInt();
        i--;
        db.getHoldListe().get(i).addOvelser(ovelse);

    }

    //først skal en skanner tage input for at finde indeks af arraylist af hold(evt så display først alle holdene for brugeren)
    //vælg hold
    //skriv øvelser ned. evt kan øvelser håndteres som en string arraylist, så der kan tilføjes flere

    private void visHold() {
        int j = 1;
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s  %-20s\n"
                , "Nr", "Hold", "Tidspunkt", "Lokale", "Niveau", "Træner", "Medlemmer");

        for (Hold hold : db.getHoldListe()) {
            System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s %-20d\n", j, hold.getHoldNavn(),
                    hold.getTidspunkt(), hold.getLokale(), hold.getNiveau(),
                    hold.getTraener(), hold.getTilmeldte());
            j++;
        }
    }
    private void visOvelser() {
        //Denne kode "virker" men kan ikke udskrive øvelserne da den ikke kan formatere arraylists, den skal derfor skrives om
        int j = 1;
        System.out.printf("-%10s %-40s %-30s\n", "Nr", "Hold", "Øvelse");
        for (Hold hold : db.getHoldListe()) {
            System.out.printf("%-10d %-40s\n", j, hold.getHoldNavn(), hold.getOvelser());
            j++;
        }
    }

}
