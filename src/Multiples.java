import java.util.ArrayList;
import java.util.Scanner;
/**
 * Program Functions
 * - User inputs 1 or two numbers to be checked against
 * - User inputs a maximum number
 * - User decides if they want
 *      1< see all the multiples (in ascending or descending order)
 *      2< see the top 10 multiples
 *      3< See the sum of all multiples
 *      4< Check to see if there's a certain multiple, if so which number
 *
 * @author Patrick Lennon
 */
public class Multiples {

    public static void main(String[] args) {
        long sum = 0; //sum of all multiples
        long max = 0; //the maximum number to be checked against
        int first;   //the first number whose multiples the program will search for
        int second;  //the second number whose multiples the program will search for
        int checkNum; //the number of numbers we're checking multiples of
        String action; //what the user wants to do with the multiples
        ArrayList<Integer> allMultiples = new ArrayList<>(); //All the multiples
        boolean yn = false; //used to determne print message when checking for a specific multiple

        Scanner scan = new Scanner(System.in);


        System.out.println("Hello! This is the Multiples program.");
        System.out.println("You enter 2 numbers and a maximum number, and this program goes through all the multiples of ");
        System.out.println("both numbers up to the max number. You can then decide if you want to see the sum of all the ");
        System.out.println("multiple, or check to see if there's a specific multiple.");
        System.out.println();

        System.out.print("Please enter a maximum number:  ");
        max = scan.nextLong();
        while (max < 1){
            System.out.println("Please pick a positive number");
            System.out.print("Please enter a maximum number:  ");
            max = scan.nextLong();
        }

        System.out.print("Please enter the first number:      ");
        first = scan.nextInt();
        while(first == max){
            System.out.println("Please enter a number lower than the maximum number");
            System.out.print("Please enter the first number:      ");
            first = scan.nextInt();
        }
        while(first <= 0){
            System.out.println("Please make sure you enter a positive number:       ");
            System.out.print("Please enter the first number:      ");
            first = scan.nextInt();
        }

        System.out.print("Please enter the second number:      ");
        second = scan.nextInt();
        while(second == max){
            System.out.println("Please enter a number lower than the maximum number");
            System.out.print("Please enter the second number:      ");
            second = scan.nextInt();
        }
        while(second <= 0){
            System.out.println("Please make sure you enter a positive number:       ");
            System.out.print("Please enter the second number:      ");
            second = scan.nextInt();
        }

        System.out.println("Running....");
        for(int i = 1; i < max; i++){
            if(i%first == 0 || i%second == 0){
                allMultiples.add(i);
            }
        }
        System.out.println("Complete. Got all multiples.");
        System.out.println();
        System.out.print("Do you want to see the sum of all numbers, or check to see if there's a specific numtiple?(SUM/CHECK):     ");
        action = scan.next();
        while(!action.equalsIgnoreCase("SUM") && !action.equalsIgnoreCase("CHECK")){
            System.out.println("Please enter SUM or CHECK");
            System.out.println("Do you want to see the sum of all numbers, or check to see if there's a specific numtiple?(SUM/CHECK):     ");
            action = scan.next();
        }

        if(action.equalsIgnoreCase("sum")){
            System.out.println("Retrieving the sum...");
            for(int num: allMultiples){
                sum += num;
            }
            System.out.println("Total sum: " + sum);
        }

        else if(action.equalsIgnoreCase("check")){
            System.out.print("What number do you want to check?:      ");
            checkNum = scan.nextInt();
            while (checkNum <= 0){
                System.out.println("Please enter a positive number");
                System.out.print("What number do you want to check?:      ");
                checkNum = scan.nextInt();
            }
            System.out.println("Checking....");
            int counter = 1;
            for(int num: allMultiples){
                if(num == checkNum){
                    System.out.println("Yes, it is a multiple. Multiple #" + counter);
                    yn = true;
                    break;
                }
                counter++;
            }
            if(!yn){
                System.out.println(checkNum + " is not a multiple");
            }

        }
        System.out.println();
        System.out.println("Thank you and goodbye");
    }
}
