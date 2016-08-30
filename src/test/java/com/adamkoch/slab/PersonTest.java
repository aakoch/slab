package com.adamkoch.slab;

import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aakoch on 8/29/16.
 */
public class PersonTest {
    private PersonRepository personRepository;
    private UUID adamUuid = UUID.randomUUID();
    private Person christi;

    @Before
    public void setUp() throws Exception {
        christi = new Person(UUID.randomUUID());
        personRepository = initializeRepoWithAdam();
    }

    private PersonRepository initializeRepoWithAdam() {
        Repository<Person> inMemoryRepo = new InMemoryRepository();
        PersonRepository personRepository = new PersonRepository(inMemoryRepo);
        Person adam = new Person(adamUuid);
        Collection<Relationship> adamRelationships = Arrays.asList(buildRelationship(adam, christi));
        adam.setRelationships(adamRelationships);
        personRepository.put(adam);
        return personRepository;
    }

    private Relationship<Person> buildRelationship(Person adam, Person christi) {
        return new Relationship.Builder<>().from(adam).to(christi).build();
    }

    @Test
    public void testListAllRelationships() {
        Person adam = personRepository.get(adamUuid);
        Collection<Relationship> relationships = adam.getAllRelationships();
        assertThat(relationships.size()).isGreaterThan(0);
        assertThat(relationships).containsOnly(buildRelationship(adam, christi));
    }
}
