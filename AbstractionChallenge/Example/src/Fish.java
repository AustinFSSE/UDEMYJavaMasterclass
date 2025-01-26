public class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String speak() {
        return "Fishy";
    }

    @Override
    public void move(String speed) {
        System.out.println(speed);
    }
}
