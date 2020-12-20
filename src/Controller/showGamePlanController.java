package Controller;

import DB.MySQLDatabase;
import Model.SoccerGame;
import Model.Team;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class showGamePlanController {


    public static void showGame() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\t 1. Die letzten Spiele");
        System.out.println("\t 2. Die zukünftigen Spiele");
        String userChoice = scanner.nextLine();
        while (!userChoice.matches("[12]")) {
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
        if (scan.hasNextLine()){
            Controller.mainWindow();
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
        if (scan.hasNextLine()){
            Controller.mainWindow();
        }

        Controller.mainWindow();
    }

}
