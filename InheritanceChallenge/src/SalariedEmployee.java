import java.time.LocalDate;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String hireDate, String name, String birthDate, double hourlyPayRate, boolean isRetired) {
        super(hireDate, name, birthDate);
        this.annualSalary = hourlyPayRate;
        this.isRetired = isRetired;
    }
    @Override
    public double collectPay() {
        return annualSalary;
    }
    public void retire() {
        setRetired();
        terminate(String.valueOf(LocalDate.now()));
    }
    private void setRetired() {
        this.isRetired = true;
    }
    public boolean getIsRetired() {
        return isRetired;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                ", is retired?" + getIsRetired() +
                "Last Day " + endDate + '}';
    }


}
