package tn.yahyaPFE.services.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.CompSocialeDemande;
import tn.yahyaPFE.entities.CompTechDemande;
import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.FormationDemande;
import tn.yahyaPFE.repositories.CertifDemandeRepository;
import tn.yahyaPFE.repositories.CompSocialDemandeRepository;
import tn.yahyaPFE.repositories.ComptTechDemandeRepository;
import tn.yahyaPFE.repositories.DemandeRepository;
import tn.yahyaPFE.repositories.FormationDemandeRepository;
import tn.yahyaPFE.services.RoService;
@Service
public class RoImpl implements RoService{
	
	@Autowired
	CertifDemandeRepository CDR ; 
	
	@Autowired
	CompSocialDemandeRepository CSR ; 
	
	@Autowired 
	ComptTechDemandeRepository CPTR ; 
	
	@Autowired
	DemandeRepository DM ; 
	
	@Autowired
	FormationDemandeRepository FMDR ;
	
	@Override
	public MessageResponse save(Demande demande) {
		
		DM.save(demande) ; 
	
		
		
		
		return new MessageResponse(true , "success" , "Demande ajoutée avec succés!! ");
	}

	@Override
	public List<Demande> findDemandes() {
		
		return DM.findAll();
	}

	@Override
	public MessageResponse saveFormation(FormationDemande formation ) {
		
		

		FMDR.save(formation);
		
		return new MessageResponse(true,"success","Formation Ajouté ");
	}

	@Override
	public MessageResponse saveCertification(CertifDemande certification) {

		
		CDR.save(certification) ; 
		return new MessageResponse(true,"success","Certification Ajouté ");
	}

	
	@Override
	public MessageResponse saveTechnique(CompTechDemande technique) {
		CPTR.save(technique);
		return new MessageResponse(true,"success","Competence technique Ajouté ");

	}

	@Override
	public MessageResponse saveSocial(CompSocialeDemande competenceSocial) {
		CSR.save(competenceSocial);
		return new MessageResponse(true,"success","Competence social Ajouté ");

	}

	@Override
	public List<CompTechDemande> findAllTech() {
	
		return CPTR.findAll();
	}

	@Override
	public List<CompSocialeDemande> findAllSocial() {
		// TODO Auto-generated method stub
		return CSR.findAll();
	}

	@Override
	public List<FormationDemande> findAllFormation() {
		// TODO Auto-generated method stub
		return FMDR.findAll();
	}

	@Override
	public List<CertifDemande> findAllCertification() {
		// TODO Auto-generated method stub
		return CDR.findAll();
	}

	@Override
	public List<CompTechDemande> findAllTechnique() {
		// TODO Auto-generated method stub
		return CPTR.findAll();
	}

	@Override
	public MessageResponse update(Long id, Demande demande) {
		demande.setId(id);
		DM.save(demande);
		return new MessageResponse(true , "success" , "update success");
	}

	@Override
	public Optional<Demande> findDemandeByid(Long id) {
		
		return DM.findById(id);
	}

	
	
	
	
	
}
