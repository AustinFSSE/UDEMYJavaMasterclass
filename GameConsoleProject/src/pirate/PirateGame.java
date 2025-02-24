package pirate;

import game.Game;
import game.GameAction;
import game.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PirateGame extends Game <Pirate> {
    // 2D list representing each town at each level
    private static final List<List <String>> levelMap;

    //-------------------------------------
    static {
        levelMap = new ArrayList <>();
        System.out.println("Loading levelMap");
        loadData();

        if (levelMap.isEmpty()) {
            throw new RuntimeException("LevelMap is empty");
        }
        System.out.println("Finished loading levelMap");
    }

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map <Character, GameAction> getGameActions(int playerIndex) {
        Pirate pirate = getPlayer(playerIndex);
        System.out.println("pirate = " + pirate);
        List<Weapon> weapons = Weapon.getWeaponsByLevel(pirate.value("level"));

        Map<Character, GameAction> map = new LinkedHashMap <>();
        for (Weapon weapon: weapons) {
            char init = weapon.name().charAt(0);
            map.put(init, new GameAction(init, "Use " + weapon, this::useWeapon));
        }
        return map;
    }

    private static void loadData() {
        // Level 1 towns
        levelMap.add(new ArrayList <>(List.of(
                "Bridgetown",
                "Fitts Village",
                "Holetown"
        )));
        // level 2 towns
        levelMap.add(new ArrayList <>(List.of(
                "Fort-de-France",
                "Sainte-Anne",
                "Le Vauclin"
        )));
        // level 3 towns
        levelMap.add(new ArrayList <>(List.of(
                "Fort-de-France",
                "Sainte-Anne",
                "Le Vauclin"
        )));
    }
    public static List<String> getTowns(int level) {
        if (level <= (levelMap.size() - 1)) {
            return levelMap.get(level);
        }
        return null;
    }

    private boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon();
    }

    @Override
    public boolean executeGameAction(int player, GameAction action) {
        getPlayer(player).setCurrentWeapon(Weapon.getWeapon(action.key()));
        return super.executeGameAction(player, action);
    }
}
