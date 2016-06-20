/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by johncrooks on 6/20/16.
 */
@Controller
public class MBSController {
    ArrayList<Message> mesgList = new ArrayList<>();



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session, String name, Integer msgId, String msgText){
        if (name==null){
            name = "snow";
        }
        if(msgId==null){
            msgId=1;
        }
        if (msgText==null){
            msgText = "";
        }

        Message message = new Message(msgId, msgText);
        model.addAttribute("message", mesgList);

        String username = (String) session.getAttribute("username");  //grabs username out of the session // Has to be cast as a String because it's kinda dumb
        User user = null;
        if (username!=null){                                     //if username isn't null create a new user
            user = new User(username);
        }else{
        }
        model.addAttribute("user", user);                        //add user to the model (AKA link it to the HTML)
        return "home";
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(String username, HttpSession session){
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path ="/add-message", method = RequestMethod.POST)
    public String addMessage(String msgText){
        Message message = new Message(mesgList.size()+1,msgText);
        mesgList.add(message);
        return "redirect:/";
    }

    @RequestMapping(path="/delete", method=RequestMethod.POST)
    public String delete(Integer msgId){
        mesgList.remove(msgId-1);
        int i = 1;
        for (Message message:mesgList                       //reset msg.ids after every deletion so no errors arise.
             ) {
            message.msgId = i;
            i++;
        }
        System.out.println();
        return "redirect:/";
    }

    @RequestMapping(path="/logout", method=RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}//end MBSController Class
