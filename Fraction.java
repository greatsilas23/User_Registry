//Date created: Sep 29  
import java.util.Scanner;
//class to create objects of type fraction
class Fraction {
    //global variables
    public int a = 0;
    public int b = 0;
    //method overloading
    //set initial values
    Fraction(){
        this.a = 0;
        this.b = 1;
    }
    //get user values
    Fraction(int theNum, int theDen){
        this.a = theNum;
        this.b = theDen;
    }
    
    // show output
    public static void displayFraction(Fraction fracToDisplay){
        System.out.println(fracToDisplay.a +"/"+ fracToDisplay.b);
    }
    //create object of type Fraction
    public static Fraction initializeFirstFraction(){
        Fraction tempFraction = new Fraction();
        try(Scanner myScanner = new Scanner(System.in)){
            System.out.println("Enter numerator for fraction ");
            tempFraction.a = myScanner.nextInt();
            System.out.println("Enter denominator for fraction ");
            tempFraction.b = myScanner.nextInt();
        }
        return new Fraction(tempFraction.a, tempFraction.b);
    }
    public static Fraction initializeSecondFraction(){
        Fraction tempFraction = new Fraction();
        try(Scanner myScanner = new Scanner(System.in)){

            System.out.println("Enter numerator for fraction ");
            tempFraction.a = myScanner.nextInt();
            System.out.println("Enter denominator for fraction ");
            tempFraction.b = myScanner.nextInt();
        }
        return new Fraction(tempFraction.a, tempFraction.b);
    }
    //add two fractions
    public static Fraction add(int a, int b, int c, int d){
        int theNum = 0;
        int theDen = 0;
        theNum = ((a * d)+(b * c));
        theDen = (b * d);
        return new Fraction(theNum, theDen);
    }
    //subtract two fractions
    public static Fraction subtract(int a, int b, int c, int d){
        int theNum = ((a * d)-(b * c));
        int theDen = (b * d);
        return reduce(new Fraction(theNum, theDen));
    }    
    //compare two fractions
    public static void compare(int a, int b, int c, int d){
        if(a/b > c/d)
            System.out.println(a +"/"+ b +" is larger than "+c +"/"+ d);
        else
        System.out.println(a +"/"+ b +" is smaller than "+c +"/"+ d);
    }
    //multiply two fractions
    public static Fraction multiply(int a, int b, int c, int d){
        int theNum;
        int theDen;
        theNum = a * c;
        theDen = b * d;
        return reduce(new Fraction(theNum, theDen));
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
        
        try (java.util.Scanner myScanner = new java.util.Scanner(System.in)){
            //go through all the steps as long as exit condition is 'n'
            do{
                //show menu of actions
                System.out.println("\n SELECT AN ACTION \n1. Add fractions \n2. Subtract fractions \n3. Compare fractions \n4. Multiply fractions");
                theChoice = myScanner.nextInt();
                //if user wants to add two fractions
                if(theChoice == 1){
                    Fraction firstFraction = new Fraction();
                    firstFraction = firstFraction.initializeFirstFraction();
                    Fraction secondFraction = new Fraction();
                    secondFraction = initializeSecondFraction();
                    Fraction result = add(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    displayFraction(result);
                }
                //if user wants to subtract two fractions
                else if(theChoice == 2){
                    Fraction tempFraction = new Fraction();
                    Fraction firstFraction = initializeFirstFraction();
                    Fraction secondFraction = initializeSecondFraction();
                    tempFraction = tempFraction.subtract(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    Fraction result = tempFraction.reduce(tempFraction);
                    tempFraction.displayFraction(result);
                }
                //if user wants to compare two fractions
                else if(theChoice == 3){
                    Fraction tempFraction = new Fraction();
                    Fraction firstFraction = initializeFirstFraction();
                    Fraction secondFraction = initializeSecondFraction();
                    tempFraction.compare(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                }
                //multiplying two fractions
                else if(theChoice == 4){
                    Fraction tempFraction = new Fraction();
                    Fraction firstFraction = initializeFirstFraction();
                    Fraction secondFraction = initializeSecondFraction();
                    tempFraction = tempFraction.multiply(firstFraction.a, firstFraction.b, secondFraction.a, secondFraction.b);
                    Fraction result = tempFraction.reduce(tempFraction);
                    tempFraction.displayFraction(result);
                }
                else {
                    System.out.println("Invalid choice");
                    continue;
                }
                System.out.println("Exit? (Y/n)");
                exitCondition = myScanner.nextLine();
            }while(exitCondition.equals("n"));
        }
    }
}
