package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PassportOfficeTest {
    @Test
    public void addSuccessfully() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen actual = office.get(citizen.getPassport());
        assertEquals(citizen, actual);
    }

    @Test
    public void addUnsuccessfully() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen anotherCitizen = new Citizen("2f44a", "Lewis Carroll");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(anotherCitizen));
    }

}