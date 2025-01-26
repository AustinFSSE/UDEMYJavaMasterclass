

import java.util.ArrayList;

record OrderItem(int quantity, ProductForSale product) { }

public class Store {
    private static ArrayList<ProductForSale> products = new ArrayList<>();

    public void addItemToOrder(ArrayList<OrderItem> order, int quantity, int orderIndex) {
        order.add(new OrderItem(quantity, products.get(orderIndex)));
    }
    public void printOrder() {
        for (var product : products ) {
            product.showDetails();
        }
    }


    public static void main(String[] args) {

        products.add(new Beverage("Drink", "This is a drink", 1.96));
    }
}
