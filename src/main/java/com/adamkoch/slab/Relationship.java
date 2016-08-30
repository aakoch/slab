package com.adamkoch.slab;

import java.io.Serializable;

/**
 * Created by aakoch on 8/29/16.
 */
public class Relationship<T extends Entity> implements Serializable {
    private final T from;
    private final T to;
    private Descriptor descriptor;

    private Relationship(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relationship<?> that = (Relationship<?>) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        return descriptor != null ? descriptor.equals(that.descriptor) : that.descriptor == null;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "from=" + from +
                ", to=" + to +
                ", descriptor=" + descriptor +
                '}';
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (descriptor != null ? descriptor.hashCode() : 0);
        return result;
    }

    static class Builder<T extends Entity> {
        private T fromPerson;
        private T toPerson;
        private Descriptor descriptor;

        public Builder from(T person) {
            this.fromPerson = person;
            return this;
        }

        public Builder to(T person) {
            this.toPerson = person;
            return this;
        }

        public Builder as(Descriptor descriptor) {
            this.descriptor = descriptor;
            return this;
        }

        public Relationship build() {
            assert fromPerson != null;
            assert toPerson != null;
            Relationship person = new Relationship(fromPerson, toPerson);
            person.setDescriptor(descriptor);
            return person;
        }
    }
}
