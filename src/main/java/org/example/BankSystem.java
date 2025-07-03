package org.example;
import java.util.*;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> bankAccounts = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    createAccount(scanner, bankAccounts);
                    break;
                case "2":
                    viewAllAccounts(bankAccounts);
                    break;
                case "3":
                    checkBalance(scanner, bankAccounts);
                    break;
                case "4":
                    deposit(scanner, bankAccounts);
                    break;
                case "5":
                    withdraw(scanner, bankAccounts);
                    break;
                case "6":
                    System.out.println("Thank you for banking with us, please come again.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }


    private static void createAccount(Scanner scanner, List<BankAccount> bankAccounts) {
        System.out.print("Please enter the account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the account holder name: ");
        String bankHolderName = scanner.nextLine();

        double initialDepositAmount = 0.0;

        System.out.print("Would you like to make an initial deposit? (1) YES, (2) NO: ");
        int wantsToMakeInitialDeposit = scanner.nextInt();
        scanner.nextLine();

        if (wantsToMakeInitialDeposit == 1) {
            do {
                System.out.print("Please enter the initial deposit amount: ");
                initialDepositAmount = scanner.nextDouble();
                scanner.nextLine();

                if (initialDepositAmount < 0) {
                    System.out.println("Error: Initial deposit cannot be negative. Please enter a non-negative amount.");
                }
            } while (initialDepositAmount < 0);

            bankAccounts.add(new BankAccount(accountNumber, bankHolderName, initialDepositAmount));
        } else if (wantsToMakeInitialDeposit != 2) {
            System.out.println("Proceeding with no initial deposit (balance 0.0).");
            bankAccounts.add(new BankAccount(accountNumber, bankHolderName));
        } else { // wantsToMakeInitialDeposit == 2
            bankAccounts.add(new BankAccount(accountNumber, bankHolderName));
        }
        System.out.println("Account creation logic completed.");
    }

    private static void viewAllAccounts(List<BankAccount> bankAccounts) {
        if (bankAccounts.isEmpty()) {
            System.out.println("No accounts registered yet.");
            return;
        }
        for (BankAccount bank : bankAccounts) {
            bank.displayInformation();
        }
    }

    private static void checkBalance(Scanner scanner, List<BankAccount> bankAccounts) {
        System.out.print("Please enter the account number: ");
        int acn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the account holder name: ");
        String bhn = scanner.nextLine();
        boolean accountFound = false;

        for (BankAccount bank : bankAccounts) {
            int compare1 = bank.getAccountNumber();
            String compare2 = bank.getBankHolderName();

            if (compare1 == acn && compare2.equals(bhn)) {
                accountFound = true;
                bank.displayBalance();
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found or details mismatch. Please check account number and name.");
        }
    }

    private static void deposit(Scanner scanner, List<BankAccount> bankAccounts) {
        System.out.print("Please enter the account number: ");
        int depAcn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the account holder name: ");
        String depBhn = scanner.nextLine();

        double depositAmount;
        boolean accountFoundAndDeposited = false;

        do {
            System.out.print("Please enter the deposit amount: ");
            depositAmount = scanner.nextDouble();
            scanner.nextLine();

            if (depositAmount <= 0) {
                System.out.println("Error: Deposit amount must be positive. Please enter a valid amount.");
            }
        } while (depositAmount <= 0);

        for (BankAccount bank : bankAccounts) {
            int compare1 = bank.getAccountNumber();
            String compare2 = bank.getBankHolderName();

            if (compare1 == depAcn && compare2.equals(depBhn)) {
                bank.deposit(depositAmount);
                accountFoundAndDeposited = true;
                break;
            }
        }

        if (!accountFoundAndDeposited) {
            System.out.println("Account not found or details mismatch. Please check account number and name.");
        }
    }

    private static void withdraw(Scanner scanner, List<BankAccount> bankAccounts) {
        System.out.print("Please enter the account number: ");
        int witAcn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the account holder name: ");
        String witBhn = scanner.nextLine();

        double withdrawAmount;
        boolean accountFoundAndWithdrawn = false;

        do {
            System.out.print("Please enter the withdrawal amount: ");
            withdrawAmount = scanner.nextDouble();
            scanner.nextLine();

            if (withdrawAmount <= 0) {
                System.out.println("Error: Withdrawal amount must be positive. Please enter a valid amount.");
            }
        } while (withdrawAmount <= 0);

        for (BankAccount bank : bankAccounts) {
            int compare1 = bank.getAccountNumber();
            String compare2 = bank.getBankHolderName();

            if (compare1 == witAcn && compare2.equals(witBhn)) {
                bank.withdraw(withdrawAmount);
                accountFoundAndWithdrawn = true;
                break;
            }
        }

        if (!accountFoundAndWithdrawn) {
            System.out.println("Account not found or details mismatch. Please check account number and name.");
        }
    }


}