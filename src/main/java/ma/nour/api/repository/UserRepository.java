package ma.nour.api.repository;

import ma.nour.api.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author noureddine
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
