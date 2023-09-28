package Program3;

import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {

        Program3 obj = new Program3();

        obj.duplicateCounterTest();

    } // end main

    public void duplicateCounterTest() {

        try (Scanner input = new Scanner(System.in)) {

            final String prompt = "\nCount the duplicates in this sentence (type no to exit): ";

            System.out.print(prompt);
            String sentence = input.nextLine().strip();

            while (!sentence.equalsIgnoreCase("no")) {
                DuplicateCounter test = new DuplicateCounter(sentence);
                test.displayDuplicates();

                // continue prompt
                System.out.print(prompt);
                sentence = input.nextLine();
            } // end loop

            System.out.println("Goodbye.");
        }

        catch (Exception e) {
            e.printStackTrace();
        } // end exception handling

    } // end DuplicateCounterTest

} // end Program3
