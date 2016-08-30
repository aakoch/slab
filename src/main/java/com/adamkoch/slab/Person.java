package com.adamkoch.slab;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by aakoch on 8/29/16.
 */
public class Person extends IdOnlyEntity {
    private Collection<Relationship> relationships;

    public Person(UUID uuid) {
        super(uuid);
    }

    public Collection<Relationship> getAllRelationships() {
        return relationships;
    }

    public Collection<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(Collection<Relationship> relationships) {
        this.relationships = relationships;
    }
}
