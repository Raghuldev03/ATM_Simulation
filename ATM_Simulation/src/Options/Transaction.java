package Options;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    
    private static ArrayList<String> a = new ArrayList<>();

    public static void recordTransaction(String type, double amount, double balance) {
        try {
            String transaction = type + ": Amount " + amount + ", Remaining Balance: " + balance;
            a.add(transaction);
        } catch (Exception e) {
            System.out.println("Error recording transaction: " + e.getMessage());
        }
    }

    public static void viewHistory() {
        try {
            if (a.isEmpty()) {
                System.out.println("No transactions available.");
            } else {
                System.out.println();
                System.out.println("Transaction History:");
                for (String record : a) {
                    System.out.println(record);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving transaction history: " + e.getMessage());
        }
    }
}
