import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> {
    private String teamName;

    private List <T> teamMembers = new ArrayList <>();

    private int totalWins, totalLosses, totalDraws;

    public Team(String teamName) {
        this.teamName = teamName;
    }
    public void addTeamMember(T t) {
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }
    public void listTeamMembers() {
        System.out.println(teamName + ": " + teamMembers);
        for (T t : teamMembers) {
            System.out.println(t);
        }
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
