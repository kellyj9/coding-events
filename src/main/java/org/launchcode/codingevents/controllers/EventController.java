package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired // specifies that Spring Boot should auto-populate this field
                      // feature of Spring Boot - dependency injection / inversion of control
    private EventRepository eventRepository;
    // findAll, save, findById are part of the EventRepository interface

    //private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
       model.addAttribute("event", new Event()); // "event" label not required here
        model.addAttribute("types", EventType.values()); // will return an array of the four
        // different values that my EventType that exist for that enum and then we can
        // use that in the form to create a drop down
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        // if there are any errors in the Model object...go back to the form
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            model.addAttribute("types", EventType.values()); // added
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:"; // root path can be left off
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required=false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
