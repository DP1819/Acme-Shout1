/*
 * AdministratorController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.ShoutService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Service

	@Autowired
	private ShoutService	shoutService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

	// Dashboard

	@RequestMapping("dashboard")
	public ModelAndView dashboard() {
		final ModelAndView res = new ModelAndView("administrator/dashboard");
		res.addObject("numberShouts", this.shoutService.numberShouts());
		res.addObject("numberLongShouts", this.shoutService.numberLongShouts());
		res.addObject("numberShortShouts", this.shoutService.numberShortShouts());
		return res;
	}

}
