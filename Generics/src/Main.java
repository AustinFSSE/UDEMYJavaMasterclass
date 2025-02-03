
interface Player {}

record BaseballPlayer(String name, String position) implements Player {}

record FootballPlayer(String name, String position) implements Player {}

public class Main {

    public static void scoreResult(Team<?> team1, int t1_score, Team<?> team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void main(String[] args) {

        Team<BaseballTeam> Phillies = new Team<BaseballTeam>("Phillies");
        Team<BaseballTeam> astros = new Team<BaseballTeam>("Astros");
        scoreResult(Phillies, 3, astros, 5);

        Team<SportsTeam> Phillies1 = new Team<SportsTeam>("Phillies");
        Team<SportsTeam> astros1 = new Team<SportsTeam>("Astros");
        scoreResult(Phillies1, 3, astros1, 5);

        Team<BaseballPlayer> Phillies2 = new Team("Phillies");
        Team<BaseballPlayer> astros2 = new Team("Astros");
        scoreResult(Phillies2, 3, astros2, 5);

        var harper = new BaseballPlayer("B Harper", "Pitcher");
        var marsh = new BaseballPlayer("A Marsh", "Catcher");

        Phillies2.addTeamMember(harper);
        astros2.addTeamMember(marsh);

        Phillies2.listTeamMembers();
        astros2.listTeamMembers();

        Team<FootballPlayer> austin = new Team<>("Austin");
        var tex = new FootballPlayer("Austin", "Textile");
        austin.addTeamMember(tex);
        austin.listTeamMembers();

    }
}