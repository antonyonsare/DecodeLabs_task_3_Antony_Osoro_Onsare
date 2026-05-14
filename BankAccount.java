/**
 * BankAccount represents a single bank account with deposit, withdrawal,
 * and balance inquiry capabilities. All data is private to enforce
 * encapsulation.
 * 
 * @author Antony Onsare
 * @version 1.0
 */
public class BankAccount {
    private double balance;
    private String accountNumber;

    /**
     * Constructor – creates a new account with an initial balance.
     * 
     * @param accountNumber  unique account identifier
     * @param initialBalance opening balance (must be >= 0)
     */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Warning: Initial balance cannot be negative. Set to 0.");
        }
    }

    // Getter for account number (read‑only)
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     * 
     * @param amount the amount to deposit (must be > 0)
     * @return true if deposit succeeded, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
    }

    /**
     * Withdraws an amount if sufficient balance exists.
     * 
     * @param amount the amount to withdraw (must be > 0 and <= balance)
     * @return true if withdrawal succeeded, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
            return false;
        }
        balance -= amount;
        return true;
    }
}