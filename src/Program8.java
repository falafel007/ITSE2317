//********************************************************************
//
//  Developer:     Christopher Felleisen
//
//  Program #:     Eight
//
//  File Name:     Program8.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      11/28/2023
//
//  Instructor:    Fred Kumi
//
//  Chapter:       21
//
//  Description:   Tests InfixToPostfixConverter
//
//********************************************************************
public class Program8 {

    public static void main(String[] args) {
        Program8 test = new Program8();
        test.developerInfo();

        InfixToPostfixConverter infix1 = new InfixToPostfixConverter(new StringBuffer("7 / 9"));
        System.out.println(infix1);

        InfixToPostfixConverter infix2 = new InfixToPostfixConverter(new StringBuffer("6 + 2 * 5"));
        System.out.println(infix2);

        InfixToPostfixConverter infix3 = new InfixToPostfixConverter(new StringBuffer("(6 + 2) * 5 - 8 / 4"));
        System.out.println(infix3);

        InfixToPostfixConverter infix4 = new InfixToPostfixConverter(new StringBuffer("(6 + 2) * 5 ^ 8 / 4"));
        System.out.println(infix4);

        InfixToPostfixConverter infix5 = new InfixToPostfixConverter(new StringBuffer("6 % 2 ^ 5 - 8 / 4 * 5"));
        System.out.println(infix5);

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
        System.out.println("Program: Eight\n\n");

    } // End of the developerInfo method
}
