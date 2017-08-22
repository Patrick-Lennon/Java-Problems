/**
 * Program that allows the user to enter 1 or 2 numbers that are used as a base
 * to see if there are any multiples of the number(s) up to the maximum number
 * designated by the user.
 *
 * The User can also enter a potential multiple to check if there's a multiple
 * that matches the entered value.
 *
 * @author Patrick Lennon
 * @version 08/22/17
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Multiples {

    public static void main(String[] args) {
        boolean choice = false;
        ArrayList<Integer> nums = new ArrayList<>(); //ArrayList of the multiples
        int sum = 0;
        int counter = 0;

        Scanner num1 = new Scanner(System.in);
        System.out.print("Please choose the first number:   ");
        int first = num1.nextInt(); //The first number
        System.out.print("Please choose the second number:  ");
        Scanner num2 = new Scanner(System.in);
        int second = num2.nextInt(); //the second number
        Scanner num3 = new Scanner(System.in);
        System.out.print("Please enter the maximum number:  ");
        int max = num3.nextInt(); //the max number

        Scanner decision = new Scanner(System.in);
        System.out.print("Do you want to see every multiple? (Y/N):     ");
        String dec = decision.next();
        if(dec.equals("Y")){
            choice = true;
            System.out.println();
        }

        for(int i = 0; i < max; i++){ //gets the multiple
            if(i%first==0 || i%second==0){
                if(choice){
                    counter += 1;
                    if(counter == 15){
                        System.out.println();
                        counter = 0;
                    }
                    System.out.print(i + ", ");
                }
                nums.add(i); //adds the multiple to the arraylist
            }
        }

        for(int j: nums){
            sum += j; //adds each multiple to the sum
        }

        if(choice){
            System.out.println();
        }
        System.out.println();
        System.out.println("Sum of all multiples:  " + sum);
    }
}