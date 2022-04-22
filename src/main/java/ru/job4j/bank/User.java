package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных описывающую пользователя банковского сервиса.
 * @author Sergei Ivanov
 * @version 1.0
 */
public class User {
    /**
     * Содержит номер паспортя пользователя.
     * Поле должно быть уникально в пределах сервиса.
     */
    private String passport;
    /**
     * Содержит имя пользователя.
     */
    private String username;

    /**
     * Метод-конструктор нового пользователя.
     * @param passport Номер паспортя пользователя, должен быть уникальным в пределах сервиса,
     * @param username Имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Get-метод для поля {@code passport}.
     * @return Возвращает строку с номером паспорта.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Set-метод для поля {@code passport}.
     * @param passport Строка с номером паспорта.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Get-метод для поля {@code username}.
     * @return Возвращает строку с именем пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set-метод для поля {@code username}.
     * @param username Строка с именем пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Проверяет объекты класса {@code User} на идентичность. На основе поля {@code passport}.
     * @param o Объект класса {@code User} для сравнения его с текущим.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Вычисляет хэш-код для текущего объекта. На основе поля {@code passport}.
     * @return Возвращает хэш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
