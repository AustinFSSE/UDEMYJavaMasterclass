public class Horse extends Mammal {

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void shedHair() {
        System.out.println(getType() + " sheds in the spring");
    }

    @Override
    public String speak() {
        return " Neigh!";
    }
}
