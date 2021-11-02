import java.util.Scanner;

public class Main {
    static Employee employee = new Employee();

    public static void main(String[] args) {
        String choice = "n";
        int empChoice;
        do {
            System.out.println("What would you like to do?\n1. Add Employee\n2. Change Employee Department\n3. Promote Employee\n4. Show All Employees\n5. Calculate Salary\n6. Remove Employee\n7. Exit");
            empChoice = new Scanner(System.in).nextInt();
            switch (empChoice) {
                case 1:
                    employee.addEmployee();
                    break;
                case 2:
                    employee.shiftDepartment();
                    break;
                case 3:
                    employee.promoteEmployee(0);
                    break;
                case 4:
                    employee.showEmployees();
                    break;
                case 5:
                    employee.calculateSalary();
                    break;
                case 6:
                    employee.removeEmployee();
                    break;
                case 7:
                    choice = "Y";
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        while (choice.equals("n"));
    }

}
