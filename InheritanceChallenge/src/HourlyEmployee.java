public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee(String hireDate, String name, String birthDate, long employeeId, double hourlyPayRate) {
        super(hireDate, name, birthDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        return hourlyPayRate;
    }
}
