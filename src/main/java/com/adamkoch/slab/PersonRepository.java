package com.adamkoch.slab;

import java.util.List;
import java.util.UUID;

/**
 * Created by aakoch on 8/29/16.
 */
public class PersonRepository implements Repository<Person> {

    private Repository<Person> repository;

    public PersonRepository(Repository<Person> repository) {
        this.repository = repository;
    }

    @Override
    public void put(Person entity) {
        repository.put(entity);
    }

    @Override
    public Person get(UUID uuid) {
        return repository.get(uuid);
    }

    @Override
    public List<Person> retrieveAllEntities() {
        return repository.retrieveAllEntities();
    }

    @Override
    public void delete(UUID uuid) {
        repository.delete(uuid);
    }
}
