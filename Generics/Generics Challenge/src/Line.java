import java.util.Arrays;

public abstract class Line implements Mappable {

    private double[][] locations;

    public Line(String... location) {
        this.locations = new double[location.length][];
        int index = 0;
        for (var l : location) {
            this.locations[index] = Mappable.stringToLatLon(l);
            index++;
        }
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }
}
