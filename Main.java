import java.util.Scanner;
import java.util.HashMap;
class Main {
    public static void main(String[] args){
        int usrChoice = 0;
        char isExit = "n";
        Scanner myScanner = new Scanner(System.in);
        HashMap<Integer, String> theStudents = new HashMap<Integer, String>;
        HashMap<Integer, String> theTeachers = new HashMap<Integer, String>;
        myStudent newStudent = new myStudent(0, '', '', '');
        myTeacher newTeacher = new Teacher(0, '', '', '');
        mySchool newSchool = new mySchool(theStudents, theTeachers)
        String welcomeText = "Welcome to myStudent";
        while(isExit){
            System.out.println(welcomeText);
            System.out.println("1. Add student\n2. Add teacher\n3. View Student\n4. View Teacher\n5. Master balance\n6. Exit");
            usrChoice = myScanner.nextInt();
            switch(usrChoice) {
                case 1:
                    newStudent.addStudent();
                    break;
                case 2:
                    newTeacher.addTeacher();
                    break;
                case 3:
                    mySchool.viewStudent();
                    break;
                case 4:
                    mySchool.viewTeacher();
                    break;
                case 5:
                    mySchool.showBalanceMaster();
                    break;
                case 6:
                    isExit = "Y";
                    break;
                default:
                    System.out.println("Sorry, try again");
                    break;
            }
        }
    }
}