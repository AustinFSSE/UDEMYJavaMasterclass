public class Employee extends Worker {

    protected long employeeId;
    protected String hireDate;

    private static int employeeNo = 0;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

