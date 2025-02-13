package Options;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Deposit extends Withdraw {

    public void Deposit_Operation() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the amount to deposit:");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else {
                setBalance(getBalance() + amount);
                System.out.println("Transaction successful. ₹" + amount + " has been deposited.");
                System.out.println("Your new balance is: ₹" + getBalance());
                Transaction.recordTransaction("Deposit", amount, getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            input.next();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}