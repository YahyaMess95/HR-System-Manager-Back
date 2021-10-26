package tn.yahyaPFE.services;

import java.util.List;

import java.util.Optional;

import org.jvnet.hk2.annotations.Service;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.CompSocialeDemande;
import tn.yahyaPFE.entities.CompTechDemande;
import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.FormationDemande;

public interface RoService {

  public MessageResponse save  (Demande demande  ) ;
  public MessageResponse saveFormation  (FormationDemande formation  ) ;
  public MessageResponse saveCertification  (CertifDemande certification  ) ;
  public MessageResponse saveTechnique  (CompTechDemande technique  ) ;
  public MessageResponse saveSocial  (CompSocialeDemande compétenceSocial  ) ;
  
  //////////////////////////////////////////////////////////////////////
  
  
  public List<CompTechDemande> findAllTech() ; 
  
  public List<Demande> findDemandes() ; 
  
  public Optional<Demande> findDemandeByid(Long id) ;
  
  public List<CompSocialeDemande> findAllSocial();
  
  public List<FormationDemande> findAllFormation();

  public List<CertifDemande> findAllCertification();

  public List<CompTechDemande> findAllTechnique();
  
  
  ///////////////////////////////////////////////////////////////////////////
  
  
  public MessageResponse update (Long id , Demande demande) ;
  
  
  
}
