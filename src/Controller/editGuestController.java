package Controller;

import DB.MySQLDatabase;
import Model.VIPGuest;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class editGuestController {

    static int VIPGuestId;
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

    public static void editGuest() throws SQLException {
        Scanner guestScan = new Scanner(System.in);
        List<VIPGuest> guests = MySQLDatabase.getVIPGuestId();

        System.out.println("Alle vorhandenen Kunden:");
        MySQLDatabase.readVIPGuest();

        System.out.println("Sie können nun die Gästedaten ändern:");
        System.out.println("____________________________________:");


        do {
            System.out.println("Bitte geben Sie die Gäste ID ein, welche zu ändern ist.");
            if (guestScan.hasNextInt()) {
                VIPGuestId = guestScan.nextInt();
                a = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                a = false;
                guestScan.next();
            }
        } while (a == false);
        for (VIPGuest vipGuest : guests) {
            if (vipGuest.getVIPGuestId() == VIPGuestId) {
                changeGuest(vipGuest);
            }
        }
    }

    public static void changeGuest(VIPGuest vipGuest) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wollen Sie die Gäste ID ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        int VIPGuestIdChoice = scanner.nextInt();
        switch (VIPGuestIdChoice) {
            case 1:
                do {
                    System.out.println("\tGäste ID");
                    if (scanner.hasNextInt()) {
                        VIPGuestId = scanner.nextInt();
                        a = true;
                    }else {
                        System.out.println("Die Eingabe war leider ungültig.");
                        a = false;
                        scanner.next();
                    }
                }while(a == false);
                break;
            case 2:
                try {
                    VIPGuestId = vipGuest.getVIPGuestId();
                } catch (NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige Eingabe");
                break;
        }

        scanner.nextLine();


        System.out.println("Wollen Sie den Vornamen ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String FirstNameChoice = scanner.nextLine();
        switch (FirstNameChoice) {
            case "1":
                FirstName = "";
                while (FirstName.equals("")) {
                    System.out.println("Vorname:");
                    FirstName = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    FirstName = vipGuest.getFirstName();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie den Nachnamen ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String LastNameChoice = scanner.nextLine();
        switch (LastNameChoice) {
            case "1":
                LastName = "";
                while (LastName.equals("")) {
                    System.out.println("Nachname:");
                    LastName = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    LastName = vipGuest.getLastName();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie den Geburtsdatum ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String BirthDateChoice = scanner.nextLine();
        switch (BirthDateChoice) {
            case "1":
                BirthDate = "";
                while (BirthDate.equals("")) {
                    System.out.println("Geburtsdatum:");
                    BirthDate = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    BirthDate = vipGuest.getBirthDate();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie die Telefonnummer ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String TelephoneChoice = scanner.nextLine();
        switch (TelephoneChoice) {
            case "1":
                Telephone = "";
                while (Telephone.equals("")) {
                    System.out.println("Telefonnummer:");
                    Telephone = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    Telephone = vipGuest.getTelephone();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie die Mobiletelefonnummer ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String MobileTelephoneChoice = scanner.nextLine();
        switch (MobileTelephoneChoice) {
            case "1":
                MobileTelephone = "";
                while (MobileTelephone.equals("")) {
                    System.out.println("Mobiletelefonnummer:");
                    MobileTelephone = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    MobileTelephone = vipGuest.getMobileTelephone();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie die Email ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String EmailChoice = scanner.nextLine();
        switch (EmailChoice) {
            case "1":
                Email = "";
                while (Email.equals("")) {
                    System.out.println("Email:");
                    Email = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    Email = vipGuest.getEmail();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie die Postleitzahl ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        int postcodeChoice = scanner.nextInt();
        switch (postcodeChoice) {
            case 1:
                do {
                    System.out.println("Postleitzahl:");
                    if (scanner.hasNextInt()) {
                        postcode = scanner.nextInt();
                        a = true;
                    }else {
                        System.out.println("Die Eingabe war leider ungültig.");
                        a = false;
                        scanner.next();
                    }
                }while(a == false);
                break;
            case 2:
                try {
                    postcode = vipGuest.getPostcode();
                } catch (NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige Eingabe");
                break;

        }
        scanner.nextLine();

        System.out.println("Wollen Sie Strasse und Nummer ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String StreetAndNumberChoice = scanner.nextLine();
        switch (StreetAndNumberChoice) {
            case "1":
                StreetAndNumber = "";
                while (StreetAndNumber.equals("")) {
                    System.out.println("Strasse und Nummer:");
                    StreetAndNumber = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    StreetAndNumber = vipGuest.getStreetAndNumber();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }

        System.out.println("Wollen Sie den Wohnort ändern: [ 1.JA | 2.NEIN");
        while (!scanner.hasNext("[12]")) {
            System.out.println("Ungültige Eingabe, Bitte versuchen Sie es nochmal");
            scanner.nextLine();
        }
        String PlaceChoice = scanner.nextLine();
        switch (PlaceChoice) {
            case "1":
                Place = "";
                while (Place.equals("")) {
                    System.out.println("Wohnort:");
                    Place = scanner.nextLine();
                }
                break;
            case "2":
                try {
                    Place = vipGuest.getPlace();
                }catch(NullPointerException e) {
                }
                break;
            default:
                System.out.println("Ungültige EIngabe");
                break;

        }


        MySQLDatabase.editGuest(FirstName, LastName, BirthDate, Telephone, MobileTelephone, Email, postcode, StreetAndNumber, Place, VIPGuestId);

        Controller.mainWindow();
    }
}
