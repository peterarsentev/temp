package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectClassA() {
        List<Profile> students = List.of(
                new Profile(new Address("Ulan", "Gagarina", 45, 3)),
                new Profile (new Address("Moscow", "Lenina", 5, 1))
        );
        Profiles profiles = new Profiles();
        List<Address> stAddress = profiles.collect(students);
        assertThat(stAddress.get(1).getStreet(), is("Lenina"));
    }

    @Test
    public void whenSortDublicat() {
    List<Profile> students = List.of(
            new Profile(new Address("Ulan", "Gagarina", 45, 3)),
            new Profile (new Address("Moscow", "Lenina", 5, 1)),
            new Profile (new Address("Moscow", "Lenina", 5, 1))
    );
    Profiles profiles = new Profiles();
    List<Address> stAddress = profiles.collect(students);
    assertThat(stAddress.size(), is(2));
}

    @Test
    public void whenSortCollect() {
        List<Profile> students = List.of(
                new Profile(new Address("Ulan", "Gagarina", 45, 3)),
                new Profile (new Address("Moscow", "Lenina", 5, 1)),
                new Profile (new Address("Moscow", "Lenina", 5, 1))
        );
        Profiles profiles = new Profiles();
        List<Address> stAddress = profiles.collect(students);
        assertThat(stAddress.get(0).getCity(), is("Moscow"));
    }


}