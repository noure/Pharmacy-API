package ma.nour.api.controller;

import java.util.List;

import ma.nour.api.entity.Pharmacy;
import ma.nour.api.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {

	@Autowired
	private PharmacyService pharmacyService;

	/**
	 * return list of pharmacies to the EndPoint
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Pharmacy> findAll() {
		return pharmacyService.findAll();
	}

	/**
	 * return specific pharmacy to the EndPOint
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pharmacy findOne(@PathVariable int id) {
		return pharmacyService.findOne(id);
	}

	/**
	 * create pharmacy from the endpoint=crawler in this case
	 * 
	 * @param pharmacy
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Pharmacy createOne(@RequestBody Pharmacy pharmacy) {
		pharmacyService.save(pharmacy);

		return pharmacy;
	}

}
