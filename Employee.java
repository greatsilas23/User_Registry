import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    public String employeeName, birthDate, employeeDepartment, employeePosition;
    public double employeeBasicSalary, employeeCommuterAllowance;
    public int employeeId;
    public boolean isIn;

    public ArrayList<Employee> employeeLinkedList = new ArrayList<>();

    public ArrayList<Integer> employeeIds = new ArrayList<Integer>();

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
        employeeLinkedList.add(employee);
        employeeIds.add(employee.employeeId);
        System.out.println("-----Added The Following Employee-----\n ".concat(String.valueOf(employee.employeeId).concat(" ").concat(employee.employeeName).concat(" ").concat(employee.employeeDepartment)));
    }

    //a function to remove users from the database
    public void removeEmployee() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the employee's ID who you want to remove");
        int empCurrId = s.nextInt();
        int currIndex = 0;
        for (int i = 0; i < employeeIds.size(); i++) {
            if (employeeIds.contains(empCurrId)) {
                isIn = true;
                currIndex = empCurrId;
            } else {
                System.out.println("No such employee in our records. Please retry");
            }
        }
        if (isIn) {
            employeeLinkedList.remove(currIndex);
            employeeIds.remove(currIndex);
        } else {

        }
    }

    //Calculate an employee's gross salary
    protected void calculateSalary() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the employee's ID whose salary you want to calculate");
        int empCurrId = s.nextInt();
        int currIndex = 0;
        //check if ID is in database
        for (int i = 0; i < employeeIds.size(); i++) {
            if (employeeIds.contains(empCurrId)) {
                isIn = true;
                currIndex = employeeIds.get(empCurrId);
            } else {
                System.out.println("No such employee in our records. Please retry");
            }
        }
        if (isIn) {
            double empCommuterAllowance = employeeLinkedList.get(currIndex).employeeCommuterAllowance;
            double empBasicSalary = employeeLinkedList.get(currIndex).employeeBasicSalary;
            System.out.println(empCommuterAllowance + empBasicSalary);
        } else {

        }
    }

    protected void shiftDepartment() {
        System.out.println("Enter the employee's ID whose department you want to change");
        Scanner s = new Scanner(System.in);
        int currIndex = 0;
        int empCurrId = s.nextInt();
        promoteEmployee(empCurrId);
        for (int i = 0; i < employeeIds.size(); i++) {
            if (employeeIds.contains(empCurrId)) {
                isIn = true;
                currIndex = employeeIds.indexOf(empCurrId);
            } else {
                System.out.println("No such employee in our records. Please retry");
            }
        }
        if (isIn) {
            System.out.println("Enter the employee's new department");
            String newDepartment = s.next();
            String employeeName = employeeLinkedList.get(currIndex).employeeName;
            String birthDate = employeeLinkedList.get(currIndex).birthDate;
            double empCommuterAllowance = employeeLinkedList.get(currIndex).employeeCommuterAllowance;
            double empBasicSalary = employeeLinkedList.get(currIndex).employeeBasicSalary;
            Employee shiftEmployee = new Employee();
            shiftEmployee.employeeId = empCurrId;
            shiftEmployee.employeeName = employeeName;
            shiftEmployee.birthDate = birthDate;
            shiftEmployee.employeeCommuterAllowance = empCommuterAllowance;
            shiftEmployee.employeeBasicSalary = empBasicSalary;
            shiftEmployee.employeeDepartment = newDepartment;
            employeeLinkedList.set(currIndex, shiftEmployee);
            employeeIds.set(currIndex, empCurrId);
        } else {

        }
    }

    protected void showEmployees() {
        if (employeeLinkedList.size() > 0) {
            for (int i = 0; i < employeeLinkedList.size(); i++) {
                toShowString(employeeLinkedList.get(i));
            }
        } else {
            System.out.println("No employees");
        }
    }

    private void toShowString(Employee employee) {
        System.out.println("id: " + String.valueOf(employee.employeeId) + " " + "name: " + (employee.employeeName) + " " + "dept: " + (employee.employeeDepartment) + " \n" + "position: " + (employee.employeePosition));
    }

    protected void promoteEmployee(int setPromotion) {
        int empIndex = 0;
        if (setPromotion == 0) {
            System.out.println("Enter the employee's ID whose position you want to change");
            Scanner s = new Scanner(System.in);
            int empId = s.nextInt();
            for (int i = 0; i < employeeIds.size(); i++) {
                if (employeeIds.contains(empId)) {
                    isIn = true;
                    empIndex = employeeIds.indexOf(empId);
                } else {
                    System.out.println("No such employee in our records. Please retry");
                }
            }
            if (isIn) {
                System.out.println("Enter the employee's new position");
                String newPosition = s.next();
                System.out.println("Enter the employee's new salary");
                double newSalary = s.nextDouble();
                String employeeName = employeeLinkedList.get(empIndex).employeeName;
                String birthDate = employeeLinkedList.get(empIndex).birthDate;
                String employeeDepartment = employeeLinkedList.get(empIndex).employeeDepartment;
                double empCommuterAllowance = employeeLinkedList.get(empIndex).employeeCommuterAllowance;
                Employee shiftEmployee = new Employee();
                shiftEmployee.employeeId = empId;
                shiftEmployee.employeePosition = newPosition;
                shiftEmployee.employeeName = employeeName;
                shiftEmployee.birthDate = birthDate;
                shiftEmployee.employeeCommuterAllowance = empCommuterAllowance;
                shiftEmployee.employeeBasicSalary = newSalary;
                shiftEmployee.employeeDepartment = employeeDepartment;
                employeeLinkedList.set(empIndex, shiftEmployee);
                employeeIds.set(empIndex, empId);
            } else {
                System.out.println("Enter the employee's new position");
                String newPosition = s.next();
                System.out.println("Enter the employee's new salary");
                double newSalary = s.nextDouble();
                String employeeName = employeeLinkedList.get(setPromotion).employeeName;
                String birthDate = employeeLinkedList.get(setPromotion).birthDate;
                String employeeDepartment = employeeLinkedList.get(setPromotion).employeeDepartment;
                double empCommuterAllowance = employeeLinkedList.get(setPromotion).employeeCommuterAllowance;
                Employee shiftEmployee = new Employee();
                shiftEmployee.employeeId = empId;
                shiftEmployee.employeePosition = newPosition;
                shiftEmployee.employeeName = employeeName;
                shiftEmployee.birthDate = birthDate;
                shiftEmployee.employeeCommuterAllowance = empCommuterAllowance;
                shiftEmployee.employeeBasicSalary = newSalary;
                shiftEmployee.employeeDepartment = employeeDepartment;
                employeeLinkedList.set(setPromotion, shiftEmployee);
                employeeIds.set(setPromotion, empId);
            }
        }
    }
}