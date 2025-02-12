import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name, weapon;
    private int hitPoints, strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List <String> write() {
        List <String> list = new ArrayList <>();
        list.add(name);
        list.add(String.valueOf(hitPoints));
        list.add(String.valueOf(strength));
        list.add(weapon);
        return list;
    }
    @Override
    public void read(List <String> list) {
        if (list != null && !list.isEmpty()) {
            name = list.get(0);
            hitPoints = Integer.parseInt(list.get(1));
            strength = Integer.parseInt(list.get(2));
            weapon = list.get(3);
        }
    }
}
