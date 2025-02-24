package game;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends Player>>{

    private final T myGame;

    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T myGame) {
        this.myGame = myGame;
    }

    public int addPlayer() {
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        return myGame.addPlayer(playerName);
    }

    public void playGame(int playerIndex) {
        boolean gameOver = false;
        while (!gameOver) {
            var gameActions = myGame.getGameActions(playerIndex);
            for (Character c : gameActions.keySet()) {
                var action = gameActions.get(c).prompt();
                System.out.println("\t" + action + "(" + c + ")");
            }
            System.out.print("Enter next Action: ");
            char nextAction = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextAction);

            if (gameAction != null) {
                System.out.println(".".repeat(40));
                gameOver = myGame.executeGameAction(playerIndex, gameAction);
                if (!gameOver) {
                    System.out.println(".".repeat(40));
                }
            }
        }
    }
}
