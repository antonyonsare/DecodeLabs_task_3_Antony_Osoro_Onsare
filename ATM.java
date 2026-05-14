import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * ATM simulates a simple automated teller machine.
 * It communicates with a BankAccount object and provides a menu‑driven
 * interface.
 * 
 * @author Antony Onsare
 * @version 1.0
 */
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    /**
     * Constructor – ties the ATM to a specific bank account.
     * 
     * @param account the bank account to manage
     */
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("          ATM MENU");
        System.out.println("=".repeat(40));
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private int getIntInput(String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                break; // valid integer received
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // clear the invalid token
            }
        }
        return value;
    }

    private double getDoubleInput(String prompt) {
        double value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return value;
    }

    private void checkBalance() {
        System.out.printf("Current balance: $%.2f\n", account.getBalance());
    }

    private void deposit() {
        double amount = getDoubleInput("Enter amount to deposit: ");
        boolean success = account.deposit(amount);
        if (success) {
            System.out.printf("Deposited $%.2f successfully. New balance: $%.2f\n",
                    amount, account.getBalance());
        } else {
            System.out.println("Deposit failed. Amount must be positive.");
        }
    }

    private void withdraw() {
        double amount = getDoubleInput("Enter amount to withdraw: ");
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.printf("Withdrew $%.2f successfully. Remaining balance: $%.2f\n",
                    amount, account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Check amount and balance.");
        }
    }
}