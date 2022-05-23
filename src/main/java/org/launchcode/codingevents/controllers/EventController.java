package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }


    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("events", events);
        return "events/create";
    }

    //lives at /events/create (Handles a different kind of request than rendercreateeventform
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {
        events.add(new Event(eventName));
        return "redirect:"; //will redirect to root path if you don't specify where
    }
}
