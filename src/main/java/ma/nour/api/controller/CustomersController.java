package ma.nour.api.controller;

import java.util.List;

import ma.nour.api.entity.User;
import ma.nour.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author noureddine
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private UserService myService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping
	public List<User> list() {
		return myService.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public User user(@PathVariable int id) {
		return myService.findOne(id);
	}

}
