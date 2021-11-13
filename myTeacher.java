import java.util.Scanner;
import java.util.ArrayList;
public class myTeacher{
    public String teacherName = "";
    public int teacherId = 0;
    public String teacherDepartment = "";
    public String teacherRank = "";
    public double teacherSalary = 0.00;
    public double teacherBalance = 0.00;
    public boolean teacherIsPaid = false;
    public ArrayList<myTeacher> ourTeachers = new ArrayList<myTeacher>;
    Scanner myScanner = new Scanner(System.in);
    public String askName = "Enter the name of the user";
    public String askId = "Enter the ID of the user";
    public String askDept = "Enter the department of the user";
    public String askRank = "Enter the rank of the user";
    public String askSalary = "Enter the salary of the user";
    public myTeacher(String name, int id, String dept, String rank, double salary, boolean isPaid){
        this.teacherName = name;
        this.teacherId = id;
        this.teacherDepartment = dept;
        this.teacherRank = rank;
        this.teacherSalary = salary;
        this.teacherIsPaid = isPaid;
    }
    public void grantSalary(){
        System.out.println(askId);
        int targetId = myScanner.nextInt();
        ourTeachers.get(targetId).teacherBalance +=  ourTeachers.get(targetId).teacherSalary;
        ourTeachers.get(targetId).teacherIsPaid = true;
    }
    public void insertAsTeacher(){
        System.out.println(askName);
        this.teacherName = myScanner.next();
        System.out.println(askId);
        this.teacherId = myScanner.nextInt();
        System.out.println(askDept);
        this.teacherDepartment = myScanner.next();
        System.out.println(askRank);
        this.teacherRank = myScanner.next();
        System.out.println(askSalary);
        this.teacherSalary = myScanner.nextDouble();
        ourTeachers.add(new myTeacher(this.teacherName, this.teacherId, this.teacherDepartment, this.teacherRank, this.teacherSalary, this.teacherIsPaid));
    }
    public void removeAsTeacher(){
        System.out.println(askId);
        String targetId = myScanner.next();
        ourTeachers.remove(ourTeachers.get(targetId));
    }
    public void showAsText(){
        System.out.println("name: " + this.teacherName + "id: " + this.teacherId + "dept: " + this.teacherDepartment + "rank: " + this.teacherRank);
    }
}