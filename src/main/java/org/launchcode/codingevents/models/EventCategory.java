package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long.")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events = new ArrayList<>(); // list itself cannot be changed,
                                                    // however, the contents can still be changed.

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

    public List<Event> getEvents() {
        return events;
    }
    //no setter for events because it can't change

    @Override
    public String toString() {
        return name;
    }

}