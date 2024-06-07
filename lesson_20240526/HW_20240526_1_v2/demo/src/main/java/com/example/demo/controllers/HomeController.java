package com.example.demo.controllers;

import com.example.demo.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        String name = "User";
        model.addAttribute("name", name);
        System.out.println("home");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        String info = "Information about our the best company of the world.";
        model.addAttribute("info", info);

        String[] departments = {"Main office", "Planning", "Building", "Future projects"};
        model.addAttribute("structure", departments);

        Person person = new Person("John Doe", 30);
        model.addAttribute("person", person);

        System.out.println("about");
        return "about";
    }
}
