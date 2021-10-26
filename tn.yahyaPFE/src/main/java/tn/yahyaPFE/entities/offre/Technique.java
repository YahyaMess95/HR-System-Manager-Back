package tn.yahyaPFE.entities.offre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Technique {
	public Technique(String technique2, Long id2) {
this.technique = technique2 ; 
this.idOffre = id2 ; 
	}

	@Id
	@GeneratedValue
	private Long id;
	private String technique ;

	private long idOffre ;
}
