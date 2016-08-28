package com.adamkoch.slab;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Adam on 2016-08-20.
 */
public class RepositoryTest {

    Repository repo;

    @Before
    public void setUp() {
        repo = new DefaultRepository();
    }

    @Test
    public void testPut() throws Exception {
        assertEquals(0, repo.retrieveAllEntities().size());
        final UUID uuid = UUID.randomUUID();
        final Entity entity = new Entity() {
            @Override
            public UUID getId() {
                return uuid;
            }

            @Override
            public void setId(final UUID id) {

            }
        };
        repo.put(entity);
        assertEquals(0, repo.retrieveAllEntities().size());
        assertEquals(entity, repo.get(uuid));
    }

    @Test
    public void testGet() throws Exception {
        fail("Not implemented yet");
    }

    @Test
    public void testRetrieveAllEntities() throws Exception {
        fail("Not implemented yet");
    }
}