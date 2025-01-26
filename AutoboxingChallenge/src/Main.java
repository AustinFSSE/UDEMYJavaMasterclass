import java.util.ArrayList;

record  Customer(String name, ArrayList<Double> transactions) {

        public Customer(String name, double initialDeposit) {
            this(name.toUpperCase(),
                    new ArrayList <Double>(500));
            transactions.add(initialDeposit);
        }
}

public class Main {


    public static void main(String[] args) {

        Bank bank = new Bank("Chase Bank");
        Customer customer = new Customer("John Doe", 500);
        bank.addCustomer("John Doe", 500);
        bank.addTransaction("John Doe", 500);
        bank.addTransaction("John Doe", -500);
        bank.printStatement("John Doe");


    }
}