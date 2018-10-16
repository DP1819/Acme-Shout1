
package controllers;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Calculator;

@Controller
@RequestMapping("actor")
public class ActorController extends AbstractController {

	@RequestMapping("random-quotes")
	public ModelAndView randomQuotes() {
		final Random random = new Random(Calendar.getInstance().getTimeInMillis());
		final ModelAndView res = new ModelAndView("actor/random-quotes");
		final String[] randomQuotes = {
			"Esta es una cita inspiracional - Homero", "This is an inspiring quote - Homero", "Lo único que sé es que no se nada - Sócrates", "La República - Platón", "Así habló Zaratrusta - Nietzsche"
		};
		final Set<String> quotes = new HashSet<String>();
		while (quotes.size() < 3)
			quotes.add(randomQuotes[random.nextInt(5)]);
		res.addObject("quotes", quotes);
		return res;
	}

	@RequestMapping("calculator")
	public ModelAndView action2Get() {
		ModelAndView result;
		Calculator calculator;

		calculator = new Calculator();

		result = new ModelAndView("actor/calculator");
		result.addObject("calculator", calculator);

		return result;
	}

	@RequestMapping(value = "calculator", method = RequestMethod.POST)
	public ModelAndView action2Post(@Valid final Calculator calculator, final BindingResult binding) {

		ModelAndView result;

		calculator.compute();

		result = new ModelAndView("actor/calculator");
		result.addObject("calculator", calculator);

		return result;

	}

	@RequestMapping("exception")
	public ModelAndView exception() {
		return super.panic(new RuntimeException());
	}

}
