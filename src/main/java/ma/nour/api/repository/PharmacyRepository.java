package ma.nour.api.repository;

import java.util.List;

import ma.nour.api.entity.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author noureddine
 *
 */
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	/**
	 * Retrive a Pharmacy From database
	 * @param name
	 * @return Pharmacy 
	 */
	Pharmacy findByName(String name);

	List<Pharmacy> findByGardeTrue();

}
