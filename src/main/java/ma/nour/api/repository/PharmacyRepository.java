package ma.nour.api.repository;

import ma.nour.api.entity.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	/**
	 * Retrive a Pharmacy From database
	 * @param name
	 * @return Pharmacy 
	 */
	Pharmacy findByName(String name);

}
