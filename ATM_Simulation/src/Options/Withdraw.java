package Options;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Withdraw {

    private static double balance = 1000;
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
    public void Withdraw_Operation() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the amount to withdraw:");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount > balance) {
                System.out.println("Insufficient funds. Your balance is: ₹" + balance);
            } else {
                setBalance(getBalance() - amount);
                System.out.println("Transaction successful. ₹" + amount + " has been withdrawn.");
                System.out.println("Your new balance is: ₹" + getBalance());
                Transaction.recordTransaction("Withdraw", amount, balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            input.next();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}