public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();


        bird.move();
        bird.takeOff();
        bird.fly();
        bird.track();
        bird.land();

        inFlight(bird);
        inFlight(new Jet());
    }
    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();

        if (flier instanceof Trackable tracked) {
           tracked.track();
        }
        flier.land();
    }
}