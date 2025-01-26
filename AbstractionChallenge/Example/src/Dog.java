public class Dog extends Animal {



    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String speak() {
        if (type.equals("Dog")) {
            return "Bark!";
        }
        return "Woof!";
    }

    @Override
    public void move(String speed) {
        System.out.println(speed);
    }
}
