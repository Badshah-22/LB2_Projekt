package Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws SQLException {

        mainWindow();

    }

    public static void mainWindow() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_______________________________________________________________________________");
        System.out.println("|  Herzlich Willkommen zur Sitzplatzreservierung - Wählen Sie eine Aktion aus: |"); // sout
        System.out.println("|______________________________________________________________________________|");
        System.out.println("\t1. Spielplan anzeigen");
        System.out.println("\t2. Gäste anzeigen");
        System.out.println("\t3. Verfügbarkeit der Sitzplätze");
        System.out.println("\t4. Sitzplan buchen");
        System.out.println("\t5. Mannschaft erfassen");
        System.out.println("\t6. Spiel erfassen");
        System.out.println("\t7. Gäste erfassen");
        System.out.println("\t8. Gäste editieren");
        System.out.println("\te. Applikation schliessen");

        String userChoice = scanner.nextLine();
        while (!userChoice.matches("[12345678Ee]")) {
            System.out.println("Das ist keine gültige Option");
            userChoice = scanner.nextLine();
        }
        switch (userChoice) {
            case "1":
                showGamePlanController.showGame();
                break;

            case "2":
                ShowGuestController.showGuest();
                break;

            case "3":
                AvailableSeatController.availableSeat();
                break;

            case "4":
                BookSeatController.bookSeat();
                break;

            case "5":
                CaptureTeamController.captureTeam();
                break;

            case "6":
                CaptureGameController.captureGame();
                break;


            case "7":
                CaptureGuestController.captureGuest();
                break;

            case "8":
                editGuestController.editGuest();
                break;


            case "e":
                System.exit(0);
                break;

        }
    }
}

