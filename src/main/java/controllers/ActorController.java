
package controllers;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView calculator() {
		final ModelAndView res = new ModelAndView("actor/calculator");
		return res;
	}

	@RequestMapping("exception")
	public ModelAndView exception() {
		return super.panic(new RuntimeException());
	}

}
