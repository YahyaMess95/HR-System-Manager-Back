package tn.yahyaPFE.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class CertifDemande {
	@Id
	@GeneratedValue
	private Long id;
	private String certification1 ; 
	private String certification2 ; 
	private String certification3 ; 
	private String certification4 ; 
	
	
	
	@ManyToOne
	@JoinColumn(name = "demande_id", nullable = true)
	private Demande demande ;
}
