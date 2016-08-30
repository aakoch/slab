package com.adamkoch.slab;

import java.util.*;

/**
 * Created by Adam on 3/2/2015.
 */
public class InMemoryRepository<T extends Entity> implements Repository<T> {

    private static final long serialVersionUID = -3359391703624929812L;

    Map<UUID, T> map = new HashMap<>();

    @Override
    public void put(final T entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public T get(final UUID uuid) {
        return map.get(uuid);
    }

    @Override
    public List<T> retrieveAllEntities() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void delete(final UUID uuid) {
        map.remove(uuid);
    }

    @Override
    public String toString() {
        return "DefaultRepository{" +
                "map=" + map +
                '}';
    }
}
