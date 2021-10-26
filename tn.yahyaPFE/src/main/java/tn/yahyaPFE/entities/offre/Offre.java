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
public class Offre {

	public Offre(Long id, String mission, String speciality, Integer anneeExp, String tmps, Long prix, long idUser) {
		super();
		this.id = id;
		this.mission = mission;
		this.speciality = speciality;
		this.anneeExp = anneeExp;
		this.tmps = tmps;
		this.prix = prix;
		this.idUser = idUser;
	}
	@Id

	private Long id  ;
	private String mission ; 
	private String speciality ; 
	private Integer anneeExp ;
	private String tmps ;

	private Long prix ;
	private long idUser ; 
	private String desciption ; 	
	
	

}
