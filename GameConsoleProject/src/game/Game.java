package game;

import java.util.*;


public abstract class Game <T extends Player>{
    String gameName;
    List <Player> players = new ArrayList <>();
    Map <Character, GameAction> standardActions = null;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Map<Character, GameAction> getStandardActions() {
        if (standardActions == null) {
            return standardActions = new LinkedHashMap <>(Map.of(
                    'I',
                    new GameAction('I', "Print game.Player Info", this::printPlayer),
                    'Q',
                    new GameAction('Q', "QuitGame", this::quitGame)
            ));
        }
        return standardActions;
    }

    public abstract T createNewPlayer(String name);
    public abstract Map<Character, GameAction> getGameActions(int playerIndex);

    final int addPlayer(String name) {
       T player = createNewPlayer(name);
       if (player != null) {
           players.add(player);
           return players.size() - 1;
       }
       return -1;
    }

    protected final T getPlayer(int playerIndex) {
        return (T) players.get(playerIndex);
    }

    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }

    public boolean printPlayer(int player) {
        Player p = players.get(player);
        System.out.println(player);
        return false;
    }
    public boolean quitGame(int player) {
        Player p = players.get(player);
        System.out.println("Sorry to see you go, " + p.name());
        return true;
    }
}
