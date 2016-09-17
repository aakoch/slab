package com.adamkoch.slab;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by aakoch on 9/11/16.
 */
public class RepositoryLoaderTest {

    private File temporaryRepositoryFile;

    @Before
    public void setUp() throws IOException {
        temporaryRepositoryFile = File.createTempFile("temporaryRepository", "slab");
        Repository repository = new InMemoryRepository();
        RepositoryLoader.save(repository, temporaryRepositoryFile);
    }

    @Test
    public void testLoadRepository() throws Exception {

        // Load the repository
        Repository repository = RepositoryLoader.load(temporaryRepositoryFile);
        assertNotNull(repository);

        Collection entities = repository.search(null);
        assertTrue("Expected empty repo", entities.isEmpty());

        UUID testUuid = UUID.randomUUID();
        Entity obj = new IdOnlyEntity(testUuid);
        repository.put(obj);

        // Save
        RepositoryLoader.save(repository, temporaryRepositoryFile);

        // Reload
        Repository reloadedRepository = RepositoryLoader.load(temporaryRepositoryFile);
        assertNotNull(repository);

        entities = reloadedRepository.search(null);
        assertFalse("Expected non-empty repo", entities.isEmpty());

        // Assert
        Entity entity = reloadedRepository.get(testUuid);
        assertNotNull("Expected repository to save entity", entity);

        reloadedRepository.delete(testUuid);
        entities = reloadedRepository.search(null);
        assertTrue("Expected empty repo", entities.isEmpty());
    }
}
