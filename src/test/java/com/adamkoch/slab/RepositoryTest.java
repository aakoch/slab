package com.adamkoch.slab;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Adam on 2016-08-20.
 */
public class RepositoryTest {

    Repository repo;

    @Before
    public void setUp() {
    }

    @Test
    public void testPut() throws Exception {
        repo = new InMemoryRepository();
        assertEquals(0, repo.retrieveAllEntities().size());
        final UUID uuid = UUID.randomUUID();
        final Entity entity = new IdOnlyEntity(uuid);

        repo.put(entity);
        assertEquals(1, repo.retrieveAllEntities().size());
        assertEquals(entity, repo.get(uuid));
    }

    @Test
    public void testGet() throws Exception {
        repo = new InMemoryRepository();
        assertEquals(0, repo.retrieveAllEntities().size());

        final UUID uuid = UUID.randomUUID();
        assertNull("There shouldn't be any entry yet as the repr hasn't been populated", repo.get(uuid));

        final Entity entity = new IdOnlyEntity(uuid);

        repo.put(entity);

        assertEquals(1, repo.retrieveAllEntities().size());
        assertEquals(entity, repo.get(uuid));
    }

    @Test
    public void testRetrieveAllEntities() throws Exception {
        repo = new InMemoryRepository();
        assertEquals(0, repo.retrieveAllEntities().size());

        // Java's closest to Ruby's 3.times ...
        IntStream.rangeClosed(1, 3)
                .forEach(unused -> repo.put(new DummyEntity()));

        assertEquals(3, repo.retrieveAllEntities().size());
    }

}