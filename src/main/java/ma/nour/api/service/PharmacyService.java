package ma.nour.api.service;

import java.util.List;

import ma.nour.api.entity.Pharmacy;
import ma.nour.api.repository.PharmacyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author noureddine
 *
 */
@Service
@Transactional
public class PharmacyService {

	@Autowired
	private PharmacyRepository pharmacyRepository;

	/**
	 * 
	 * @param pharmacie
	 */
	public void save(Pharmacy pharmacie) {
		if (pharmacyRepository.findByName(pharmacie.getName()) == null) {
			pharmacyRepository.save(pharmacie);
		} else
			update(pharmacie);
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
	 * list de pharmacie de garde
	 * 
	 * @return
	 */
	public List<Pharmacy> findGarde() {
		return pharmacyRepository.findByGardeTrue();
	}

	/**
	 * update
	 * 
	 * @param pharmacy
	 */
	public void update(Pharmacy pharmacy) {

		Pharmacy pharmacy2 = findByName(pharmacy.getName());
		pharmacy2.setAdress(pharmacy.getAdress());
		pharmacy2.setGarde(pharmacy.isGarde());
		pharmacy2.setName(pharmacy.getName());

	}

}
