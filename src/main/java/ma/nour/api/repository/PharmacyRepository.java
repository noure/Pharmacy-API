package ma.nour.api.repository;

import ma.nour.api.entity.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	Pharmacy findByName(String name);

}
