package tn.yahyaPFE.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class CompTechDemande {

	@Id
	@GeneratedValue
	private Long id;
	private String comptech1 ;
	private String comptech2 ;
	private String comptech3 ;
	private String comptech4 ;
	@ManyToOne
	@JoinColumn(name = "demande_id", nullable = true)
	private Demande demande ;
}
