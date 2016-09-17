package com.adamkoch.slab;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * I'm thinking a repo is just a container for holding all the Entities and should not be tied to the persistence.
 * I think a repo should have search capabilities.
 *
 * Created by Adam on 2/27/2015.
 */
public interface Repository<T extends Entity> extends Serializable {

    void put(T entity);
    T get(UUID uuid);

    Collection<T> search(Query query);

    void delete(UUID uuid);
}
