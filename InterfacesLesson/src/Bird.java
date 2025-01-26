public class Bird extends Animal implements Trackable, FlightEnabled {
    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " took off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " tracking");
    }
}
