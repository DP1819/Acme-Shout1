
package services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ShoutRepository;
import security.Authority;
import security.LoginService;
import domain.Shout;

@Service
@Transactional
public class ShoutService {

	// Repository

	@Autowired
	private ShoutRepository	repository;


	// CRUD methods

	public Shout findOne(final Integer id) {
		return this.repository.findOne(id);
	}

	public List<Shout> findAll(final List<Integer> ids) {
		return this.repository.findAll(ids);
	}

	public List<Shout> findAll() {
		return this.repository.findAll();
	}

	public Shout create() {
		final Shout res = new Shout();
		Boolean isCustomer = false;
		for (final Authority auth : LoginService.getPrincipal().getAuthorities()) {
			isCustomer = auth.getAuthority().equals("CUSTOMER");
			if (isCustomer)
				break;
		}
		Assert.isTrue(isCustomer);
		return res;
	}
	public Shout save(final Shout shout) {
		Shout res;
		Boolean isCustomer = false;
		for (final Authority auth : LoginService.getPrincipal().getAuthorities()) {
			isCustomer = auth.getAuthority().equals("CUSTOMER");
			if (isCustomer)
				break;
		}
		Assert.isTrue(isCustomer);
		Assert.isTrue(shout.getId() == 0);
		res = this.repository.save(shout);
		return res;
	}

	// Queries

	public Integer numberShouts() {
		Boolean isAdmin = false;
		for (final Authority auth : LoginService.getPrincipal().getAuthorities()) {
			isAdmin = auth.getAuthority().equals("ADMIN");
			if (isAdmin)
				break;
		}
		return this.repository.numberShouts();
	}

	public Integer numberShortShouts() {
		Boolean isAdmin = false;
		for (final Authority auth : LoginService.getPrincipal().getAuthorities()) {
			isAdmin = auth.getAuthority().equals("ADMIN");
			if (isAdmin)
				break;
		}
		return this.repository.numberShortShouts();
	}

	public Integer numberLongShouts() {
		Boolean isAdmin = false;
		for (final Authority auth : LoginService.getPrincipal().getAuthorities()) {
			isAdmin = auth.getAuthority().equals("ADMIN");
			if (isAdmin)
				break;
		}
		return this.repository.numberLongShouts();
	}

}
