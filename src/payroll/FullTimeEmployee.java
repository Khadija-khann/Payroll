package payroll;

/**
 * Manages full-time employee's information, such as name, ID, job title, yearly salary, and number of sick days.
 * Sick days can be taken or reset.
 * @author Khadija
 */
public class FullTimeEmployee extends Employee {
    private static double YEARLY_SICK_DAYS = 20.0;
    private static int MONTHS = 12;
    private double yearlySalary;
    private double sickDaysLeft;

    /**
     * Constructor with employee number, last name, first name, job title,
     * yearly salary and number of sick days taken.
     * @param employeeNumber employee number
     * @param lastname last name
     * @param firstName first name
     * @param jobTitle job title
     * @param yearlySalary yearly salary
     * @param sickDaysLeft number of sick days left
     */
    public FullTimeEmployee(String employeeNumber, String lastname, String firstName, String jobTitle, double yearlySalary, double sickDaysLeft) {
        super(employeeNumber, lastname, firstName, jobTitle);
        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    /**
     * Gets the employee's yearly salary.
     * @return yearly salary
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * Returns the amount earned monthly based on the yearly salary.
     * @return amount earned monthly
     */
    public double pay(){
        return yearlySalary/MONTHS;
    }

    /**
     *  Updates the number of sick days left for the employee.
     * @param amount number of sick days taken
     */
    public void useSickDay(double amount) {
        sickDaysLeft = YEARLY_SICK_DAYS - amount;
    }

    /**
     * Returns the number of sick days left.
     * @return number of sick days left
     */
    public double getSickDays() {
        return sickDaysLeft;
    }

    /**
     * Resets number of sick days left to the yearly allowance.
     */
    public void resetSickDays() {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    /**
     * Prints (on screen) the pay stub for the employee.
     */
    public void printPayStub() {
        System.out.println("--------------- PAY STUB ---------------");
        System.out.println(toString());
        System.out.printf("Yearly Salary: $%.2f\n", yearlySalary);
        System.out.printf("Current Month pay: $%.2f\n", pay());
        System.out.println("Sick days left: " + sickDaysLeft);
        System.out.println("----------------------------------------");
    }

    /**
     * returns a string with employee number, full name, title, and contract status
     * @return the string with employee information
     */
    @Override
    public String toString() {
        return "Employee: " + employeeNumber + ", "
                + firstName + " " + lastName + ", "
                + jobTitle + ", full-time";
    }


}




