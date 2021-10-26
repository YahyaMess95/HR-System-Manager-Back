package tn.yahyaPFE.entities.offre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Formation {

	public Formation(String formation2, Long id2) {
		
		this.formation = formation2 ; 
		this.idOffre  = id2 ;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	private String formation ;
	private long idOffre ;
}
