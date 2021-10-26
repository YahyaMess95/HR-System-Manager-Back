package tn.yahyaPFE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.offre.Certification;
import tn.yahyaPFE.entities.offre.Formation;
import tn.yahyaPFE.entities.offre.Offre;
import tn.yahyaPFE.entities.offre.Social;
import tn.yahyaPFE.entities.offre.Technique;


public interface OffreService {
	
	
	
	//add 
	public MessageResponse saveOffre(Offre offre);
	public MessageResponse saveFormation(Formation formation ) ;
	public MessageResponse saveSocial(Social social  ); 
	public MessageResponse saveTechnique(Technique technique ) ;
	public MessageResponse saveCertification(Certification certification  ) ; 
	
	
	// fetch 
	
	Optional<Offre> AfficherOffrebyId(Long id) ; 
	List<Offre> AllOffre() ; 
	
	List<Certification> findCertificationById(Long id ); 
	List<Technique> findTechniqueById(Long id);
	List<Social> findSocialById(Long id ); 
	List<Formation> findFormationById(Long id);
	boolean ExistOffreById(Long id) ;
	
	
	
	

}
