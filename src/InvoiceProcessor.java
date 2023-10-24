//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Five
//
//  File Name:    InvoiceProcessor.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/25/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      17
//
//  Description:  InvoiceProcessor performs various tasks on a list of invoices using .stream()
//
//********************************************************************

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class InvoiceProcessor {

    List<Invoice> invoiceList;

    InvoiceProcessor(List invoiceList) {
        this.invoiceList = invoiceList;
    }

    InvoiceProcessor(String filename) {
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

        this.invoiceList = invoiceList;
    }

     /*
     (A) Sort the Invoice objects by partDescription, then display the results.
    */
    public void invoicesByDescription() {
        System.out.printf("%n(a) Invoices Sorted by Part Description:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
    }

    /*
    (B) Sort the Invoice objects by pricePerItem, then display the results.
     */
    public void invoicesByPrice() {
        System.out.printf("%n(b) Invoices Sorted by Price:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
    }

    /*
     (C) Map each Invoice to its partDescription and quantity, sort the results by quantity, then display the results
     */

    public void invoicesDescriptiontoQuantity() {
        System.out.println("\n(c) Invoices Mapped by Description to Quantity:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map(i -> String.format("Description: %-15s  Quantity: %-4d", i.getPartDescription(), i.getQuantity()))
                .forEach(System.out::println);
    }

    /*
    How can I properly use this function in invoicesDescriptionToQuantity?
     */
    Function<Invoice, String> sDescriptionToQuantity = i ->
            String.format("Description: %-15s  Quantity: %-4d", i.getPartDescription(), i.getQuantity());

    /*
    (D) Map each Invoice to its partDescription and the value of the Invoice (i.e., quantity * pricePerItem).
    Order the results by Invoice value. Then display the results.
    */
    public void invoicesPartDescriptionToValue() {
        System.out.println("\n(d) Invoices Mapped by Description to Value:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(calculateValue))
                .map(i -> String.format("Description: %-15s  Value: $%,9.2f", i.getPartDescription(), (i.getPrice() * i.getQuantity())))
                .forEach(System.out::println);

    }

    Function<Invoice, Double> calculateValue = i -> i.getPrice() * i.getQuantity();

    /*
    (e) Modify Part (D) to select the Invoice values in the range $200.00 to $500.00. Then display the results.
    */
    public void invoiceValuesInRange() {
        System.out.println("\n(e) Invoice values in the range $200.00 to $500.00:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(calculateValue))
                .filter(twoToFiveHundred)
                .map(i -> String.format("Description: %-15s  Value: $%,9.2f", i.getPartDescription(), (i.getPrice() * i.getQuantity())))
                .forEach(System.out::println);
    }

    Predicate<Invoice> twoToFiveHundred = i ->(i.getPrice() * i.getQuantity() >= 200 && i.getPrice() * i.getQuantity() <= 500);
    /*
    (f) Find any one Invoice in which the partDescription contains the word “Saw”. Then display the results.
    */

    public void findSaw() {
        System.out.println("\n(f) One Invoice in which the Part Description contains the word \"Saw\":");

        System.out.println(
                this.invoiceList.stream()
                        .filter(searchSaw)
                        .findFirst()
                        .get());

    }

    Predicate<Invoice> searchSaw = i -> i.getPartDescription().contains("Saw");


}
