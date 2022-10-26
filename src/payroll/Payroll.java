package payroll;

import java.util.ArrayList;
import java.io.*;

/**
 * Manages a list of employees (of type Employee). Employee objects are
 * stored in an ArrayList. Employees can be loaded, saved, listed, and shown pay stubs.
 * Sick days can be used. Employees are referenced by their String employee ID.
 * @author Khadija
 */
public class Payroll {
    private ArrayList<Employee> staffList;

    //public Payroll(){}

    /**
     * Loads employee information from the specified file.
     * @param filename name of the file getting information from
     * @return true when the employee information is loaded
     */
    public boolean loadStaffList(String filename) {

        String line;
        BufferedReader reader;
        this.staffList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();

            while (line != null) {

                String[] values = line.split(",");

//                System.out.println("lines = " + Arrays.toString(values));
                String employeeNumber = values[0];
                String lastName = values[1];
                String firstName = values[2];
                String jobTitle = values[3];

                if (values[4].equals("full-time")) {
                    double yearlySal = Double.parseDouble(values[5]);
                    double sickDaysleft = Double.parseDouble(values[6]);
                    Employee employee = new FullTimeEmployee(employeeNumber, lastName, firstName, jobTitle, yearlySal, sickDaysleft);
                    staffList.add(employee);

                } else {
                    double numHoursAssigned = Double.parseDouble(values[5]);
                    double hourlyWage = Double.parseDouble(values[6]);
                    double sickDaysTaken = Double.parseDouble(values[7]);
                    Employee employee = new PartTimeEmployee(employeeNumber, lastName, firstName, jobTitle, numHoursAssigned, hourlyWage, sickDaysTaken);
                    staffList.add(employee);
                }
                line = reader.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
            }
            reader.close();

        } catch (IOException iox) {
            System.out.println(iox.getMessage());
            return false;

        }
        return true;
    }

    /**
     * Saves employee information to the specified file.
     * @param filename name of the file where information will be saved
     * @return true when employee information is saved
     */
    public boolean saveStaffList(String filename) {

        try {
            FileWriter writer = new FileWriter(filename);
            for (Employee person: staffList) {
                writer.write(person.getEmployeeNumber() + ",");
                writer.write(person.getLastName() + ",");
                writer.write(person.getFirstName() +",");
                writer.write(person.getJobTitle() +",");

                if (person instanceof FullTimeEmployee) {
                    writer.write("full-time,");
                    writer.write(Double.toString(((FullTimeEmployee) person).getYearlySalary()) + ",");
                    writer.write(Double.toString(person.getSickDays()));
                    writer.write("\n");
                }

                else {
                    writer.write("part-time,");
                    writer.write(Double.toString(((PartTimeEmployee) person).getNumHoursAssigned()) + ",");
                    writer.write(Double.toString(((PartTimeEmployee) person).getHourlyWage()) + ",");
                    writer.write(Double.toString(person.getSickDays()));
                    writer.write("\n");
                }

            }
        writer.close();

        } catch (IOException e) {
            System.out.println("Problems");
            e.printStackTrace();
            return false;
        }

        return true;
    }


    /**
     * Lists all employees by printing on the screen.
     */
    public void listAllEmployees(){
        System.out.println("All Employees: ");
        for (Employee person : staffList) {
            System.out.println(person.toString());
        }
        System.out.println();
    }

    /**
     * Return an employee matching the id given as parameter.
     * @param id employee number
     * @return employee with matching id
     */
    public Employee getEmployee(String id){
        for (Employee person: staffList) {

            if (person.getEmployeeNumber().equals(id)) {
                return person;
            }
        }
        System.out.println("Employee not found.");
        return null;
    }

    /**
     *  Prints on screen the pay stub for the employee by id.
     * @param id employee number
     */
    public void printEmployeePayStub(String id) {
        System.out.println();

        Employee person = getEmployee(id);
        if (person != null) {
            person.printPayStub();
        }
        System.out.println();
    }

    /**
     * Prints on screen the pay stub (for the current month) for all employees.
     */
    public void printAllPayStubs(){
        System.out.println("All Employee Pay Stubs:\n");
        for (Employee person: staffList) {
            person.printPayStub();
            System.out.println("\n");
        }
    }

    /**
     * Updates sick day information for the employee specified by the employee number and amount.
     * @param id employee number
     * @param amount number of sick days used
     */
    public void enterSickDay(String id, double amount) {
        Employee person = getEmployee(id);
        if (person != null) {
            person.useSickDay(amount);
            System.out.println("New sick days taken: " + amount);
        }
        System.out.println();
    }

    /**
     *  Resets the yearly sick day information for all full-time employees.
     */
    public void yearlySickDayReset(){
        for (Employee person : staffList) {
            if (person instanceof FullTimeEmployee) {
                person.resetSickDays();
            }
        }
    }

    /**
     *  Resets the monthly sick day information for all part-time employees.
     */
    public void monthlySickDayReset(){
        for (Employee person: staffList) {
            if (person instanceof PartTimeEmployee) {
                person.resetSickDays();

            }
        }
    }
    

}
