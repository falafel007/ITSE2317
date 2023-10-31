package Program5;//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Five
//
//  File Name:    Program5.Program5.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/25/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      17
//
//  Description:  Program5.Program5.Invoice
//
//********************************************************************

public class Program5 {

    public static void main(String[] args) {
        Program5 test = new Program5();
        test.developerInfo();

        // Creates an Program5.Program5.InvoiceProcessor object using the Program5.Program5.Invoice-Data.txt file
        InvoiceProcessor invoiceList = new InvoiceProcessor("Program5.Program5.Invoice-Data.txt");
        // displays invoices sorted by description (ascending)
        invoiceList.invoicesByDescription();
        // displays invoices sorted by price (ascending)
        invoiceList.invoicesByPrice();
        // displays invoice descriptions and quantities, sorted by quantity (ascending)
        invoiceList.invoicesDescriptionToQuantity();
        // displays invoices descriptions and values, sorted by value (ascending)
        invoiceList.invoicesPartDescriptionToValue();
        // displays invoices descriptions and values between $200 and $500, inclusive, sorted by value (ascending)
        invoiceList.invoiceValuesInRange();
        // displays one invoice with a description containing the String "Saw"
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
