package com.adamkoch.slab;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Adam on 2016-08-20.
 */
public interface Entity extends Serializable {
    UUID getId();

    void setId(UUID id);
}
