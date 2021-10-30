package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String getEventsList(Model model) {
        ArrayList<String> events = new ArrayList<>();
        events.add("Hear from the Hirer Event");
        events.add("Stellar Soirée");
        events.add("Mock Inteews");
        model.addAttribute("events", events);
        return "events/index";
    }

}
