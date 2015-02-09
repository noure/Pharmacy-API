package ma.nour.api.controller;

import java.util.List;

import ma.nour.api.entity.Pharmacy;
import ma.nour.api.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author noureddine
 *
 */
@RestController
@RequestMapping("/api/pharmaciesgarde/")
public class PharmacyGardeController {

	@Autowired
	PharmacyService pharmacyService;

	/**
	 * return all pharmacygarde
	 * 
	 * @return
	 */
	@RequestMapping
	public List<Pharmacy> findAll() {
		return pharmacyService.findGarde();
	}

}
