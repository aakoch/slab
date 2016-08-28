package com.adamkoch.slab;

import java.util.UUID;

/**
 * Created by Adam on 2016-08-28.
 */
public class DummyEntity implements Entity {
    @Override
    public UUID getId() {
        return UUID.randomUUID();
    }

    @Override
    public void setId(final UUID id) {

    }
}
