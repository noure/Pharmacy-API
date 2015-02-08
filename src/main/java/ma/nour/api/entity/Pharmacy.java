package ma.nour.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Pharmacy {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String adress;
	
	private String tele;
}
