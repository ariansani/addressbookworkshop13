package com.example.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import com.example.model.Contact;

import org.springframework.boot.ApplicationArguments;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Contacts {
    private Logger logger = Logger.getLogger(Contacts.class.getName());

    public void saveContact(Contact contact, Model model, ApplicationArguments appArgs) {
        String datafilename = contact.getId();
        Set<String> optNames = appArgs.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String[optNames.size()]);
        List<String> optValues = appArgs.getOptionValues(optNamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);
        PrintWriter printWriter = null;
        try{
            FileWriter fileWriter = new FileWriter(optValuesArr[0]+"/"+ datafilename,Charset.forName("utf-8"));
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            printWriter.println(contact.getPhoneNumber());
        }catch(IOException e){
            logger.log(Level.WARNING,e.getMessage());
        }finally{
            printWriter.close();
        }
        model.addAttribute("contact", new Contact(contact.getId(),contact.getName(),contact.getEmail(),contact.getPhoneNumber()));

    }

    public void getContactById(Model model, String contactId, ApplicationArguments appArgs){
        Set<String> optNames = appArgs.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String[optNames.size()]);
        List<String> optValues = appArgs.getOptionValues(optNamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);
        //response object
        Contact cResp = new Contact();
        try{
            Path filePath = new File(optValuesArr[0] + "/" + contactId).toPath();
            Charset charset = Charset.forName("utf-8");
            List<String> stringListVal = Files.readAllLines(filePath, charset);
            cResp.setName(stringListVal.get(0));
            cResp.setEmail(stringListVal.get(1));
            cResp.setPhoneNumber(stringListVal.get(2));
            cResp.setId(contactId);
        }catch(IOException e){
            logger.log(Level.WARNING, e.getMessage());
        }

        model.addAttribute("contact", cResp);
    }

}
