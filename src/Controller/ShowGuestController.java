package Controller;

import DB.MySQLDatabase;
import java.sql.SQLException;

public class ShowGuestController {


    public static void showGuest() throws SQLException {

        MySQLDatabase.readVIPGuest();

        Controller.mainWindow();


    }
}
