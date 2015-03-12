package com.endava.springMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.endava.springMVC.dao.NavBarDao;
import com.endava.springMVC.model.Contact;
import com.endava.springMVC.model.Home;
import com.endava.springMVC.model.NavigationBar;
import com.endava.springMVC.utils.NavigationBarElements;

@Controller
public class EventController {
	@Autowired
	private NavBarDao navBarDao;
	
	private String content;
	
	private boolean isHome = false;

	
	@RequestMapping(value = "/manageevent.htm", method = RequestMethod.GET)
	public ModelAndView displayEventPage() {
		ModelAndView modelView = new ModelAndView();
		List<String> menuList = new ArrayList<String>();
		menuList.add("Home");
		menuList.add("Contact");
		modelView.setViewName("manageevent"); 
		modelView.addObject("message", "here we are");
		modelView.addObject("list", menuList);
		return modelView;
	}
	
	@RequestMapping(value = "/generatePage.htm", method = RequestMethod.POST)
	public ModelAndView generateEventPage(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "menuList") String menuList) {
		ModelAndView modelView = new ModelAndView();
		System.out.println(menuList);
		if(menuList.equalsIgnoreCase("Home")) {
			/*Home home = new Home();
			home.setContent(name);
			isHome = true;
			System.out.println(menuList + " " + name);
			String content = home.getContent();
			System.out.println("The content: " + content);
			modelView.addObject("isHome", isHome);
			modelView.addObject("home", home.getContent());*/
			content = name;
			isHome = true;
		} else if(menuList.equalsIgnoreCase(NavigationBarElements.CONTACT.toString())) {		
			content = name;
			/*Contact contact = new Contact();
			contact.setContent(name);
			System.out.println(menuList + " " + name);
			modelView.addObject("isHome", isHome);
			modelView.addObject("contact", contact.getContent());*/

		}
		modelView.setViewName("generatePage");
		return modelView;
	}
	
	@RequestMapping(value = "/contact.htm")
	public String displayContactPage(Model model) {
		Contact contact = new Contact();
		contact.setContent(content);
		model.addAttribute("contact", contact.getContent());
		return "contact";
	}
		
	@RequestMapping(value = "/home.htm")
	public String displayHomePage(Model model) {
		Home home = new Home();
		home.setContent(content);
		model.addAttribute("home", home.getContent());
		return "home";
	}
	
	/*@RequestMapping(value = "/home.htm") 
	public ModelAndView getHomePage() {
		ModelAndView modelView = new ModelAndView();
		Home home = new Home();
		home.setContent(content);
		modelView.addObject("home", home.getContent());
		modelView.setViewName("home");
		return modelView;
	}
	
	@RequestMapping(value = "/contact.htm") 
	public ModelAndView getContactPage() {
		ModelAndView modelView = new ModelAndView();
		Contact contact = new Contact();
		contact.setContent(content);
		modelView.addObject("home", contact.getContent());
		modelView.setViewName("contact");
		return modelView;
		
	}*/
	
	
	
	@RequestMapping(value = "/chooseMenuFeatures.htm") 
	public ModelAndView getNavBarElements() {
		ModelAndView mv= new ModelAndView();
		List<NavigationBar> navBars = navBarDao.getAllNavBarElements();
		List<String> contentNavBar = new ArrayList<String>();
		for(int i=0;i<navBars.size();i++) {
			contentNavBar.add(navBars.get(i).getContent());
		}
		mv.setViewName("chooseMenuFeatures");
		mv.addObject("navBars", contentNavBar);
		mv.addObject("navigationBar", new NavigationBar());
		return mv;
		
	}
	/*
	@RequestMapping(value = "/manageevent.htm" , method = RequestMethod.POST)
	public String chosenNavBarElements(@ModelAttribute NavigationBar navigationBar) {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("manageevent");
		mv.addObject("navigationBar", navigationBar); 
		return "manageevent";

		
	}
	*/
	

	
	
	
}