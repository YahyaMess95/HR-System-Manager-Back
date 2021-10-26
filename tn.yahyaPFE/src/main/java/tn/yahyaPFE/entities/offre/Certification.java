package tn.yahyaPFE.entities.offre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.Demande;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certification {
	public Certification(String certification, Long id2) {
		this.certification =  certification ;
		this.idOffre  = id2 ;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String certification ; 
	private long idOffre ;
}
