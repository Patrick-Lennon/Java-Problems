import java.io.*;
import java.util.Scanner;

/**
 Since you want to get as many people to run as possible, how many Rally employees (who are all runners, of course) do
 you need to add to the race in order to make sure that everyone who will consider running does so? (You can assume you
 have as many Rallyers as you need.)

 Your program’s input will be pairs of positive integers, the first of which is the number of other runners that group
 will need to see running in order to run themselves, and the second of which is the number of runners who share that
 “run number.”  Read pairs, one per line, until end of file is found, which signals the end of your input.

 Example:

 In:
 2 1 (“one person will need to see two runners before running”)
 3 1 (“one person will need to see three runners before running”)
 6 3 (“three people will need to see six runners before running”)
 7 6 (“six people will need to see seven runners before running”)

 Out: 4

 In:
 0 1 (“one person will run no matter what”)
 1 1 (“one person will need to see one runner before running”)
 2 1 (“one person will need to see two runners before running”)
 3 1 (“one person will need to see three runners before running”)
 4 1 (“one person will need to see four runners before running”)

 Out: 0

 * @author Patrick Lennon
 * @version 1/10/2018
 */

public class Rally {

    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter filename (or path):  ");
            String fileName = scan.nextLine();
            //String fileName = "pairs.txt"; //for testing, in final have user add file name
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            int numRunners = 0; //number of rally runners
            int totalRunners = 0; //total runners
            int difference = 0; //number of rally runners added each pair

            while(line != null){ //loop through the pairs

                String[] nums = line.split(" "); //split up the pairs into their respective numbers
                int runners = Integer.parseInt(nums[0]); //number of runners needed
                int people = Integer.parseInt(nums[1]);  // number of people who will run

                System.out.println();
                System.out.println("Runners needed: " + runners);
                System.out.println("People: " + people);
                System.out.println("Rally runners:  " + numRunners);
                System.out.println("Current number of runners:  " + totalRunners);


                if(runners < people){ //when people don't need to see anyone or we have enough
                    totalRunners += people;
                }

                else if(runners >= people){ //when we need runners
                    if(totalRunners >= runners){ //if we have enough runners
                        totalRunners += people;
                    }
                    else{ //make up the difference with Rally employees
                        difference = runners - totalRunners;
                        numRunners += difference;
                        totalRunners += numRunners;

                    }
                }

                System.out.println("Rally runners added:    " + difference);
                System.out.println("Total number of runners:    " + totalRunners);
                difference = 0; //reset the number of Rally employees added

                line = br.readLine(); //goes onto the next line

            }
            System.out.println("==================================================");
            System.out.println("Total Rally Employees Added:  " + numRunners);
        }
        catch(FileNotFoundException e){
            System.out.println("File wasn't found.");
        }
        catch(IOException e){
            System.out.println("First line was null");
        }

    }
}
