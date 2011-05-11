package com.thomaslundstrom.guestbook.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.thomaslundstrom.guestbook.domain.greeting.Greeting;
import com.thomaslundstrom.guestbook.domain.greeting.GreetingRepository;

@Controller
public class GreetingsController {

	@Autowired
	private GreetingRepository greetingRepository;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {

		Collection<Greeting> greetings = greetingRepository.findAll();
		model.addAttribute("greetings", greetings);

		return "list";
	}
	
	@RequestMapping(value="get/{id}", method = RequestMethod.GET)
	public @ResponseBody Greeting get(@PathVariable long id) {
		Greeting greeting = greetingRepository.get(id);
		
		return greeting;
	}

	@RequestMapping(value = "post", method = RequestMethod.POST)
	public String post(String message, Model model) {

    	UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
    	Greeting greeting = new Greeting(user, message, new Date());
    	
    	greetingRepository.save(greeting);
		
		return "redirect:/greetings/list.do";
	}
}
