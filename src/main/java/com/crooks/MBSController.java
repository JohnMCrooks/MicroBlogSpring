/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by johncrooks on 6/20/16.
 */
@Controller
public class MBSController {
    @Autowired
    MessageRepository mesgList;
    @Autowired
    UserRepository userRepository;



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){

        String username = (String) session.getAttribute("username");  //grabs username out of the session // Has to be cast as a String because it's kinda dumb
        User user = userRepository.findByUsername(username);
        if (username != null){
            Iterable<Message> messageIteration =  mesgList.findAll();
            model.addAttribute("messages", messageIteration);            // add messages to model
            model.addAttribute("user", user);                            //add user to the model (AKA link it to the HTML)

        }
        return "home";
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(String username,String password, HttpSession session) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user==null){
            user = new User(username, password);
            userRepository.save(user);
        } else if(!user.password.equals(password)) {
            throw new Exception("------WRONG PASSWORD-----");
        }

        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path ="/add-message", method = RequestMethod.POST)
    public String addMessage(String msgText){
        Message message = new Message(msgText);
        mesgList.save(message);
        return "redirect:/";
    }

    @RequestMapping(path="/edit", method=RequestMethod.POST)
    public String editMessage(Integer msgId, String editedText){
        Message message = mesgList.findOne(msgId);
        message.msgText = editedText;
        mesgList.save(message);

        return "redirect:/";
    }

    @RequestMapping(path="/delete", method=RequestMethod.POST)
    public String delete(Integer msgId){
        mesgList.delete(msgId);

        return "redirect:/";
    }

    @RequestMapping(path="/logout", method=RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}//end MBSController Class
