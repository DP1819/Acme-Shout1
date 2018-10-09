
package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import security.LoginService;
import services.ShoutService;
import domain.Shout;

@Controller
@RequestMapping("shout")
public class ShoutController extends AbstractController {

	// Service

	@Autowired
	private ShoutService	shoutService;


	// List

	@RequestMapping("list")
	public ModelAndView list() {
		final ModelAndView res = new ModelAndView("shout/list");
		final List<Shout> shouts = this.shoutService.findAll();
		res.addObject("shouts", shouts);
		res.addObject("requestURI", "shout/list");
		return res;
	}

	// Create

	@RequestMapping("create")
	public ModelAndView create() {
		final ModelAndView res;
		final Shout shout = this.shoutService.create();
		res = this.createEditModelAndView(shout);
		return res;
	}

	// Save

	@RequestMapping(value = "edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Shout shout, final BindingResult binding) {
		ModelAndView res;
		if (binding.hasErrors())
			res = this.createEditModelAndView(shout);
		else
			try {
				this.shoutService.save(shout);
				res = new ModelAndView("redirect:list.do");
			} catch (final Throwable t) {
				res = this.createEditModelAndView(shout, "shout.commit.error");
			}
		return res;
	}

	// Ancillary methods

	private ModelAndView createEditModelAndView(final Shout shout) {
		return this.createEditModelAndView(shout, null);
	}

	private ModelAndView createEditModelAndView(final Shout shout, final String msg) {
		final ModelAndView res = new ModelAndView("shout/edit");
		res.addObject("shout", shout);
		res.addObject("message", msg);
		res.addObject("username", LoginService.getPrincipal().getUsername());
		return res;
	}
}
