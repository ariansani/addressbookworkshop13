package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.model.Contact;
import com.example.util.Contacts;

@Controller
public class AddressbookController {
    private Logger logger = Logger.getLogger(AddressbookController.class.getName());
    @Autowired
    private ApplicationArguments applicationArguments;

    @GetMapping("/")
    public String contactForm(Model model){
        logger.log(Level.INFO,"Show the contact form");
        model.addAttribute("contact",new Contact());
        return "contact";
    }

    @GetMapping("/getContact/{contactId}")
    public String getContact(Model model, @PathVariable(value="contactId") String contactId){
        logger.log(Level.INFO,"Get contact info");
        Contacts ct = new Contacts();
        ct.getContactById(model, contactId, applicationArguments);
        return "showContact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@ModelAttribute Contact contact, Model model){
        logger.log(Level.INFO,"Name: "+ contact.getName());
        logger.log(Level.INFO,"Email: "+contact.getEmail());
        logger.log(Level.INFO,"Phone Number: "+contact.getPhoneNumber());
        logger.log(Level.INFO,"ID: " + contact.getId());
        Contacts ct = new Contacts();
        ct.saveContact(contact, model, applicationArguments);
        return "showContact";
    }

}
