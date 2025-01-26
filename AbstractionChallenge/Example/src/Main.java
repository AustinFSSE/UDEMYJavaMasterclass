import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Dog", "big", 1000);
        dog.move("Fast");
//        System.out.println(dog.speak());

        ArrayList <Animal> animals = new ArrayList <>();
        animals.add(new Dog("Dog", "big", 1000));
        animals.add(new Dog("Doggy", "small", 500));
        animals.add(new Fish("Fish", "big", 500));
        animals.add(new Fish("Fishy", "small", 250));
        animals.add(new Horse("Clydesdale", "large", 1250));
//        doAnimalStuff(dog);

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
        }
    }
    private static void doAnimalStuff(Animal animal) {

        System.out.println(animal.speak());
        animal.move(" slow ");
    }
}