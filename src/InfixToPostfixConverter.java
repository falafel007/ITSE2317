import java.util.Map;

//********************************************************************
//
//  Developer:     Christopher Felleisen
//
//  Program #:     Eight
//
//  File Name:     InfixToPostfixConverter.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      11/28/2023
//
//  Instructor:    Fred Kumi
//
//  Chapter:       21
//
//  Description:   The program should read the expression into StringBuffer infix and use the stack class implemented
//  in this chapter to help create the postfix expression in StringBuffer postfix.
//
//********************************************************************
public class InfixToPostfixConverter {

    private final Map<String, Integer> operator_map = Map.of(
            "+", 0,
            "-", 0,
            "*", 1,
            "/", 1,
            "%", 1,
            "^", 2);
    private final StringBuffer infix;
    private final StringBuffer postfix;

    Stack<String> operator_stack = new Stack<>();

    InfixToPostfixConverter(StringBuffer infix) {
        this.infix = infix;
        this.postfix = convertToPostfix();
    }

    /*
    Method: convertToPostfix
    Parameters: none
    Return: StringBuffer postfix
    Description: converts the infix expression to postfix notation
     */
    private StringBuffer convertToPostfix() {

        this.infix.append(")");

        // initialize postfix string buffer
        StringBuffer postfix = new StringBuffer();

        this.operator_stack.push("(");

        int i = 0;
        while(!this.operator_stack.isEmpty()) {

            String current_character = String.valueOf(this.infix.charAt(i));

            if (current_character.equals(" ")); //for formatting

            // if the current char is a left parenthesis, push it to the stack
            else if (current_character.equals("(")) {
                operator_stack.push(current_character);
            }

            else if (current_character.equals(")")) {
                // pop operators from top of stack and append them until left parenthesis is reached
                while (!this.operator_stack.peek().equals("(")) {
                    postfix.append(this.operator_stack.pop());
                    postfix.append(" ");
                }
                // pop left parenthesis
                this.operator_stack.pop();
            }

            else if (this.isOperator(current_character)) {
                // pop operators that have equal or higher precedence append to postfix
                while (precedence(current_character, this.operator_stack.peek())) {
                    postfix.append(this.operator_stack.pop());
                    postfix.append(" ");
                }
                // push current operator to stack
                operator_stack.push(current_character);
            }

            // if current infix char is a digit, append to postfix
            else {
                postfix.append(current_character);
                postfix.append(" ");
            }

            // advance to next current_character
            i++;
        }

        // format postfix and infix
        this.infix.deleteCharAt(this.infix.length()-1);
        postfix.deleteCharAt(postfix.length()-1);

        return postfix;
    }

    /*
    Method: isOperator
    Parameters: String c
    Return: boolean
    Description: determines whether String c is an operator
     */
    private boolean isOperator(String c) {
        return this.operator_map.containsKey(c);
    }

    /*
    Method: precedence
    Parameters: String o1 String o2
    Return: boolean
    Description: Determines whether the precedence of operator1 is less than, equal to or greater than that of operator2
    The method returns true if operator1 has lower or equal precedence than operator2. Otherwise, false is returned.
    */
    private Boolean precedence(String o1, String o2) {
        if (o2.equals("(")) return false;
        else return this.operator_map.get(o1) <= this.operator_map.get(o2);
    }

    @Override
    public String toString() {
        return String.format("Infix: %s%nPostfix: %s%n", this.infix, this.postfix);
    }

}