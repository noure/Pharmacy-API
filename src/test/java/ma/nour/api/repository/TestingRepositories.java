package ma.nour.api.repository;

/**
 * In this class we implement feautre that the DAO layer should have 
 * 
 */

import java.util.List;

import ma.nour.api.Application;
import ma.nour.api.entity.Pharmacy;
import ma.nour.api.repository.PharmacyRepository;
import ma.nour.api.repository.UserRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class TestingRepositories {

	// injecting the PharmacyRepository we could use CDI or XML configuration
	@Autowired
	
	PharmacyRepository pharmacyRepository;

	// injecting the UserRepository we could use CDI or XML configuration
	@Autowired
	UserRepository userRepository;

	/***
	 * This methode test that the injection is done 
	 */
	@Test
	public void contextLoad() {
		Assert.assertNotNull("the repository should be not null",
				this.pharmacyRepository);
	}
	
	/***
	 * This methode test that we can load from data base 
	 * actually at firt this will not pass because simply there is nothing in data base  
	 */

	@Test
	public void loadFromDatabase() {

		List<Pharmacy> phars = pharmacyRepository.findAll();

		Assert.assertNotNull("pharmacies list should not be null", phars);
		Assert.assertTrue("Users list should not be empty", userRepository
				.findAll().size() > 0);
		Assert.assertTrue("pharms list should not be empty", pharmacyRepository
				.findAll().size() > 0);

	}

}
