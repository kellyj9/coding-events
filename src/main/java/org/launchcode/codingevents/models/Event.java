package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "invalid email.  Try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    private String location;

    @AssertTrue(message = "Event Registration is required.")
    private Boolean isRegistrationRequired; // must always be true for the purpose of
    // validation practice

    private EventType type;

    public Event() { // we always need an empty constructor inside persistence class
    }

    public Event(String name, String description, String contactEmail, String location,
                 Boolean isRegistrationRequired, EventType type) {
        //this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.isRegistrationRequired = isRegistrationRequired;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsRegistrationRequired() {
        return isRegistrationRequired;
    }

    public void setIsRegistrationRequired(Boolean isRegistrationRequired) {
        this.isRegistrationRequired = isRegistrationRequired;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

}

