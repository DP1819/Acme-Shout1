/*
 * ProfileController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import forms.Calculator;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;
		List<String> quotes;

		quotes = new ArrayList<String>();
		quotes.add("I’m selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can’t handle me at my worst, then you sure as hell don’t deserve me at my best. -Marrilyn Monroe");
		quotes.add("Whatever the mind of man can conceive and believe, it can achieve. -Napoleon Hill");
		quotes.add("Strive not to be a success, but rather to be of value. -Albert Einstein");
		quotes.add("Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference. -Robert Frost");
		quotes.add("Porque lo que es, es, y lo que no es, no es. -Magdalena");
		quotes.add("I attribute my success to this: I never gave or took any excuse. -Florence Nightingale");
		quotes.add("Tenemos mil recetas de pasteles y todas ellas número uno. -Apu, Simpsons");
		quotes.add("You miss 100% of the shots you don’t take. -Wayne Gretzky");
		quotes.add("¿por qué no te callas? -Rey Juan Carlos I");
		quotes.add("Every strike brings me closer to the next home run. -Babe Ruth");
		quotes.add("Definiteness of purpose is the starting point of all achievement. -W. Clement Stone");
		quotes.add("Life isn't about getting and having, it's about giving and being. -Kevin Kruse");
		quotes.add("Life is what happens to you while you’re busy making other plans. -John Lennon");
		quotes.add("We become what we think about. -Earl Nightingale");
		quotes.add("Life is 10% what happens to me and 90% of how I react to it. -Charles Swindoll");
		quotes.add("The mind is everything. What you think you become. -Buddha");

		Collections.shuffle(quotes);
		quotes = quotes.subList(0, 3);

		result = new ModelAndView("profile/action-1");
		result.addObject("quotes", quotes);

		return result;
	}

	// Action-2 ---------------------------------------------------------------		

	@RequestMapping(value = "/action-2", method = RequestMethod.GET)
	public ModelAndView action2Get() {
		ModelAndView result;
		Calculator calculator;

		calculator = new Calculator();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;
	}

	@RequestMapping(value = "/action-2", method = RequestMethod.POST)
	public ModelAndView action2Post(@Valid final Calculator calculator, final BindingResult binding) {

		ModelAndView result;

		calculator.compute();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;

	}

	// Action-3 ---------------------------------------------------------------		

	@RequestMapping("/action-3")
	public ModelAndView action3() {
		throw new RuntimeException("Oops! An *expected* exception was thrown. This is normal behaviour.");
	}

}
