import java.util.Scanner;
import java.util.ArrayList;
public class myStudent{
    public String studentName = "";
    public String studentSeniority = "";
    public int studentId = 0;
    public String studentDepartment = "";
    public double studentGPA = 0.00;
    public double studentAverage = 0.00;
    public boolean studentIsContinuing = true;
    public ArrayList<myStudent> ourStudents = new ArrayList<myStudent>;
    Scanner myScanner = new Scanner(System.in);
    public String askName = "Enter the name of the user";
    public String askSeniority = "Enter the rank of the user";
    public String askId = "Enter the ID of the user";
    public String askDept = "Enter the seniority of the user";
    public myStudent(String name, String seniority, int id, String department){
        this.studentName = name;
        this.studentSeniority = seniority;
        this.studentId = id;
        this.studentDepartment = department;
    }
    public void grantGpa(){
        System.out.println(askId);
        int targetId = myScanner.nextInt();
        ourStudents.get(targetId).studentAverage +=  ourStudents.get(targetId).studentGpa;
        ourStudents.get(targetId).studentIsContinuing = true;
    }
    public void insertAsStudent(){
        System.out.println(askName);
        this.studentName = myScanner.next();
        System.out.println(askId);
        this.studentId = myScanner.nextInt();
        System.out.println(askDept);
        this.studentDepartment = myScanner.next();
        System.out.println(askSeniority);
        this.studentSeniority = myScanner.next();
        System.out.println(askGpa);
        this.studentGpa = myScanner.nextDouble();
        ourStudents.add(new myStudent(this.studentName, this.studentId, this.studentDepartment, this.studentSeniority, this.studentGpa, this.studentIsContinuing));
    }
    public void removeAsStudent(){
        System.out.println(askId);
        String targetId = myScanner.next();
        ourStudents.remove(ourStudents.get(targetId));
    }
    public void showAsText(){
        System.out.println("name: " + this.studentName + "id: " + this.studentId + "dept: " + this.studentDepartment + "seniority: " + this.studentSeniority);
    }
}