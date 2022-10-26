package payroll;

/**
 * An abstract class that manages full-time and part-time employee's information,
 * such as name, ID, job title, yearly salary, and number of sick days.
 * Sick days can be taken or reset.
 * @author Khadija
 */
abstract class Employee {
    protected String employeeNumber;
    protected String lastName;
    protected String firstName;
    protected String jobTitle;

    /**
     * Constructor with employee number, last name, first name and job title.
     * @param employeeNumber employee number
     * @param lastName last name
     * @param firstName first name
     * @param jobTitle job title
     */
    public Employee(String employeeNumber, String lastName, String firstName, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
    }

    /**
     * Gets the employee number.
     * @return employee number
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Gets the employee's last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the employee's first name.
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the employee's job title.
     * @return job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * An abstract method that returns an employee’s pay.
     * @return employee's pay
     */
    abstract double pay();

    /**
     * An abstract method that updates the sick day information for an employee.
     * @param amount number of sick days used
     */
    abstract void useSickDay(double amount);

    /**
     *  An abstract method that returns the number of sick days taken or left.
     * @return number of sick days taken or left
     */
    abstract double getSickDays();

    /**
     *  An abstract method that resets the sick day information for an employee.
     */
    abstract void resetSickDays();

    /**
     * An abstract method that prints (display on screen) the monthly pay stub of an employee.
     */
    abstract void printPayStub();

    /**
     * Returns a string with employee number, full name, title
     * @return String with employee information
     */
    @Override
    public String toString() {
        return  "Employee: " + employeeNumber + ", " + firstName + " " +lastName
            + ", " + jobTitle;
    }


}

