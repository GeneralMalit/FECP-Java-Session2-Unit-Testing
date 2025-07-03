package org.example;

public class BankAccount {
    private final int accountNumber;
    private final String bankHolderName;
    private double availableBalance;

    public BankAccount(int accountNumber, String bankHolderName, double availableBalance) {
        this.accountNumber = accountNumber;
        this.bankHolderName = bankHolderName;
        this.availableBalance = availableBalance;
    }

    public BankAccount(int accountNumber, String bankHolderName) {
        this.accountNumber = accountNumber;
        this.bankHolderName = bankHolderName;
        this.availableBalance = 0;
    }

    public void deposit(double amountDeposited) {
        if (amountDeposited > 0) {
            this.availableBalance = availableBalance + amountDeposited;
            System.out.printf("Deposited %.2f. New balance: %.2f%n", amountDeposited, this.availableBalance);
        }
    }

    public void withdraw(double amountWithdrawn) {
        if(amountWithdrawn > 0 && amountWithdrawn > availableBalance) {
            this.availableBalance = availableBalance - amountWithdrawn;
            System.out.printf("Withdrawn %.2f. New balance: %.2f%n", amountWithdrawn, this.availableBalance);
        }
    }

    public void displayInformation() {
        System.out.printf("Account Number: %d\nName: %s\nBalance: %.2f", accountNumber, bankHolderName, availableBalance);
    }

    public void displayBalance() {
        System.out.printf("Balance: %.2f", availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getBankHolderName() {
        return bankHolderName;
    }
}

