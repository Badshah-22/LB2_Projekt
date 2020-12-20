package DB;

import java.sql.*;
import Model.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLDatabase {

    public static List<Team> getTeams() throws SQLException {

        List<Team> teams = new ArrayList<>();
        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();

        String sqlStatement = "SELECT * FROM team";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {

            int idTeam = resultSet.getInt("idTeam");
            String teamName = resultSet.getString("TeamName");
            Team team = new Team(idTeam, teamName);
            teams.add(team);
        }
        return teams;
    }


    public static List<SoccerGame> getGames() throws SQLException {

        List<SoccerGame> soccerGames = new ArrayList<>();
        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();

        String sqlStatement = "SELECT * FROM soccerGame";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {

            int SoccerGameId = resultSet.getInt("idSoccerGame");
            Date Date = resultSet.getDate("Date");
            Time Time = resultSet.getTime("Time");
            int HomeTeamId = resultSet.getInt("idHomeTeam");
            int GuestTeamId = resultSet.getInt("idGuestTeam");
            SoccerGame soccerGame = new SoccerGame(SoccerGameId, Date, Time, HomeTeamId, GuestTeamId);
            soccerGames.add(soccerGame);
        }
        return soccerGames;
    }


    public static void readVIPGuest() throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT idVIPGuest, FirstName, LastName, BirthDate, Place, MobileTelefon, Email FROM vipguest";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {

            int idVIPGuest = resultSet.getInt("idVIPGuest");
            String firstname = resultSet.getString("FirstName");
            String lastname = resultSet.getString("LastName");
            String birthdate = resultSet.getString("BirthDate");
            String place = resultSet.getString("Place");
            String mobiletelefon = resultSet.getString("MobileTelefon");
            String email = resultSet.getString("Email");
            System.out.println("Id: " + idVIPGuest);
            System.out.println("Firstname: " + firstname);
            System.out.println("Lastname: " + lastname);
            System.out.println("Birthdate: " + birthdate);
            System.out.println("Place: " + place);
            System.out.println("Mobiletelefon: " + mobiletelefon);
            System.out.println("Email: " + email);
        }

    }


    public static List<Seat> getAvaiableSeats() throws SQLException {
        List<Seat> seats = new ArrayList<>();

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM seat";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next())
        {
            int seatNumber = resultSet.getInt("SeatNumber");
            int seatRow = resultSet.getInt("SeatRow");
            int categoryID = resultSet.getInt("IdCategory");
            Seat seat = new Seat(seatNumber, seatRow, categoryID);
            seats.add(seat);
        }
        return seats;
    }


    public static List<Reservation> getReservation() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM reservation";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next())
        {

            int idReservation = resultSet.getInt("idReservation");
            int seatNumberID = resultSet.getInt("SeatNumber");
            int soccerGameID = resultSet.getInt("idSoccerGame");
            int vipGuestID = resultSet.getInt("idVIPGuest");
            Reservation soccerGame = new Reservation(idReservation, soccerGameID, seatNumberID, vipGuestID);
            reservations.add(soccerGame);
        }
        return reservations;
    }

    public static void bookSeatnumber(int SeatNumber, int VIPGuest) throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);


        String query = "INSERT INTO reservation (idVIPGuest, Seatnumber)"
                + " VALUES(?, ?)";

        PreparedStatement prepStatemt = conn.prepareStatement(query);
        prepStatemt.setLong(1, VIPGuest);
        prepStatemt.setDouble(2, SeatNumber);
        prepStatemt.executeUpdate();
        prepStatemt.close();

        }

    public static void newTeam(String TeamName) throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);


        String query = "INSERT INTO team (TeamName)"
                + " VALUES(?)";

        PreparedStatement prepStatemt = conn.prepareStatement(query);
        prepStatemt.setString(1, TeamName);
        prepStatemt.executeUpdate();
        prepStatemt.close();

    }

    public static void newGame(String DATE, String TIME, int HomeTeamId, int GuestTeamId) throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);


        String query = "INSERT INTO soccergame (Date, Time, idHomeTeam, idGuestTeam)"
                + " VALUES(?, ?, ?, ?)";

        PreparedStatement prepStatemt = conn.prepareStatement(query);
        prepStatemt.setString(1, DATE);
        prepStatemt.setString(2, TIME);
        prepStatemt.setLong(3, HomeTeamId);
        prepStatemt.setLong(4, GuestTeamId);
        prepStatemt.executeUpdate();
        prepStatemt.close();

    }


    public static void newGuest(String FirstName, String LastName, String BirthDate, String Telephone, String MobileTelephone, String Email, int postcode, String StreetAndNumber, String Place) throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);


        String query = "INSERT INTO vipguest (FirstName, LastName, BirthDate, Telephone, MobileTelefon, Email, Postcode, StreetAndNumber, Place)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepStatemt = conn.prepareStatement(query);
        prepStatemt.setString(1, FirstName);
        prepStatemt.setString(2, LastName);
        prepStatemt.setString(3, BirthDate);
        prepStatemt.setString(4, Telephone);
        prepStatemt.setString(5, MobileTelephone);
        prepStatemt.setString(6, Email);
        prepStatemt.setInt(7, postcode);
        prepStatemt.setString(8, StreetAndNumber);
        prepStatemt.setString(9, Place);
        prepStatemt.executeUpdate();
        prepStatemt.close();

    }

    public static void editGuest(String FirstName, String LastName, String BirthDate, String Telephone, String MobileTelephone, String Email, int postcode, String StreetAndNumber, String Place, int VIPGuestId) throws SQLException {

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);


        String query = "UPDATE vipguest" +
                " SET FirstName = ?, LastName = ?, BirthDate = ?, Telephone = ?, MobileTelefon = ?, Email = ?, Postcode= ?, StreetAndNumber = ?, Place = ?" +
                "" +
                " WHERE idVipGuest = ?";

        PreparedStatement prepStatemt = conn.prepareStatement(query);
        prepStatemt.setString(1, FirstName);
        prepStatemt.setString(2, LastName);
        prepStatemt.setString(3, BirthDate);
        prepStatemt.setString(4, Telephone);
        prepStatemt.setString(5, MobileTelephone);
        prepStatemt.setString(6, Email);
        prepStatemt.setInt(7, postcode);
        prepStatemt.setString(8, StreetAndNumber);
        prepStatemt.setString(9, Place);
        prepStatemt.setInt(10, VIPGuestId);
        prepStatemt.executeUpdate();
        prepStatemt.close();

    }

    public static List<VIPGuest> getVIPGuestId() throws SQLException {
        List<VIPGuest> guests = new ArrayList<>();

        final String dbUrl = "jdbc:mysql://localhost:3306/seatreservationshsa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "Shahmir-22";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM VIPGuest";
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while(resultSet.next()) {
            int idVipGuest = resultSet.getInt("idVIPGuest");
            String FirstName = resultSet.getString("FirstName");
            String LastName = resultSet.getString("LastName");
            String BirthDate = resultSet.getString("BirthDate");
            String Telephone = resultSet.getString("Telephone");
            String MobileTelefon = resultSet.getString("MobileTelefon");
            String Email = resultSet.getString("Email");
            int postcode = resultSet.getInt("Postcode");
            String StreetAndNumber = resultSet.getString("StreetAndNumber");
            String Place = resultSet.getString("Place");
            VIPGuest vipGuest = new VIPGuest(idVipGuest, FirstName, LastName, BirthDate, Telephone, MobileTelefon, Email, postcode, StreetAndNumber, Place);
            guests.add(vipGuest);
        }
        return guests;
    }
}
