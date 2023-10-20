import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class InvoiceProcessor {

    List<Invoice> invoiceList;

    InvoiceProcessor(List invoiceList) {
        this.invoiceList = invoiceList;
    }

    public static InvoiceProcessor invoiceProcessorFactory(String filename) {
        List<Invoice> invoiceList = new ArrayList<>();

        try(Scanner input = new Scanner(Paths.get(filename))) {

            while(input.hasNext()) {
                String[] invoiceData = input.nextLine().split(",");

                invoiceList.add(new Invoice(
                        parseInt(invoiceData[0]),
                        invoiceData[1],
                        parseInt(invoiceData[2]),
                        parseDouble(invoiceData[3])));

            }
        }

        catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

        return new InvoiceProcessor(invoiceList);
    }

     /*
        Sort the Invoice objects by partDescription, then display the results.
    */
    public void invoiceByDescription() {
        System.out.printf("%nInvoices Sorted by Part Description:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
    }

    /*
    Sort the Invoice objects by pricePerItem, then display the results.
     */
    public void invoiceByPrice() {
        System.out.printf("%nInvoices Sorted by Price:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
    }
    /*
     Map each Invoice to its partDescription and quantity, sort the results by quantity, then display the results
     */

    public void invoiceDescriptiontoQuantity() {
        System.out.println("Invoices Mapped by Description to Quantity:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map(invoice -> invoice.getPartDescription(), invoiceList.stream()
                        .map(invoice -> invoice.getQuantity())
                .forEach(System.out::println);
    }

    /*
    Map each Invoice to its partDescription and the value of the Invoice (i.e., quantity * pricePerItem).
    Order the results by Invoice value.
    */


    /*
    Modify Part (d) to select the Invoice values in the range $200.00 to $500.00.
    */

    /*
    Find any one Invoice in which the partDescription contains the word “Saw”.
    */

    Predicate<Invoice> twoToFiveHundred = i ->(i.getPrice() >= 200 && i.getPrice() <=500);


}
