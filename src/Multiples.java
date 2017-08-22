/**
 * Program that allows the user to enter 2 numbers that are used as a base
 * to see if there are any multiples of the numbers up to the maximum number
 * designated by the user and shows the sum of all said multiples.
 *
 * The User can also enter a potential multiple to check if there's a multiple
 * that matches the entered value.
 *
 * @author Patrick Lennon
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Multiples {
    public static void main(String[] arga) {
        boolean choice = false;
        ArrayList<Integer> multiples = new ArrayList<>();
        int sum = 0;
        int first;
        int second;
        int max;
        Scanner howMany = new Scanner(System.in);
        Scanner firstNumber = new Scanner(System.in);
        Scanner secondNumber = new Scanner(System.in);
        Scanner maximumNumber = new Scanner(System.in);


        System.out.println("Welcome! in the Multiples program, you can choose to enter 2");
        System.out.println("numbers, along with a maximum number. The program will output the sum of all the multiple of the");
        System.out.println("numbers up to that maximum number. Also, if you want you can check if there is a specific");
        System.out.println("multiple, you can enter it and the program will find it.");
        System.out.println();
        System.out.println("With all that said, let's begin!");

        System.out.print("What's the first number?:	");
        first = firstNumber.nextInt();

        System.out.print("What's the second number?:	");
        second = secondNumber.nextInt();

        System.out.print("What's the maximum number?:	");
        max = maximumNumber.nextInt();

        for(int i = 0; i < max; i++){
            if(i%first==0 && i%second==0){
                multiples.add(i);
                sum += i;
            }
            else if(i%first==0 || i%second==0){
                multiples.add(i);
                sum += i;
            }

        }

        System.out.println("");
        System.out.println("Sum of all multiples:	" + sum);
    }
}