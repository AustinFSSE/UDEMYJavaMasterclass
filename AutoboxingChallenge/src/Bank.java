import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList <Customer> customers = new ArrayList <> (5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.name().equals(name)) {
                return customer;
            }
        }
        System.out.printf("Customer %s not found\n", name);
        return null;
    }
    public void addCustomer(String customer, double initialDeposit) {
        if(findCustomer(customer) == null) {
            Customer newCustomer = new Customer(customer, initialDeposit);
            customers.add(newCustomer);
            System.out.printf("Customer %s added\n", customer);
        }
    }
    public void addTransaction(String name, double amount) {
        Customer customer = findCustomer(name);
        if(customer != null) {
            customer.transactions().add(amount);
        }
    }
    public void printStatement(String name) {
        Customer customer = findCustomer(name);
        if(customer == null) {
            System.out.printf("Customer %s not found\n", name);
            return;
        }
        System.out.println("-".repeat(30));
        System.out.printf("Customer %s \n", name);
        System.out.println("Transactions:");
        for (double amount : customer.transactions()) {
            System.out.printf("$%10.2f (%s)", amount, amount < 0 ? "debit" : "credit");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
