package tn.yahyaPFE.entities.postulation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Competence {

	@Id
	@GeneratedValue
	private Long id ;
	private String competence ; 
	private String type ;
	private Long idPersonel;


}
