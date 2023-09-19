import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            duplicateCounterTest(input);
            System.out.println();
            System.out.println();
        }
    }

    public static void duplicateCounterTest(Scanner input) {
        System.out.print("Count the duplicates in this sentence (type no to exit): ");
        DuplicateCounter test = new DuplicateCounter(input);

        if (test.getSentence().equalsIgnoreCase("no")) {
            System.exit(0);
        }

        test.displayDuplicates();
    }

}
