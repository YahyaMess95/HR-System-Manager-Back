package tn.yahyaPFE.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.offre.Certification;
import tn.yahyaPFE.entities.offre.Formation;
import tn.yahyaPFE.entities.offre.Offre;
import tn.yahyaPFE.entities.offre.Social;
import tn.yahyaPFE.entities.offre.Technique;
import tn.yahyaPFE.repositories.offre.FormationRepository;
import tn.yahyaPFE.repositories.offre.OffreRepository;
import tn.yahyaPFE.repositories.offre.SocialRepository;
import tn.yahyaPFE.repositories.offre.TechniqueRepository;
import tn.yahyaPFE.repositories.offre.certificationRepository;
import tn.yahyaPFE.services.OffreService;
import org.springframework.stereotype.Service;
@Service
public class OffreImpl implements OffreService {

	
	@Autowired
	OffreRepository offre ; 
	
	@Autowired
	SocialRepository social ; 
	
	@Autowired
	FormationRepository formation ;
	
	@Autowired
	TechniqueRepository technique ;
	
	@Autowired
	certificationRepository certification ; 
	
	
	@Override
	public MessageResponse saveOffre(Offre offre) {
		
		this.offre.save(offre) ;
		
		return new MessageResponse(true , "Success" , "Ajouté avec succées");
	}

	@Override
	public MessageResponse saveFormation(Formation formation) {

		this.formation.save(formation);
		return new MessageResponse(true , "Success" , "Ajouté avec succées");
	}

	@Override
	public MessageResponse saveSocial(Social social) {
		this.social.save(social) ; 
		return new MessageResponse(true , "success" , "Ajouté avec succées");
	}

	@Override
	public MessageResponse saveTechnique(Technique technique) {
		this.technique.save(technique) ; 
		return new MessageResponse(true , "Success" , "Ajouté avec succées");
	}

	@Override
	public MessageResponse saveCertification(Certification certification) {
		this.certification.save(certification) ; 
		return new MessageResponse(true , "Success" , "Ajouté avec succées" ) ;
	}

	@Override
	public Optional<Offre> AfficherOffrebyId(Long id) {
		
		return offre.findById(id);
	}

	@Override
	public List<Offre> AllOffre() {
		// TODO Auto-generated method stub
		return offre.findAll();
	}

	@Override
	public List<Certification> findCertificationById(Long id) {
		// TODO Auto-generated method stub
		return certification.findCertificationByIdOffre(id);
	}

	@Override
	public List<Technique> findTechniqueById(Long id) {
		// TODO Auto-generated method stub
		return technique.findTechniqueByIdOffre(id);
	}

	@Override
	public List<Social> findSocialById(Long id) {
		// TODO Auto-generated method stub
		return social.findSocialByIdOffre(id)  ;
	}

	@Override
	public List<Formation> findFormationById(Long id) {
		// TODO Auto-generated method stub
		return formation.findFormationByIdOffre(id);
	}

	@Override
	public boolean ExistOffreById(Long id) {
		
		return offre.existsById(id);
	}
	
	///////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	


}
