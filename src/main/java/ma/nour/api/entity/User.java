package ma.nour.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
/**
 * 
 * @author noureddine
 *
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	
}
