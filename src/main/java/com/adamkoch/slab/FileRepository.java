package com.adamkoch.slab;

import javax.jnlp.PersistenceService;
import java.util.List;
import java.util.UUID;

/**
 * Created by aakoch on 8/29/16.
 */
public class FileRepository implements PersistentRepository<Entity> {
    @Override
    public void put(Entity entity) {

    }

    @Override
    public Entity get(UUID uuid) {
        return null;
    }

    @Override
    public List<Entity> retrieveAllEntities() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public void persist() {

    }

    @Override
    public void load(DataSourceConfiguration config) {

    }
}
