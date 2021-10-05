//Date created: Sep 29  
import java.util.Scanner;
//class to create objects of type fraction
public class Fraction {
    //global variables
    public int a = 0;
    public int b = 0;
    //set initial values
    Fraction(){
        super();
        this.a = 0;
        this.b = 1;
    }
    //get user values using method overloading
    Fraction(int a, int b){
        super();
        this.a = a;
        this.b = b;
    }
    
    // show output
    public static void displayFraction(Fraction f){
        System.out.println(f.a +"/"+ f.b);
    }
    //create object of type Fraction
    public Fraction initializeFirstFraction(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter numerator for first fraction ");
        this.a = myScanner.nextInt();
        System.out.println("Enter denominator for first fraction ");
        this.b = myScanner.nextInt();
        myScanner.close();
        return new Fraction(this.a, this.b);
    }
    public Fraction initializeSecondFraction(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter numerator for second fraction ");
        this.a = myScanner.nextInt();
        System.out.println("Enter denominator for second fraction ");
        this.b = myScanner.nextInt();
        myScanner.close();
        return new Fraction(this.a, this.b);
    }
    //add two fractions
    public static Fraction add(int a, int b, int c, int d){
        int num, den;
        num = ((a * d)+(b * c));
        den = (b * d);
        return reduce(new Fraction(num, den));
    }
    //subtract two fractions
    public static Fraction subtract(int a, int b, int c, int d){
        int num, den;
        num = ((a * d)-(b * c));
        den = (b * d);
        return reduce(new Fraction(num, den));
    }    
    //compare two fractions
    public static void compare(int a, int b, int c, int d){
        if(a/b > c/d)
            System.out.println(a +"/"+ b +" is larger than "+ c +"/"+ d);
        else
            System.out.println(a +"/"+ b +" is smaller than "+ c +"/"+ d);
    }
    //multiply two fractions
    public static Fraction multiply(int a, int b, int c, int d){
        int num, den;
        num = a * c;
        den = b * d;
        return reduce(new Fraction(num, den));
    }
    //reduce fraction
    public static Fraction reduce(Fraction theFraction){
        for(int i = 1; i <= theFraction.a; i++){
            if(theFraction.a % i == 0 && theFraction.b % i == 0){
                theFraction.a = theFraction.a / i;
                theFraction.b = theFraction.b / i;
            }
        }
        return new Fraction(theFraction.a, theFraction.b) ;
    }
    //main method
    public static void main(String[] args){
        //local variables
        int theChoice = 0;
        String exitCondition = "";
        Scanner myScanner = new Scanner(System.in);
        //go through all the steps as long as exit condition is 'n'
        do{
            //show menu of actions
            System.out.println("\n SELECT AN ACTION \n1. Add fractions \n2. Subtract fractions \n3. Compare fractions \n4. Multiply fractions");
            theChoice = myScanner.nextInt();
            //create an object to store result
            Fraction firstFraction = new Fraction();
            Fraction secondFraction = new Fraction();
            Fraction myFraction = new Fraction();
            //switch between user choices
            switch(theChoice){
                //add two fractions
                case 1:
                    firstFraction = new Fraction().initializeFirstFraction();
                    secondFraction = new Fraction().initializeSecondFraction();
                    myFraction = add(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    System.out.println("Result of "+firstFraction.a+"/"+firstFraction.b+" added to "+secondFraction.a+"/"+secondFraction.b+" is "+myFraction.a+"/"+myFraction.b);
                    break;
                //subtract two fractions
                case 2:
                    firstFraction = new Fraction().initializeFirstFraction();
                    secondFraction = new Fraction().initializeSecondFraction();
                    myFraction = subtract(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    System.out.println("Result of "+firstFraction.a+"/"+firstFraction.b+" added to "+secondFraction.a+"/"+secondFraction.b+" is "+myFraction.a+"/"+myFraction.b);
                    break;
                //compare two fractions
                case 3:
                    firstFraction = new Fraction().initializeFirstFraction();
                    secondFraction = new Fraction().initializeSecondFraction();
                    compare(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    break;                    
                //multiplying two fractions
                case 4:
                    firstFraction = new Fraction().initializeFirstFraction();
                    secondFraction = new Fraction().initializeSecondFraction();
                    myFraction = multiply(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    System.out.println("Result of "+firstFraction.a+"/"+firstFraction.b+" added to "+secondFraction.a+"/"+secondFraction.b+" is "+myFraction.a+"/"+myFraction.b);
                    break;
                default: 
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Exit? (Y/n)");
            exitCondition = myScanner.nextLine();
        }while(exitCondition.equals("n"));
        myScanner.close();
    }
}
