import java.util.Scanner;
class Student {
    //main method
    public static void main(String[] args){
       String stopAddCondition = "";
       continueAdd()
       stopAdd()
       
       (stopAddCondition = addUser() ? continueAdd : stopAdd)){

       };
    }
    //a function to add users to the database
    public static String addUser(){
        // myScanner object of class Scanner
        Scanner myScanner = new Scanner(System.in);
        //local variables
        String stop_condition = "";
        String stud_name = "";
        int stud_age = 0;
        //ask for user input
        System.out.println("Enter name and age");
        stud_name = myScanner.nextLine();
        stud_age = myScanner.nextInt();
        // new_student object of class NewStudent using user input as parameters
        NewStudent new_student = new NewStudent(stud_name, stud_age); 
        System.out.println("-----------Created new student-------------");
        String gotten_description = "";
        gotten_description = new_student.CreateDescription();
        new_student.DescribeStudent(gotten_description);
        System.out.println("------------------Finished describing new student---------");
        System.out.println("Finished? (Y/n)");
        stop_condition = myScanner.nextLine();
        return stop_condition;
    }
}
//A blueprint for objects of type NewStudent
class NewStudent {
    //local variables in NewStudent class
    public String student_name = "";
    public int student_age = 0;
    //constructor for NewStudent
    NewStudent(String namePassed, int agePassed){
        this.student_name = namePassed;
        this.student_age = agePassed;
    }
    //fetch name and age for NewStudent and return it 
    public String CreateDescription() {
        String my_description = "";
        my_description = "name: " + this.student_name + ", " + "age: " + this.student_age;
        return( my_description );
    }
    //display name and age for NewStudent
    public void DescribeStudent(String gotten_values){
        System.out.println(gotten_values);
    }
}
