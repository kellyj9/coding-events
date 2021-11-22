package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long.")
    private String name;

    public EventCategory() {}

    public EventCategory(@Size(min=3, message="Name must be at least 3 characters long.") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}