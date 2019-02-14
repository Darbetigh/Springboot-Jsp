package com.example.geek.controller;

import com.example.geek.form.Subscriber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
    @ModelAttribute("frequencies")
    public Subscriber.Frequency[] frequencies() {
        return Subscriber.Frequency.values();
    }

    @RequestMapping(value="form", method= RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("subscriber", new Subscriber());
        return "formPage";
    }

    @RequestMapping(value="form", method=RequestMethod.POST)
    public String submitForm(@ModelAttribute Subscriber subscriber, Model m) {
        m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
        return "formPage";
    }
}
