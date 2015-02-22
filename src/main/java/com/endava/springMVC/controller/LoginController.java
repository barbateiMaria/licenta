package com.endava.springMVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.endava.springMVC.dao.AdministratorDAO;

//de pe index.jsp facem trimitere la login.htm(toate rul le ia dispatcher servlet;
//in metoda din ctrl returnez view-ul
@Controller
public class LoginController {

	@Autowired
	AdministratorDAO adminDao;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String displayLoginPage() {
		return "login";
	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public ModelAndView authetificateAdmin(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println(username);
		ModelAndView modelView = new ModelAndView();
		// User u = userdao.login(username, password);
		if (adminDao.login(username, password) != null) {
			modelView.setViewName("welcome");
		} else {
			modelView.setViewName("login");
			modelView.addObject("errorMessage",
					"Incorrect username or password!!");
		}
		return modelView;

	}
	

	@RequestMapping(value = "/signUp.htm", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@RequestParam(value = "firstname") String firstName,
			@RequestParam(value = "lastname") String lastName,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String password) {
		
		ModelAndView modelView = new ModelAndView();
		adminDao.signUp(firstName, lastName, userName, email, password);
		modelView.setViewName("login");
		modelView.addObject("infoMessage", "Please login here with the credentials you have just chosen!");
		return modelView;
		

	}

	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
		System.out.println("User logged out sucessfully!!");
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		modelView.addObject("infoMessage", "User logged out successfully!!");
		
		return modelView;
	}

}
