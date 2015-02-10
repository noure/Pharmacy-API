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
	@RequestMapping
	public List<Pharmacy> findAll() {
		return pharmacyService.findAll();
	}

	/**
	 * return specific pharmacy to the EndPOint by Get request
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	public Pharmacy findOne(@PathVariable("id") int id) {
		return pharmacyService.findOne(id);
	}

	/**
	 * post request
	 * 
	 * @param name
	 * @return
	 */
//	@RequestMapping(value = "/{name}", method = RequestMethod.POST)
//	public Pharmacy findByName(@PathVariable("name") String name) {
//		return pharmacyService.findByName(name);
//	}

	/**
	 * create pharmacy from the endpoint=crawler in this case
	 * 
	 * @param pharmacy
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Pharmacy createOne(@RequestBody Pharmacy pharmacy) {
		pharmacyService.save(pharmacy);

		System.out.println("**********************************");
		System.out.println("nom : " + pharmacy.getName());
		System.out.println("adress : " + pharmacy.getAdress());
		System.out.println("tele : " + pharmacy.getTele());

		return pharmacy;
	}
		
}
