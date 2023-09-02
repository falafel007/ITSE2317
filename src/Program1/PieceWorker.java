package Program1;//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    One
//
//  File Name:    PieceWorker.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     9/15/2023
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      10
//
//  Description:  PieceWorker is an employee whose pay is based on the number of pieces of merchandise produced
//
//********************************************************************

public class PieceWorker extends Employee {

    private double wage; // dollars
    private int pieces;

    // Constructor
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {

        super(firstName, lastName, socialSecurityNumber);

        // validate wage and pieces, then initialize attributes
        if (wage >= 0) this.wage = wage;
        if (pieces >= 0)  this.pieces = pieces;

    } // end constructor

    /**
     *  calculate earnings for PieceWorker object
     *
     * @return double earnings
     */
    @Override
    public double earnings(){
        return this.wage * this.pieces;
    } // end earnings method

    /**
     *
     * @return String representation of PieceWorker object
     */
    @Override
    public String toString()
    {
        return String.format("Piece Worker Employee: %s%n%s: $%,.2f; %s: %d",
                super.toString(), "Wage per Piece", this.wage, "Pieces Produced", this.pieces);
    } // end toString

}
