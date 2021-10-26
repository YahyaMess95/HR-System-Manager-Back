package tn.yahyaPFE.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class CompSocialeDemande {

	@Id
	@GeneratedValue
	private Long id;
	
	private String compsocial1;
	private String compsocial2;
	private String compsocial3;
	private String compsocial4;
	@ManyToOne
	@JoinColumn(name = "demande_id", nullable = true)
	private Demande demande ;
	
	
}
