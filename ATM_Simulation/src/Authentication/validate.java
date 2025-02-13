package Authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class validate {
    private Map<Long, Integer> userCredentials = new HashMap<>();
    private final int Max_attempt = 3;
    
    Scanner input = new Scanner(System.in);

    public validate() {
        userCredentials.put(8903547253L, 1234);
        userCredentials.put(9876543210L, 5678);
        userCredentials.put(8765432109L, 4321);
    }

    protected long getValidAccountNumber() {
        int count = 0;
        while (count < Max_attempt) {
            try {
                System.out.println("Enter your 10-digit Account Number:");
                long accountNumber = input.nextLong();
                if (userCredentials.containsKey(accountNumber)) {
                    System.out.println("Account number verified successfully.\n");
                    return accountNumber;
                } else {
                    count++;
                    System.out.println("Invalid Account Number. Attempts left: " + (Max_attempt - count) + " out of " + Max_attempt);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid 10-digit Account Number.");
                input.next();
                count++;
            }
        }
        System.out.println("Account locked due to multiple failed attempts.");
        return -1;
    }

    protected boolean validatePINNumber(long accountNumber) {
        int count = 0;
        while (count < Max_attempt) {
            try {
                System.out.println("Enter your 4-digit PIN Number:");
                int pinNumber = input.nextInt();
                if (userCredentials.get(accountNumber) == pinNumber) {
                    System.out.println("PIN Number verified successfully.\n");
                    return true;
                } else {
                    count++;
                    System.out.println("Invalid PIN Number. Attempts left: " + (Max_attempt - count) + " out of " + Max_attempt + "\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid 4-digit PIN Number.\n");
                input.next();
                count++;
            }
        }
        System.out.println("Account locked due to multiple failed attempts.");
        return false;
    }
}
