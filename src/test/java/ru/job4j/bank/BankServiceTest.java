package ru.job4j.bank;

import java.util.Optional;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankServiceTest {
    @Test
    public void addUser() {
        BankService bank = new BankService();
        Optional<User> expected = Optional.of(new User("3434", "Petr Arsentev"));
        bank.addUser(expected.get());
        Optional<User> actual = bank.findByPassport("3434");
        assertEquals(expected, actual);
    }

    @Test
    public void whenEnterInvalidPassport() {
        BankService bank = new BankService();
        User user = new User("3434", "Petr Arsentev");
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0));
        Optional<Account> expected = Optional.empty();
        Optional<Account> actual = bank.findByRequisite("34", "5546");
        assertEquals(expected, actual);
    }

    @Test
    public void addAccount() {
        BankService bank = new BankService();
        User user = new User("3434", "Petr Arsentev");
        bank.addUser(user);
        double expectedBalance = 1000.0;
        bank.addAccount(user.getPassport(), new Account("5546", expectedBalance));
        double actualBalance = bank.findByRequisite("3434", "5546").get().getBalance();
        assertEquals(expectedBalance, actualBalance, 0.01);
    }

    @Test
    public void transferMoney() {
        BankService bank = new BankService();
        User user = new User("3434", "Petr Arsentev");
        bank.addUser(user);
        bank.addAccount("3434", new Account("5546", 150));
        bank.addAccount("3434", new Account("113", 50.0));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150.0);
        double expectedMoney = 200.0;
        double actualMoney = bank.findByRequisite(user.getPassport(), "113").get().getBalance();
        assertEquals(expectedMoney, actualMoney, 0.01);
    }

    @Test
    public void notTransferMoney() {
        BankService bank = new BankService();
        User user = new User("3434", "Petr Arsentev");
        bank.addUser(user);
        bank.addAccount("3434", new Account("5546", 150));
        bank.addAccount("3434", new Account("113", 50.0));
        boolean actual = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 250.0);
        assertFalse(actual);
    }
}
