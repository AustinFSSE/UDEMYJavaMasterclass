
public class Rivers extends Line{

    private String name;

    public Rivers(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " River";
    }

}
