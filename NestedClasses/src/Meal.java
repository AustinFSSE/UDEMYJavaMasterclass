import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Item drink, side;
    private Burger burger;

    private double conversionRate;

    public Meal() {
        this(1.0);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        side = new Item("fries", "side",2.0);

    }

    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total Due: ", getTotal());
    }

    public void addTopping(String... selectedToppings) {
        burger.addToppings(selectedToppings);
    }

    private class Item {
        private String name;
        private String type;
        private double price;


        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,  getPrice(price, conversionRate));
        }
        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }
    private class Burger extends Item {

        private enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice() {
                return switch (this) {
                    case AVOCADO -> 1.0;
                    case BACON -> 2.0;
                    case CHEESE -> 3.0;
                    default -> 0.0;
                };
            }
        }

        private List <Item> toppings = new ArrayList <>();

        public Burger(String name) {
            super(name, "Burger", 5.0);
        }

        public double getPrice() {
            double total = super.price;
            for (Item item : toppings) {
                total += item.price;
            }
            return total;
        }

        public void addToppings(String... allToppings) {

            for (String topping : allToppings) {
                Extra selectedTopping = Extra.valueOf(topping.toUpperCase());
                toppings.add(new Item(selectedTopping.name(), "TOPPING", selectedTopping.getPrice()));
            }
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(super.toString());
            for (Item item : toppings) {
                builder.append("\n");
                builder.append(item);
            }
            return builder.toString();
        }
    }
}
