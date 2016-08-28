package com.adamkoch.slab;

import java.util.*;

/**
 * Created by Adam on 3/2/2015.
 */
public class InMemoryRepository implements Repository<Entity> {

    private static final long serialVersionUID = -3359391703624929812L;

    Map<UUID, Entity> map = new HashMap<>();

    @Override
    public void put(final Entity entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public Entity get(final UUID uuid) {
        return map.get(uuid);
    }

    @Override
    public List<Entity> retrieveAllEntities() {
        return new ArrayList<>(map.values());
    }

    @Override
    public String toString() {
        return "DefaultRepository{" +
                "map=" + map +
                '}';
    }
}
