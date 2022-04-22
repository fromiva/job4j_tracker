package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных описывающую счёт пользователя банковского сервиса.
 * @author Sergei Ivanov
 * @version 1.0
 */
public class Account {
    /**
     * Содержит уникальный идентификатор счёта.
     */
    private String requisite;
    /**
     * Хранит баланс счёта.
     */
    private double balance;

    /**
     * Метод-конструктор нового счёта.
     * @param requisite Идентификатор счёта, должен быть уникальным в пределах сервиса.
     * @param balance Баланс счёта.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Get-метод для поля {@code requisite}.
     * @return Возвращает строку с идентификатором счёта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Set-метод для поля {@code requisite}.
     * @param requisite Строка с идентификатором счёта.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Get-метод для поля {@code balance}.
     * @return Возвращает баланс счёта.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set-метод для поля {@code balance}.
     * @param balance Новое знечение баланса.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Проверяет объекты класса {@code Account} на идентичность. На основе поля {@code requisite}.
     * @param o Объект класса {@code Account} для сравнения его с текущим.
     * @return Возвращает результат сравненя: {@code true} - если объекты равны, {@code false} - в остальных случаях.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Вычисляет хэш-код для текущего объекта. На основе поля {@code requisite}.
     * @return Возвращает хэш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
