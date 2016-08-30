package com.adamkoch.slab;

/**
 * Created by aakoch on 8/29/16.
 */
public interface PersistentRepository<T> extends Repository<T> {

    void persist();

    void load(DataSourceConfiguration config);

}
