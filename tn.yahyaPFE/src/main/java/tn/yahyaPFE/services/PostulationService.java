package tn.yahyaPFE.services;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.postulation.Competence;
import tn.yahyaPFE.entities.postulation.Personnel;
import tn.yahyaPFE.entities.postulation.Professionel;
import tn.yahyaPFE.entities.postulation.UploadCV;
import tn.yahyaPFE.entities.postulation.UploadPhoto;
import tn.yahyaPFE.entities.postulation.UploadRecto;
import tn.yahyaPFE.entities.postulation.UploadVerso;
import tn.yahyaPFE.repositories.Postulation.CompetenceRepository;

public interface PostulationService {


	MessageResponse AddPersonnal(Personnel p , Long id  );
	MessageResponse AddCompetence(Competence c );
	MessageResponse AddPro(Professionel p);

	MessageResponse AddPhoto(UploadPhoto up);
	MessageResponse AddRecto(UploadRecto up);
	MessageResponse AddVerso(UploadVerso up);
	MessageResponse AddCV(UploadCV up ) ;
	
	List<Personnel> ListPersonnel();
	List<Competence> findByIdPersonelANDType(Long id , String type);
	Professionel  findProffesionel ( Long id );
	Optional<UploadCV> findByCVId(Long id);
	Optional<UploadPhoto> findPhotoById(Long id);
	Optional<UploadRecto> findRectoById(Long id);
	Optional<UploadVerso> findVersoById(Long id);
	Optional<Personnel> findPersonel(Long id ) ; 
	boolean postulationEnable(Long id  ) ; 
	
	
	
	
	
	
	
	
	
}
