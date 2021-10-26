package tn.yahyaPFE.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class FormationDemande  implements Serializable{
	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String formation1 ;
	private String formation2 ;
	private String formation3 ;
	private String formation4 ;

	@ManyToOne
	@JoinColumn(name = "demande_id", nullable = true)
	private Demande demande ;
}
