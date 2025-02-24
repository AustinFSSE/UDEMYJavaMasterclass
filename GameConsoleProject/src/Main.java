import game.GameConsole;
import pirate.Pirate;
import pirate.PirateGame;
import pirate.Weapon;

public class Main {
    public static void main(String[] args) {

//        var console = new game.GameConsole<>(new game.ShooterGame("The shootout game.Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeapon('K');
        System.out.println("weapon = " + weapon + ", hitPoints = "
        + weapon.getHitPoint() + ", minLevel = " + weapon.getMinLevel());
        System.out.println(".".repeat(20));

        Pirate austin = new Pirate("austin");
        System.out.println("austin = " + austin);
        System.out.println(".".repeat(20));

        PirateGame.getTowns(1).forEach(System.out::println);
        System.out.println(".".repeat(20));
        PirateGame.getTowns(0).forEach(System.out::println);

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }
}