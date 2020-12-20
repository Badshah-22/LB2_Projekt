package Controller;

import DB.MySQLDatabase;
import java.sql.SQLException;
import java.util.Scanner;

public class BookSeatController {


    static int SeatNumber;
    static int VIPGuestId;


    private static boolean a = false;

    public static void bookSeat() throws SQLException {



        System.out.println("Sie können nun einen Sitzplatz buchen:");
        System.out.println("_____________________________________________");

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\tGeben Sie die gewünschte Sitznummer an");
            if (scanner.hasNextInt()) {
                SeatNumber = scanner.nextInt();
                a = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                a = false;
                scanner.next();
            }
        } while (a == false);

        scanner.nextLine();


        do {
            System.out.println("\tGeben Sie die gewünschte Gäste ID an");
            if (scanner.hasNextInt()) {
                VIPGuestId = scanner.nextInt();
                a = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                a = false;
                scanner.next();
            }
        } while (a == false);

        scanner.nextLine();


        MySQLDatabase.bookSeatnumber(SeatNumber, VIPGuestId);

        Controller.mainWindow();
    }
}
