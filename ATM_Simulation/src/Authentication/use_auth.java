package Authentication;

import Options.*;
import java.util.InputMismatchException;

public class use_auth {
    public static void main(String[] args) {
        try {
            System.out.println("Hi, welcome to the ATM System! Please follow the instructions.");
            System.out.println();

            validate obj = new validate();

            long accountNumber = obj.getValidAccountNumber();  
            
            if (accountNumber != -1) { 
                if (obj.validatePINNumber(accountNumber)) { 
                    System.out.println("Authentication successful! Welcome to your account.");
                    System.out.println();                   
                    Display_options obj2 = new Display_options();
                    obj2.display();
                } else {
                    System.out.println("Authentication failed! Unable to verify PIN.");
                }
            } else {
                System.out.println("Authentication failed! Unable to verify account number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

