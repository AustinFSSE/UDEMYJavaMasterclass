public interface OrbitEarth extends FlightEnabled{

    void achieveOrbit();

    private static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description );
    }
}
