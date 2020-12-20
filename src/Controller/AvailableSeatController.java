package Controller;

import DB.MySQLDatabase;
import Model.*;
import de.vandermeer.asciitable.AsciiTable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AvailableSeatController {

    static boolean fA = false;
    public static void availableSeat() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t 1. Die letzten Spiele");
        System.out.println("\t 2. Die zukünftigen Spiele");
        String userChoice = scanner.nextLine();
        while(!userChoice.matches("[12]")){
            System.out.println("Das ist keine gültige Option, versuchen Sie es nochmal.");
            userChoice = scanner.nextLine();
        }
        switch (userChoice) {
            case "1":
                gamesBefore();
                break;
            case "2":
                gamesAfter();
                break;
        }
    }
    public static void gamesBefore() throws SQLException {
        Scanner scan = new Scanner(System.in);
        List<SoccerGame> soccerGames = MySQLDatabase.getGames();
        List<Team> teams = MySQLDatabase.getTeams();
        String home = null;
        String guest = null;
        for (SoccerGame soccerGame : soccerGames) {
            if(ChronoUnit.DAYS.between(LocalDate.now(), soccerGame.getDATE().toLocalDate())<0){
                System.out.println("Id: " + soccerGame.getSoccerGameId());
                for (Team team : teams) {
                    if(soccerGame.getHomeTeamId() == team.getTeamId()){
                        home = team.getTeamName();
                    }else if(soccerGame.getGuestTeamId() == team.getTeamId()){
                        guest = team.getTeamName();
                    }
                }
                System.out.println("Heimteam vs Gastteam");
                System.out.println(home + " vs " + guest);
                System.out.println("Datum: " + soccerGame.getDATE());
                System.out.println("Zeit: " + soccerGame.getTIME());
                System.out.println("------------------------------------------------");
            }
        }
        int gameID = 0;
        do {
            System.out.print(" Die Spiel ID eingeben: ");
            if (scan.hasNextInt()) {
                gameID = scan.nextInt();
                fA = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                scan.next();
                fA = false;
            }
        } while (fA == false);
        if (fA){
            for (SoccerGame soccerGame : soccerGames) {
                if(soccerGame.getSoccerGameId() == gameID){
                    showSeatInfo(soccerGame);
                }
            }
        }
    }

    public static void gamesAfter() throws SQLException {
        Scanner scan = new Scanner(System.in);
        List<SoccerGame> soccerGames = MySQLDatabase.getGames();
        List<Team> teams = MySQLDatabase.getTeams();
        String home = null;
        String guest = null;
        for (SoccerGame soccerGame : soccerGames) {
            if(ChronoUnit.DAYS.between(LocalDate.now(), soccerGame.getDATE().toLocalDate())>0){
                System.out.println("Id: " + soccerGame.getSoccerGameId());
                for (Team team : teams) {
                    if(soccerGame.getHomeTeamId() == team.getTeamId()){
                        home = team.getTeamName();
                    }else if(soccerGame.getGuestTeamId() == team.getTeamId()){
                        guest = team.getTeamName();
                    }
                }
                System.out.println("Heimteam vs Gastteam");
                System.out.println(home + " vs " + guest);
                System.out.println("Datum: " + soccerGame.getDATE());
                System.out.println("Zeit: " + soccerGame.getTIME());
                System.out.println("------------------------------------------------");
            }
        }
        int gameID = 0;
        do {
            System.out.print(" Die Spiel ID eingeben: ");
            if (scan.hasNextInt()) {
                gameID = scan.nextInt();
                fA = true;
            } else {
                System.out.println("Die Eingabe war leider ungültig.");
                scan.next();
                fA = false;
            }
        } while (fA == false);
        if (fA){
            for (SoccerGame soccerGame : soccerGames) {
                if(soccerGame.getSoccerGameId() == gameID){
                    showSeatInfo(soccerGame);
                }
            }
        }
    }
    public static void showSeatInfo(SoccerGame soccerGame) throws SQLException {
        AsciiTable at = new AsciiTable();
        List<Seat> seats = MySQLDatabase.getAvaiableSeats();
        List<Reservation> reservations = MySQLDatabase.getReservation();
        List list = new ArrayList();
        for (Seat seat: seats) {
            Boolean isAvailable = true;
            for (Reservation reservation: reservations) {
                if (soccerGame.getSoccerGameId() == reservation.getSoccerGameId()){
                    if (reservation.getSeatNumber() == seat.getSeatNumber()){
                        isAvailable = false;
                    }
                }
            }
            if (isAvailable){
                list.add(seat.getSeatNumber());
            } else {
                list.add("X");
            }
        }
        at.addRule();
        at.addRow("A", list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8), list.get(9));
        at.addRule();
        at.addRow( "", list.get(10), list.get(11), list.get(12), list.get(13), list.get(14), list.get(15), list.get(16), list.get(17), list.get(18), list.get(19));
        at.addRule();
        at.addRow("B", list.get(20), list.get(21), list.get(22), list.get(23), list.get(24), list.get(25), list.get(26), list.get(27), list.get(28), list.get(29));
        at.addRule();
        at.addRow( "", list.get(30), list.get(31), list.get(32), list.get(33), list.get(34), list.get(35), list.get(36), list.get(37), list.get(38), list.get(39));
        at.addRule();
        at.addRow("C", list.get(40), list.get(41), list.get(42), list.get(43), list.get(44), list.get(45), list.get(46), list.get(47), list.get(48), list.get(49));
        at.addRule();
        String rend = at.render();
        System.out.println(rend);
        System.out.println("X = Der Sitz ist nicht mehr verfügbar!");

        Controller.mainWindow();
    }
}

