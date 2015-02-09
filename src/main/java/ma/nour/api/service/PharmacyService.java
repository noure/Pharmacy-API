package ma.nour.api.service;

import java.util.List;

import ma.nour.api.entity.Pharmacy;
import ma.nour.api.repository.PharmacyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author noureddine
 *
 */
@Service
public class PharmacyService {

	@Autowired
	private PharmacyRepository pharmacyRepository;

	/**
	 * 
	 * @param pharmacie
	 */
	public void save(Pharmacy pharmacie) {
		pharmacyRepository.save(pharmacie);
	}

	/**
	 * 
	 * @return list<Pharmacy>
	 */

	public List<Pharmacy> findAll() {
		return pharmacyRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Pharmacy findOne(int id) {
		return pharmacyRepository.findOne(id);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */

	public Pharmacy findByName(String name) {
		return pharmacyRepository.findByName(name);

	}

	/**
	 * 
	 * @return
	 */
	public List<Pharmacy> findGarde() {
		return pharmacyRepository.findByGardeTrue();
	}

}
