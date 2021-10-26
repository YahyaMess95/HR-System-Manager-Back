package tn.yahyaPFE.entities;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data


public class Demande implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id  ;
	private String Mission ; 
	private String speciality ; 
	private Integer anneeExp ;
	private String tmps ;
	private String etat ; 
	private String commentaire ;
	private Long prix ;
	
	

	public Demande(Long id, String mission, String speciality, Integer anneeExp, String tmps , String etat , String commentaire , Long prix) {
		super();
		this.id = id;
		Mission = mission;
		this.speciality = speciality;
		this.anneeExp = anneeExp;
		this.tmps = tmps;
		this.etat = etat ;
		this.commentaire = commentaire  ;
		this.prix = prix ;
	}

	public Demande() {
	
	}
	/*
	@OneToMany(mappedBy = "demande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CertifDemande> certifications = new ArrayList<CertifDemande>() ;

	@OneToMany(mappedBy = "demande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FormationDemande> formations = new ArrayList<FormationDemande>() ;

	@OneToMany(mappedBy = "demande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CompSocialeDemande> compSocial = new ArrayList<CompSocialeDemande>() ;

	@OneToMany(mappedBy = "demande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CompTechDemande> compTech = new ArrayList<CompTechDemande>() ;
	
*/
}
