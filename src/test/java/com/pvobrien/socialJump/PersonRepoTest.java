package com.pvobrien.socialJump;

import com.pvobrien.socialJump.domain.Location;
import com.pvobrien.socialJump.domain.LocationRepository;
import com.pvobrien.socialJump.domain.Person;
import com.pvobrien.socialJump.domain.PersonRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;
    private LocationRepository locationRepository;

    @DisplayName("Save a user to the database.")
    @Test
    public void savePerson() {
        Location location = new Location("Washington", "jobs");
        Person person = new Person("thisPerson", 42, location);

        entityManager.persist(location);
        assertThat(location.getLocationId()).isNotNull();
        entityManager.persistAndFlush(person);
        entityManager.flush();
    }
}
