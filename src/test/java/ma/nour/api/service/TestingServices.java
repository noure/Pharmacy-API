package ma.nour.api.service;

import ma.nour.api.Application;
import ma.nour.api.entity.Pharmacy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class TestingServices {

	@Autowired
	PharmacyService pharmacyService;

	/**
	 * preparing the databse for test
	 */
	@Before
	public void setUp() {
		Pharmacy phar = new Pharmacy();
		phar.setAdress("testing adress");
		phar.setName("Ensa Pharmacy ");
		phar.setTele("tele bidon");
		phar.setGarde(true);
		pharmacyService.save(phar);
	}

	/**
	 * testing injection context is working
	 */

	@Test
	public void WhenWiringServiceThenInject() {
		Assert.assertNotNull("PharmacyService Bean should not be null",
				pharmacyService);
	}

	/**
	 * testing persistence is working
	 */
	@Test
	public void WhenSavePharmacyThenPersiste() {
		Assert.assertTrue("the size of list pharmacies should be one",
				pharmacyService.findAll().size() == 1);

	}

	/**
	 * testing findAll()
	 */
	@Test
	public void FindAllSerivceShouldGivesAllPharmacies() {

		Pharmacy phar2 = new Pharmacy();
		phar2.setAdress("testing adress");
		phar2.setName("Ensa Pharmacy ");
		phar2.setTele("tele bidon");

		Assert.assertTrue("we should have 2pharmacies no more no less",
				pharmacyService.findAll().size() == 2);
	}

	/**
	 * testing findByName()
	 */
	@Test
	public void TestFindByName() {
		Assert.assertEquals(pharmacyService.findByName("Ensa Pharmacy ")
				.getName(), "Ensa Pharmacy ");
		Assert.assertEquals(pharmacyService.findByName("Ensa Pharmacy ")
				.getName(), "Ensa Pharmacy ");
		Assert.assertEquals(pharmacyService.findByName("Ensa Pharmacy ")
				.getTele(), "tele bidon");
		Assert.assertEquals(pharmacyService.findByName("Ensa Pharmacy ")
				.getAdress(), "testing adress");

	}

	/**
	 * testing looking by garde
	 */
	@Test
	public void TestFindByGarde() {

		Pharmacy pha3r = new Pharmacy();
		pha3r.setAdress("testing adress");
		pha3r.setName("Ensa Pharmacy ");
		pha3r.setTele("tele bidon");
		pha3r.setGarde(false);
		Assert.assertEquals(
				"should return pharmacies with garde egale to true",
				pharmacyService.findGarde().get(0).isGarde(), true);
		Assert.assertEquals(
				"should return pharmacies with garde egale to true",
				pharmacyService.findGarde().get(1).isGarde(), false);

	}

}
