//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Five
//
//  File Name:    Program5.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/25/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      17
//
//  Description:  Invoice
//
//********************************************************************

public class Program5 {

    public static void main(String[] args) {
        Program5 test = new Program5();
        test.developerInfo();

        Invoice[] invoices = {
                new Invoice(83,"Electric Sander",7,57.98),
                new Invoice(24,"Power Saw",18,99.99),
                new Invoice(7,"Sledge Hammer",11,21.50),
                new Invoice(77,"Hammer",76,11.99),
                new Invoice(39,"Lawn Mower",3,79.50),
                new Invoice(68,"Screwdriver",106,6.99),
                new Invoice(56,"Jig Saw",21,11.00),
                new Invoice(3,"Wrench",34,7.50)
        };

        // InvoiceProcessor invoiceList = new InvoiceProcessor(Arrays.asList(invoices));

        InvoiceProcessor invoiceList = new InvoiceProcessor("Invoice-Data.txt");

        invoiceList.invoiceByDescription();
        invoiceList.invoiceByPrice();
        invoiceList.invoicesDescriptiontoQuantity();
        invoiceList.findSaw();


    }

    //***************************************************************
    //
    //  Method:       developerInfo (Non Static)
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void developerInfo()
    {
        System.out.println("Name:    Christopher Felleisen");
        System.out.println("Course:  ITSE 2317 Intermediate Java Programming");
        System.out.println("Program: Five\n\n");

    } // End of the developerInfo method
}
