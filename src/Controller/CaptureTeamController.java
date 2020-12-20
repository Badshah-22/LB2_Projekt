package Controller;

import DB.MySQLDatabase;
import java.sql.SQLException;
import java.util.Scanner;

public class CaptureTeamController {


    static String TeamName;

    private static boolean a = false;

    public static void captureTeam() throws SQLException {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Sie können nun einen neues Team erfassen:");
        System.out.println("_____________________________________________");



        TeamName = "";
        while(TeamName.equals("")) {
            System.out.println("Name des Teams:");
            TeamName= scanner.nextLine();
        }

        MySQLDatabase.newTeam(TeamName);

            Controller.mainWindow();
    }
}
