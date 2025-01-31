public class Satelite implements OrbitEarth {
    @Override
    public void achieveOrbit() {
        System.out.println("Satelite achieves orbit");
    }

    @Override
    public void takeOff() {
        System.out.println("Satelite takes off");
    }

    @Override
    public void land() {
        System.out.println("Satelite land");
    }

    @Override
    public void fly() {
        System.out.println("Satelite fly");
    }
}
