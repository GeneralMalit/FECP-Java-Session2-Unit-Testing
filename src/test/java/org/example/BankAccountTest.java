package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private final double DELTA = 0.001; //use standard value for delta

    @BeforeEach
    void setUp() {
        account = new BankAccount(59595, "max verstappen", 100.0);
    }

    @Test
    void testAccountCreationWithInitialDeposit() {
        BankAccount newAccount = new BankAccount(14070756, "Charles Leclerc", 500.0);
        assertEquals(14070756, newAccount.getAccountNumber());
        assertEquals("Charles Leclerc", newAccount.getBankHolderName());
        assertEquals(500.0, newAccount.getAvailableBalance(), DELTA);
    }

    @Test
    void testAccountCreationWithoutInitialDeposit() {
        BankAccount newAccount = new BankAccount(11111, "Lewis Hamilton");
        assertEquals(11111, newAccount.getAccountNumber());
        assertEquals("Lewis Hamilton", newAccount.getBankHolderName());
        assertEquals(0.0, newAccount.getAvailableBalance(), DELTA);
    }

    @Test
    void depositValidAmount() {
        account.deposit(50.0);
        assertEquals(150.0, account.getAvailableBalance(), DELTA);
    }

    @Test
    void depositZeroAmount() {
        double initialBalance = account.getAvailableBalance();
        account.deposit(0.0);
        assertEquals(initialBalance, account.getAvailableBalance(), DELTA);
    }

    @Test
    void depositNegativeAmount() {
        double initialBalance = account.getAvailableBalance();
        account.deposit(-25.0);
        assertEquals(initialBalance, account.getAvailableBalance(), DELTA);
    }

    @Test
    void withdrawValidAmount() {
        account.withdraw(50.0);
        assertEquals(50.0, account.getAvailableBalance(), DELTA);
    }

    @Test
    void withdrawZeroAmount() {
        double initialBalance = account.getAvailableBalance();
        account.withdraw(0.0);
        assertEquals(initialBalance, account.getAvailableBalance(), DELTA);
    }

    @Test
    void withdrawNegativeAmount() {
        double initialBalance = account.getAvailableBalance();
        account.withdraw(-10.0);
        assertEquals(initialBalance, account.getAvailableBalance(), DELTA);
    }

    @Test
    void withdrawAmountExceedsBalance() {
        double initialBalance = account.getAvailableBalance();
        account.withdraw(150.0); // Attempt to withdraw more than available
        assertEquals(initialBalance, account.getAvailableBalance(), DELTA);
    }

    @Test
    void getAccountNumber() {
        assertEquals(59595, account.getAccountNumber());
    }

    @Test
    void getBankHolderName() {
        assertEquals("max verstappen", account.getBankHolderName());
    }


    @Test
    void displayInformation() {
        account.displayInformation();
        assertTrue(true);
    }

    @Test
    void displayBalance() {
        account.displayBalance();
        assertTrue(true);
    }
}