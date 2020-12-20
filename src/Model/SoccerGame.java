package Model;

import java.sql.Date;
import java.sql.Time;

public class SoccerGame {

    private int SoccerGameId;
    private Date DATE;
    private Time TIME;
    private int HomeTeamId;
    private int GuestTeamId;


    public SoccerGame(int soccerGameId, Date DATE, Time TIME, int homeTeamId, int guestTeamId) {
        SoccerGameId = soccerGameId;
        this.DATE = DATE;
        this.TIME = TIME;
        HomeTeamId = homeTeamId;
        GuestTeamId = guestTeamId;
    }

    public int getSoccerGameId() {

        return SoccerGameId;
    }

    public void setSoccerGameId(int soccerGameId) {

        SoccerGameId = soccerGameId;
    }

    public Date getDATE() {

        return DATE;
    }

    public void setDATE(Date DATE) {

        this.DATE = DATE;
    }

    public Time getTIME() {

        return TIME;
    }

    public void setTIME(Time TIME) {

        this.TIME = TIME;
    }

    public int getHomeTeamId() {

        return HomeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {

        HomeTeamId = homeTeamId;
    }

    public int getGuestTeamId() {

        return GuestTeamId;
    }

    public void setGuestTeamId(int guestTeamId) {

        GuestTeamId = guestTeamId;
    }
}
