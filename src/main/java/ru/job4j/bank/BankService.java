package ru.job4j.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Класс описывает внутреннюю логику работы банковского сервиса
 * @author Sergei Ivanov
 * @version 1.0
 */
public class BankService {
    /**
     * Содержит базу пользователей с их счетами. Счетов на одного пользователя допускается несколько.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в базу.
     * @param user Объект класса {@code User} нового пользователя. Пользователь должен быть уникальным в пределах сервиса.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет новый счёт для существующего пользователя.
     * @param passport Строка с номером паспорта пользователя. По данному номеру осуществляется поиск пользователя в базе.
     * @param account Объект класса {@code Account}. Счёт должен быть уникальным в пределах сервиса.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя в базе по номеру паспорта.
     * @param passport Строка с номером паспорта пользователя.
     * @return Возвращает объект класса {@code User} пользователя или null - если пользователь не найден.
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Осуществляет поиск счёта пользователя в базе по номеру паспорта пользователя и по номеру счёта.
     * @param passport Строка с номером паспорта пользователя.
     * @param requisite Строка с номером счёта пользователя.
     * @return Возвращает объект класса {@code Account} счёта или null - если счёт не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Осуществляет перевод денег между счетами.
     * @param srcPassport Строка с номером паспорта пользователя списания.
     * @param srcRequisite Строка с номером счёта списания.
     * @param destPassport Строка с номером паспорта пользователя зачисления.
     * @param destRequisite Строка с номером счёта зачисления.
     * @param amount Принимает сумму для перевода.
     * @return Возвращает {@code true} - если перевод выполнен успешно, {@code false} - в остальных случаях.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }
}
