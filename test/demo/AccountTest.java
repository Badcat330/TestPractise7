package demo;


import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account;

    @Test
    public void getBalanceTest() {
        account = new Account();
        int balance = 100;
        account.deposit(balance);
        assertEquals(account.balance, account.getBalance());
    }

    @Test
    public void depositTest() {
        account = new Account();
        int balance = 100;
        boolean answer = account.deposit(balance);
        assertTrue(answer);
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void withdrawTest() {
        account = new Account();
        int balance = 100;
        account.deposit(balance);
        boolean answer = account.withdraw(balance / 2);
        assertTrue(answer);
        assertEquals(balance / 2, account.getBalance());
    }

    @Test
    public void getMaxCreditTest() {
        account = new Account();
        assertEquals(account.maxCredit, -account.getMaxCredit());
    }

    @Test
    public void setMaxCredit() {
        account = new Account();
        int maxCredit = 1000;
        account.block();
        boolean answer = account.setMaxCredit(maxCredit);
        assertTrue(answer);
        assertEquals(maxCredit, account.getMaxCredit());
    }

    @Test
    public void isBlockedTest() {
        account = new Account();
        assertEquals(account.blocked, account.isBlocked());
    }

    @Test
    public void block() {
        account = new Account();
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void unblockSuccess() {
        account = new Account();
        account.block();
        boolean answer = account.unblock();
        assertTrue(answer);
        assertFalse(account.isBlocked());
    }

    @Test
    public void unblockUnSuccess() {
        account = new Account();
        account.block();
        account.balance = -(account.getMaxCredit() + 100);
        boolean answer = account.unblock();
        assertFalse(answer);
        assertTrue(account.isBlocked());
    }

    @Test
    public void unblockEqSuccess() {
        account = new Account();
        account.block();
        account.balance = -(account.getMaxCredit());
        boolean answer = account.unblock();
        assertTrue(answer);
        assertFalse(account.isBlocked());
    }

    @Test
    public void bigWithdrawTest() {
        account = new Account();
        int balance = 100;
        account.deposit(balance);
        boolean answer = account.withdraw(balance + account.getMaxCredit() + 100);
        assertFalse(answer);
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void unblockSetMaxCreditTest() {
        account = new Account();
        int maxCredit = account.getMaxCredit();
        boolean answer = account.setMaxCredit(100);
        assertFalse(answer);
        assertEquals(maxCredit, account.getMaxCredit());
    }

    @Test
    public void moreBoundSetMaxCreditTest() {
        account = new Account();
        account.block();
        boolean answer = account.setMaxCredit(1000000);
        assertFalse(answer);
    }

    @Test
    public void lessBoundSetMaxCreditTest() {
        account = new Account();
        account.block();
        boolean answer = account.setMaxCredit(-1000000);
        assertFalse(answer);
    }

    @Test
    public void negativeWithdrawTest() {
        account = new Account();
        int balance = account.balance;
        assertFalse(account.withdraw(-100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void negativeDepositTest() {
        account = new Account();
        int balance = account.balance;
        assertFalse(account.deposit(-100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void zeroDepositTest() {
        account = new Account();
        int balance = account.balance;
        assertTrue(account.deposit(0));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void boundDepositTest() {
        account = new Account();
        int balance = account.balance;
        assertFalse(account.deposit(account.bound + 100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void boundEqDepositTest() {
        account = new Account();
        assertTrue(account.deposit(account.bound));
    }

    @Test
    public void boundWithdrawTest() {
        account = new Account();
        int balance = account.balance;
        assertFalse(account.withdraw(account.bound + 100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void zeroWithdrawTest() {
        account = new Account();
        int balance = account.balance;
        assertTrue(account.withdraw(0));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void eqBoundWithdrawTest() {
        account = new Account();
        account.balance += account.bound;
        assertTrue(account.withdraw(account.bound));
    }

    @Test
    public void eqMaxCreditWithdrawTest() {
        account = new Account();
        assertFalse(account.withdraw(account.getMaxCredit()));
    }

    @Test
    public void overBoundDepositTest() {
        account = new Account();
        int balance = account.bound - 50;
        account.balance = account.bound - 50;
        assertFalse(account.deposit(100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void overBoundEqDepositTest() {
        account = new Account();
        account.balance = account.bound - 50;
        assertTrue(account.deposit(50));
    }

    @Test
    public void overBoundWithdrawTest() {
        account = new Account();
        int balance = -(account.bound - 50);
        account.balance = -(account.bound - 50);
        assertFalse(account.withdraw(100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void EqBoundWithdrawTest() {
        account = new Account();
        int balance = -(account.bound - 50);
        account.balance = -(account.bound - 50);
        assertFalse(account.withdraw(50));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void blockDepositTest() {
        account = new Account();
        int balance = account.balance;
        account.block();
        assertFalse(account.deposit(100));
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void blockWithdrawTest() {
        account = new Account();
        int balance = account.balance;
        account.block();
        assertFalse(account.withdraw(100));
        assertEquals(balance, account.getBalance());
    }
}