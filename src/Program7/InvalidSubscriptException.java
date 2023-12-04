package Program7;

//********************************************************************
//
//  Developer:     Instructor
//
//  Program #:     Seven
//
//  File Name:     Program7.InvalidSubscriptException.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:       11/14/2023
//
//  Instructor:    Fred Kumi
//
//  Chapter:       20
//
//  Description:   Program7.InvalidSubscriptException extends RuntimeException to identify invalid subscript arguments
//
//********************************************************************
public class InvalidSubscriptException extends RuntimeException {

    String error_message;

    InvalidSubscriptException() {
        this.error_message = "Invalid Subscript Index.";
    }

    InvalidSubscriptException(String error_message) {
        this.error_message = error_message;
    }

    @Override
    public String toString(){
        return this.error_message;
    }
}
