public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracker = bird;

        animal.move();
        flier.takeOff();
        flier.fly();
        tracker.track();
    }
}