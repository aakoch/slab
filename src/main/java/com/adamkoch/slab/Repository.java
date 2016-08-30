package com.adamkoch.slab;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Adam on 2/27/2015.
 */
public interface Repository<T> extends Serializable {

    void put(T entity);
    T get(UUID uuid);

    List<T> retrieveAllEntities();

    void delete(UUID uuid);
}
