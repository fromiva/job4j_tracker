package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> testName = (person) -> person.getName().contains(key);
        Predicate<Person> testSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> testPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> testAddress = (person) -> person.getAddress().contains(key);

        Predicate<Person> combine = testName.or(testSurname.or(testPhone.or(testAddress)));

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
