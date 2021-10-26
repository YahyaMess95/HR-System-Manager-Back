package tn.yahyaPFE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemandeDTO {
	private Long id  ;
	private String Mission ; 
	private String speciality ; 
	private Integer anneeExp ;
	private String tmps ;
	private String etat ;
	private String commentaire ;
	private Long prix ;
	
}

