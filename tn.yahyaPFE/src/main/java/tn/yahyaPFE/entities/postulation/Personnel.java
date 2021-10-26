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

public class Personnel {

	@Id
	@GeneratedValue
	private Long id ;
	private String nom ;
	private String prenom ;
	private String numTel ;
	private String email ;
	private String sexe ;
	private String dateNaissance ; 
	private String localisation ;
	private float logitude ; 
	private float latitude ;
	private String situationFamiliale; 
	private Long idOffre ; 
	private String Tmps ;
	private String motivation ;
	private String dev ;
	private String etat ;
	
	
}
