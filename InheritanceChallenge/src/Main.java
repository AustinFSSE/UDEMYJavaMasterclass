public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee("John", "Smith", "1990-01-01");
        Employee emp2 = new Employee("John", "Smith", "1990-01-02");

        SalariedEmployee one = new SalariedEmployee("12/12/2025","Austin", "08/08/1997", 40.0, false);

        System.out.println(one.collectPay());

        System.out.println(emp.collectPay());

        System.out.println(emp2.toString());
    }
}
