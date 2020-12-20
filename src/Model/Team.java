package Model;


public class Team  {

    private int TeamId;
    private String TeamName;


    public Team(int teamId, String teamName) {
        TeamId = teamId;
        TeamName = teamName;
    }

    public int getTeamId() {

        return TeamId;
    }

    public void setTeamId(int teamId) {

        TeamId = teamId;
    }

    public String getTeamName() {

        return TeamName;
    }

    public void setTeamName(String teamName) {

        TeamName = teamName;
    }
}
