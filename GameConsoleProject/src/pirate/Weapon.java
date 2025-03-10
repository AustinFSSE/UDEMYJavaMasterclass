package pirate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon {
    AXE(0, 10),
    KNIFE(0, 30),
    MACHETE(1,40),
    PISTOL(1,50);

    private final int minLevel;
    private final int hitPoint;

    Weapon(int minLevel, int hitPoint) {
        this.minLevel = minLevel;
        this.hitPoint = hitPoint;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoint() {
        return hitPoint;
    }
    public static Weapon getWeapon(char firstInitial) {
        for (Weapon w : values()) {
            if (w.name().charAt(0) == firstInitial) {
                return w;
            }
        }
        return values()[0];
    }

    public static List<Weapon> getWeaponsByLevel(int levelOfPlay) {
        List<Weapon> weapons = new ArrayList <>(EnumSet.allOf(Weapon.class));
        weapons.removeIf(w -> w.getMinLevel() > levelOfPlay);
        return weapons;
    }
}












