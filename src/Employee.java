import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    public String employeeName, birthDate, employeeDepartment, employeePosition;
    public Double employeeBasicSalary, employeeCommuterAllowance;
    public int employeeId;

    public ArrayList<Employee> employeeArrayList = new ArrayList<>();


    public Employee() {

    }


    public Employee(String employeeName, String birthDate, String employeeDepartment, String employeePosition, Double employeeBasicSalary, Double employeeCommuterAllowance, int employeeId) {
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.employeeDepartment = employeeDepartment;
        this.employeePosition = employeePosition;
        this.employeeBasicSalary = employeeBasicSalary;
        this.employeeCommuterAllowance = employeeCommuterAllowance;
        this.employeeId = employeeId;
    }

    //main method
    public static void main(String[] args) {
        String choice = null;
        do {
            System.out.println("What would you like to do?\n1. Add Employee\n2. Change Employee Department\n3. Promote Employee\n4. Quit");
            int empChoice = new Scanner(System.in).nextInt();
            switch (empChoice) {
                case 1:
                    new Employee().addEmployee();
                    break;
                case 2:
                    new Employee().shiftDepartment();
                    break;
                case 3:
                    new Employee().promoteEmployee();
                    break;
                case 4:
                    if (new Employee().employeeArrayList.isEmpty()) {
                        System.out.println("No employees found");
                    } else {
                        System.out.println(new Employee().employeeArrayList.get(0).employeeName);
                    }
                    //choice = new Scanner(System.in).next();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            System.out.println("Exit?\n1. Y\n2. n");
            choice = new Scanner(System.in).next();
        } while (choice.equals("n"));
    }


    //a function to add users to the database
    public void addEmployee() {
        // myScanner object of class Scanner
        Scanner myScanner = new Scanner(System.in);
        //local variables
        Employee employee = new Employee();
        //ask for user input
        System.out.println("Enter new employee's ID");
        int employeeId = myScanner.nextInt();
        System.out.println("Enter new employee's Name");
        String employeeName = myScanner.next();
        System.out.println("Enter new employee's Date Of Birth");
        String birthDate = myScanner.next();
        System.out.println("Enter new employee's Department");
        String employeeDepartment = myScanner.next();
        System.out.println("Enter new employee's Position");
        String employeePosition = myScanner.next();
        System.out.println("Enter new employee's Basic Salary");
        double employeeBasicSalary = myScanner.nextDouble();
        System.out.println("Enter new employee's Commute Allowance");
        double employeeCommuterAllowance = myScanner.nextDouble();
        employee.employeeId = employeeId;
        employee.employeeName = employeeName;
        employee.birthDate = birthDate;
        employee.employeeDepartment = employeeDepartment;
        employee.employeePosition = employeePosition;
        employee.employeeBasicSalary = employeeBasicSalary;
        employee.employeeCommuterAllowance = employeeCommuterAllowance;
        employeeArrayList.add(employeeId, employee);
        System.out.println(String.valueOf(employee.employeeId).concat(" ").concat(employee.employeeName));
    }

    //Calculate an employee's gross salary
    private void calculateSalary(Employee employee) {
        System.out.println("Enter the employee's ID whose salary you want to calculate");
        Scanner s = new Scanner(System.in);
        int empIndex = s.nextInt();
        double empCommuterAllowance = employeeArrayList.get(empIndex).employeeCommuterAllowance;
        double empBasicSalary = employeeArrayList.get(empIndex).employeeBasicSalary;
        System.out.println(empCommuterAllowance + empBasicSalary);
    }

    private void shiftDepartment() {
        System.out.println("Enter the employee's ID whose department you want to change");
        Scanner s = new Scanner(System.in);
        int empIndex = s.nextInt();
        System.out.println("Enter the employee's new department");
        String newDepartment = s.next();
        String employeeName = employeeArrayList.get(empIndex).employeeName;
        String birthDate = employeeArrayList.get(empIndex).birthDate;
        double empCommuterAllowance = employeeArrayList.get(empIndex).employeeCommuterAllowance;
        double empBasicSalary = employeeArrayList.get(empIndex).employeeBasicSalary;
        Employee shiftEmployee = new Employee();
        shiftEmployee.employeeId = empIndex;
        shiftEmployee.employeeName = employeeName;
        shiftEmployee.birthDate = birthDate;
        shiftEmployee.employeeCommuterAllowance = empCommuterAllowance;
        shiftEmployee.employeeBasicSalary = empBasicSalary;
        shiftEmployee.employeeDepartment = newDepartment;
        employeeArrayList.set(empIndex, shiftEmployee);
    }

    private void promoteEmployee() {
        System.out.println("Enter the employee's ID whose position you want to change");
        Scanner s = new Scanner(System.in);
        int empIndex = s.nextInt();
        System.out.println("Enter the employee's new position");
        String newPosition = s.next();
        System.out.println("Enter the employee's new salary");
        double newSalary = s.nextDouble();
        String employeeName = employeeArrayList.get(empIndex).employeeName;
        String birthDate = employeeArrayList.get(empIndex).birthDate;
        String employeeDepartment = employeeArrayList.get(empIndex).employeeDepartment;
        double empCommuterAllowance = employeeArrayList.get(empIndex).employeeCommuterAllowance;
        Employee shiftEmployee = new Employee();
        shiftEmployee.employeeId = empIndex;
        shiftEmployee.employeePosition = newPosition;
        shiftEmployee.employeeName = employeeName;
        shiftEmployee.birthDate = birthDate;
        shiftEmployee.employeeCommuterAllowance = empCommuterAllowance;
        shiftEmployee.employeeBasicSalary = newSalary;
        shiftEmployee.employeeDepartment = employeeDepartment;
        employeeArrayList.set(empIndex, shiftEmployee);
    }

}