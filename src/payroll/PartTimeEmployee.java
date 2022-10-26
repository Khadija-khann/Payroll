package payroll;

/**
 * Manages part-time employee's information, such as name, ID, job title, pay, and number of sick days.
 * Sick days can be taken or reset.
 * @author Khadija
 */
public class PartTimeEmployee extends Employee {
    private static double HOURS_PER_DAY = 7.0;
    private double numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    /**
     * Constructor with employee number, last name, first name, job title,
     * number of hours assigned, hourly wage, and number of sick days taken.
     * @param employeeNumber employee number
     * @param lastName last name
     * @param firstName first name
     * @param jobTitle job title
     * @param numHoursAssigned number of hours assigned
     * @param hourlyWage hourly wage
     * @param sickDaysTaken number of sick days taken
     */
    public PartTimeEmployee(String employeeNumber, String lastName, String firstName, String jobTitle, double numHoursAssigned, double hourlyWage, double sickDaysTaken) {
        super (employeeNumber, lastName, firstName, jobTitle);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * Gets the number of work hours assigned to the part-time employee.
     * @return number of hours
     */
    public double getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * Gets the hourly wage of the part-time employee.
     * @return hourly wage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Returns the amount earned based on the hourly rate and the number of hours worked.
     * Pay is deducted for absent days.
     * @return amount earned
     */
    public double pay(){
        return (numHoursAssigned * hourlyWage) - ((sickDaysTaken * HOURS_PER_DAY) * hourlyWage);
    }

    /**
     * Update the number of sick days taken by the employee.
     * @param amount number of sick days
     */
    public void useSickDay(double amount){
        sickDaysTaken = amount;
    }

    /**
     * Returns the number of sick days taken.
     * @return number of sick days taken
     */
    public double getSickDays() {
        return sickDaysTaken;
    }

    /**
     * Resets number of sick days taken to 0.
     */
    public void resetSickDays() {
        sickDaysTaken = 0.0;
    }

    /**
     * Prints (on screen) the pay stub for the employee.
     */
    public void printPayStub() {
        System.out.println("--------------- PAY STUB ---------------");
        System.out.println(toString());
        System.out.printf("Hourly Wage: $%.2f\n", hourlyWage);
        System.out.println("Number of hours assigned: " + numHoursAssigned);
        System.out.println("Sick days taken: " + sickDaysTaken);
        System.out.printf("Current Month pay: $%.2f\n", pay());
        System.out.println("----------------------------------------");
    }


    /**
     * Returns a string with employee number, full name, title, and contract status.
     * @return the string with employee information
     */
    @Override
    public String toString(){
        return "Employee: " + employeeNumber + ", "
                + firstName + " " + lastName + ", "
                + jobTitle + ", part-time";
    }

}
