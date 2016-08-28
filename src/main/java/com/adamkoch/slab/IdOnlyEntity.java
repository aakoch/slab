package com.adamkoch.slab;

import java.util.UUID;

/**
 * Created by Adam on 2016-08-28.
 */
public class IdOnlyEntity implements Entity {
    private UUID uuid;

    public IdOnlyEntity(final UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getId() {
        return uuid;
    }

    @Override
    public void setId(final UUID id) {
        uuid = id;
    }
}
