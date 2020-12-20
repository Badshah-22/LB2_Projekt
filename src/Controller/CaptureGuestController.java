package Controller;

import DB.MySQLDatabase;
import java.sql.SQLException;
import java.util.Scanner;


public class CaptureGuestController {


    static String FirstName;
    static String LastName;
    static String BirthDate;
    static String Telephone;
    static String MobileTelephone;
    static String Email;
    static int postcode;
    static String StreetAndNumber;
    static String Place;


    private static boolean a = false;

    public static void captureGuest() throws SQLException {



        System.out.println("Sie können nun einen neuen Gast erfassen:");
        System.out.println("_____________________________________________");

        Scanner scanner = new Scanner(System.in);

        FirstName = "";
        while(FirstName.equals("")) {
            System.out.println("Vorname:");
            FirstName= scanner.nextLine();
        }
        LastName = "";
        while(LastName.equals("")) {
            System.out.println("Nachname:");
            LastName= scanner.nextLine();
        }

        BirthDate = "";
        while(BirthDate.equals("")) {
            System.out.println("Geburtsdatum:");
            BirthDate= scanner.nextLine();
        }

        Telephone = "";
        while(Telephone.equals("")) {
            System.out.println("Telefon:");
            Telephone= scanner.nextLine();
        }
        MobileTelephone = "";
        while(MobileTelephone.equals("")) {
            System.out.println("Mobiltelefon:");
            MobileTelephone= scanner.nextLine();
        }
        Email = "";
        while(Email.equals("")) {
            System.out.println("Email:");
            Email= scanner.nextLine();
        }

        do {
            System.out.println("Postleitzahl:");
            if (scanner.hasNextInt()) {
                postcode = scanner.nextInt();
                a = true;
            }else {
                System.out.println("Die Eingabe war leider ungülti, versuchen Sie es nochmal");
                a = false;
                scanner.next();
            }
        }while(a == false);

        scanner.nextLine();

        StreetAndNumber = "";
        while(StreetAndNumber.equals("")) {
            System.out.println("Strasse und Nummer:");
            StreetAndNumber= scanner.nextLine();
        }
        Place = "";
        while(Place.equals("")) {
            System.out.println("Wohnort:");
            Place= scanner.nextLine();
        }


        MySQLDatabase.newGuest(FirstName, LastName, BirthDate, Telephone, MobileTelephone, Email, postcode, StreetAndNumber, Place);

        Controller.mainWindow();
    }



}
