public class Beverage extends ProductForSale {


    public Beverage(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " " + description);
        System.out.println(price);
    }
}
