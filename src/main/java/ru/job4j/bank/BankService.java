package ru.job4j.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Осуществляет поиск счёта пользователя в базе по номеру паспорта пользователя и по номеру счёта.
     * @param passport Строка с номером паспорта пользователя.
     * @param requisite Строка с номером счёта пользователя.
     * @return Возвращает объект класса {@code Account} счёта или null - если счёт не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> result = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            result = users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            result = true;
        }
        return result;
    }
}
