import java.util.ArrayList;
import java.util.List;

public class SportsTeam implements Player {

    private String teamName;

    private List <Player> teamMembers = new ArrayList <>();

    private int totalWins, totalLosses, totalDraws;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }
    public void addTeamMember(Player player) {
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }
    public void listTeamMembers() {
        System.out.println(teamName + ": " + teamMembers);
    }

    public int ranking() {
        return (totalLosses * 2) + totalDraws + 1;
    }
    public String setScore(int ourScore, int theirScore) {

        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore < theirScore) {
            totalLosses++;
            message = "loss";
        } else {
            totalDraws++;
            message = "draw";
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
