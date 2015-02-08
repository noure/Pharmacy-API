package ma.nour.api.service;

import javax.annotation.PostConstruct;

import ma.nour.api.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this classe is for initialising the database we could use a sql script to
 * perform this but this is much beautiful
 * 
 *  
 * @author noureddine
 *
 */
@Service
public class InitDbService {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		{
			User user = new User();
			user.setName("Jirka");
			userService.save(user);
		}
		{
			User user = new User();
			user.setName("Michal");
			userService.save(user);
		}
	}
}
