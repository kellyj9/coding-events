package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL) // tells hibernate to cascade every event
                            //on an Event Object (i.e. deleting or saving Event object) then
                            // cascade the operation down to the EventObject
    @Valid
    @NotNull
    private EventDetails eventDetails;

    // JPA annotations:
    @ManyToOne // relate one event category for an event
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Event() { // we always need an empty constructor inside persistence class
    }

    public Event(String name, EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    // gives a way to add tags without touching the tag collection directly
    public void addTag(Tag tag) {
        this.tags.add(tag);
    }


    @Override
    public String toString() {
        return name;
    }

}

