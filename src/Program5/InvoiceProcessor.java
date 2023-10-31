package Program5;//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Five
//
//  File Name:    Program5.Program5.InvoiceProcessor.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/25/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      17
//
//  Description:  Program5.Program5.InvoiceProcessor performs various tasks on a list of invoices using .stream()
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
     Method Name: invoicesByDescription
     Parameters: none
     Return: void
     Description: (A) Sort the Program5.Program5.Invoice objects by partDescription, then display the results.
    */
    public void invoicesByDescription() {
        System.out.printf("%n(a) Invoices Sorted by Part Description:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
    }

    /*
     Method Name: invoicesByPrice
     Parameters: none
     Return: void
     Description: (B) Sort the Program5.Program5.Invoice objects by pricePerItem, then display the results.
     */
    public void invoicesByPrice() {
        System.out.printf("%n(b) Invoices Sorted by Price:%n");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
    }

    /*
     Method Name: invoicesDescriptionToQuantity
     Parameters: none
     Return: void
     Description: (C) Map each Program5.Program5.Invoice to its partDescription and quantity, sort the results by quantity, then display the results
     */

    public void invoicesDescriptionToQuantity() {
        System.out.println("\n(c) Invoices Mapped by Description to Quantity:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map(sDescriptionToQuantity)
                .forEach(System.out::println);
    }

    /*
    Function: sDescriptionToQuantity
    Parameters: Program5.Program5.Invoice
    Return: String Description and Quantity
    Description: Consumes an invoice and returns a string with a description and quantity for the invoice item
     */
    Function<Invoice, String> sDescriptionToQuantity = i ->
            String.format("Description: %-15s  Quantity: %-4d", i.getPartDescription(), i.getQuantity());

    /*
     Method Name: invoicesDescriptionToValue
     Parameters: none
     Return: void
     Description: (D) Map each Program5.Program5.Invoice to its partDescription and the value of the Program5.Program5.Invoice (i.e., quantity * pricePerItem).
                  Order the results by Program5.Program5.Invoice value. Then display the results.
    */
    public void invoicesPartDescriptionToValue() {
        System.out.println("\n(d) Invoices Mapped by Description to Value:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(calculateValue))
                .map(i -> String.format("Description: %-15s  Value: $%,9.2f", i.getPartDescription(), (i.getPrice() * i.getQuantity())))
                .forEach(System.out::println);

    }

    /*
    Function: calculateValue
    Parameters: Program5.Program5.Invoice
    Return: Double dollar value of the invoice
    Description: consumes an invoice and returns the dollar value of the invoice
    QUESTIONS: Why isn't this function a method in the Program5.Program5.Invoice Class? How can I use this in lines 124/150 to make it more readable?
     */
    Function<Invoice, Double> calculateValue = i -> i.getPrice() * i.getQuantity();

    /*
     Method Name: invoiceValuesInRange
     Parameters: none
     Return: void
     Description: (e) Modify Part (D) to select the Program5.Program5.Invoice values in the range $200.00 to $500.00. Then display the results.
    */
    public void invoiceValuesInRange() {
        System.out.println("\n(e) Program5.Program5.Invoice values in the range $200.00 to $500.00:");

        this.invoiceList.stream()
                .sorted(Comparator.comparing(calculateValue))
                .filter(isTwoToFiveHundred)
                .map(i -> String.format("Description: %-15s  Value: $%,9.2f", i.getPartDescription(), (i.getPrice() * i.getQuantity())))
                .forEach(System.out::println);
    }

    /*
    Predicate: isTwoToFiveHundred
    Parameter: invoice
    Return: Boolean
    Description: returns a boolean True if the dollar value of an invoice is between 200 and 500 inclusive.
     */
    Predicate<Invoice> isTwoToFiveHundred = i ->(i.getPrice() * i.getQuantity() >= 200 && i.getPrice() * i.getQuantity() <= 500);

    /*
     Method Name: findSaw
     Parameters: none
     Return: void
     Description: (f) Find any one Program5.Program5.Invoice in which the partDescription contains the word “Saw”. Then display the results.
    */

    public void findSaw() {
        System.out.println("\n(f) One Program5.Program5.Invoice in which the Part Description contains the word \"Saw\":");

        System.out.println(
                this.invoiceList.stream()
                        .filter(searchSaw)
                        .findFirst()
                        .get());

    }

    /*
    Predicate: searchSaw
    Parameter: invoice
    Return: Boolean
    Description: returns a boolean True if the invoice description includes "Saw"
     */
    Predicate<Invoice> searchSaw = i -> i.getPartDescription().contains("Saw");


}
