package pirate;

import game.Player;

import java.util.*;

public class Pirate implements Player {

    private final String name;
    private final Map <String, Integer> gameData;

    private final List <String> townsVisited = new LinkedList <>();
    private Weapon currentWeapon;

    public Pirate(String name) {
        this.name = name;
    }

    //----------------------------------------
    {
        gameData = new HashMap <>(Map.of(
                "health", 100, "score", 0, "level", 0, "townIndex", 0
        ));
        visitTown();
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    int value(String name) {
        return gameData.getOrDefault(name, 0);
    }

    private void setValue(String name, int value) {
        gameData.put(name, value);
    }
    private void adjustValue(String name, int value) {
        gameData.compute(name, (k, v) -> v += value);
    }

    private void adjustHealth(int value) {
        int health = value("health");
        health += value;
        health = Math.min(health, 100);
        setValue("health", health);
    }

    boolean useWeapon() {
        System.out.println("Used the " + currentWeapon);
        return false;
    }

    boolean visitTown() {
        List<String> levelTowns = PirateGame.getTowns(value("level"));
        if (levelTowns.isEmpty()) {
            return true;
        }
        String town = levelTowns.get(value("townIndex"));
        if (town != null){
            townsVisited.add(town);
            return false;
        }
        return true;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        var current = ((LinkedList <String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).split(",")[0]);
        return "----> " + current + "\npirate.Pirate " + name + " " + gameData + "\n\ttownsVisited= " + Arrays.toString(simpleNames);
    }
}
