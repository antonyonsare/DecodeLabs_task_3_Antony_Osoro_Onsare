/**
 * Entry point for the ATM application.
 */
public class Main {
    public static void main(String[] args) {
        // Create a bank account with account number and initial balance
        BankAccount myAccount = new BankAccount("12345-6789", 500.00);
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}