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
public class Social {
	@Id
	@GeneratedValue
	private Long id;
	private String social ;
	private Long idOffre ;
	public Social(String social, Long idOffre) {
	
		this.social = social;
		this.idOffre = idOffre;
	}

	
	
	
	
}
