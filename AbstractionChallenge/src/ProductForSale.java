

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    private double getSalesPrice(int quantity) {
        return quantity * price;
    }

    private void printPricedItems(int quantity) {
        double cost = quantity * price;
        System.out.println(quantity + " " + description + ": $" + cost);
    }

    public abstract void showDetails();

}
