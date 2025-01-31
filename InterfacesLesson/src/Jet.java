public class Jet implements FlightEnabled, Trackable {
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

    @Override
    public FlightStages transition(FlightStages stage) {

        System.out.println(getClass().getSimpleName() + " transitioning");
        return FlightEnabled.super.transition(stage);


    }
}
