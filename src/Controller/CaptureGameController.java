package Controller;

import DB.MySQLDatabase;
import java.sql.SQLException;
import java.util.Scanner;

public class CaptureGameController {


    static String DATE;
    static String TIME;
    static int HomeTeamId;
    static int GuestTeamId;

    private static boolean a = false;

    public static void captureGame() throws SQLException {


        System.out.println("Sie können nun einen neues Spiel erfassen:");
        System.out.println("_____________________________________________");

        Scanner scanner = new Scanner(System.in);


        DATE = "";
        while (DATE.equals("")) {
            System.out.println("Datum:");
            DATE = scanner.nextLine();
        }
        TIME = "";
        while (TIME.equals("")) {
            System.out.println("Uhrzeit:");
            TIME = scanner.nextLine();

        }
        do {
            System.out.println("\tGeben Sie die gewünschte ID der Heimmannschaft ein:");
            if (scanner.hasNextInt()) {
                HomeTeamId = scanner.nextInt();
                a = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                a = false;
                scanner.next();
            }
        } while (a == false);
        scanner.nextLine();

        do {
            System.out.println("\tGeben Sie die gewünschte ID der Gastmannschaft ein:");
            if (scanner.hasNextInt()) {
                GuestTeamId = scanner.nextInt();
                a = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                a = false;
                scanner.next();
            }
        } while (a == false);
        scanner.nextLine();


        MySQLDatabase.newGame(DATE, TIME, HomeTeamId, GuestTeamId);

            Controller.mainWindow();

    }
}