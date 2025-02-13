package Options;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Display_options {

    Scanner input = new Scanner(System.in);
    
    Withdraw withdraw = new Withdraw();
    Deposit deposit = new Deposit();
    BalanceInquiry balan = new BalanceInquiry();
    Transaction transaction = new Transaction();

    public void display() {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("Please select your choice by entering the corresponding number:");
                System.out.println();
                System.out.println("1. Withdraw Money");
                System.out.println("2. Deposit Money");
                System.out.println("3. Check Balance");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");

                System.out.println();
                System.out.println("Enter your choice:");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You selected: Withdraw Money");
                        withdraw.Withdraw_Operation();
                        break;
                    case 2:
                        System.out.println("You selected: Deposit Money");
                        deposit.Deposit_Operation();
                        break;
                    case 3:
                        System.out.println("You selected: Check Balance");
                        balan.BalanceInquiry_Operation();
                        break;
                    case 4:
                        System.out.println("You selected: View Transaction History");
                        transaction.viewHistory();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM System!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                input.next();
            }
        }
    }
}