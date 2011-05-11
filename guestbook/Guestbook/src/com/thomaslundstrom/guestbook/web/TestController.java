package com.thomaslundstrom.guestbook.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.thomaslundstrom.guestbook.domain.Greeting;
import com.thomaslundstrom.guestbook.domain.GreetingRepository;
  
@Controller  
public class TestController {  
	
	@Autowired
	private GreetingRepository greetingRepository;
  
    @RequestMapping(value = "/test.do", method = RequestMethod.POST)  
    public String get(String message, Model model) {

    	UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
    	Greeting greeting = new Greeting(user, message, new Date());
    	
    	greetingRepository.save(greeting);
    	
    	Collection<Greeting> greetings = greetingRepository.findAll();
    	model.addAttribute("greetings", greetings);
    	
//        model.addAttribute("name", name);

//    	boolean result = greetingRepository.doStuff();
//        model.addAttribute("stuff", result);
    	
        return "test";
    }  
}  