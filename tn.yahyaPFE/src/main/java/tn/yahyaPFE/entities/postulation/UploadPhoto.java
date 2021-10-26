package tn.yahyaPFE.entities.postulation;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UploadPhoto {

	@Id
	public Long id ;
	
	
	public String docName ; 
	public String docType ;
}
