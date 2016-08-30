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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdOnlyEntity that = (IdOnlyEntity) o;

        return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }
}
