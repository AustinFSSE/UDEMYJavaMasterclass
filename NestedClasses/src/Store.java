public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        regularMeal.addTopping("avocado", "mayo");
        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.78);
        System.out.println(USRegularMeal);
    }
}
