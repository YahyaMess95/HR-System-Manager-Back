package tn.yahyaPFE.entities.postulation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Professionel {

	@Id
	@GeneratedValue
	private Long id ;
	private String linkedin ;
	private String indeed;
	private String tanitjob ;
	private String keejob;
	private String twitter;
	private String facebook ;
	private Long idPersonel;

}
