package tn.yahyaPFE.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.yahyaPFE.dto.DemandeDTO;
import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.CompSocialeDemande;
import tn.yahyaPFE.entities.CompTechDemande;
import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.FormationDemande;
import tn.yahyaPFE.services.OffreService;
import tn.yahyaPFE.services.RoService;
@CrossOrigin("*")
@RestController
@RequestMapping("/RO")
public class RoController {

	@Autowired
	private RoService ROS ;
	static public Long idDemande ; 
	@Autowired
	private OffreService OffService;
	public DemandeDTO a ; 
	
	@PostMapping("/addDemande")
	public MessageResponse saveDemande (@RequestBody Demande demande  )
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();
	    demande.setTmps(formatter.format(date));
	    demande.setEtat("a valider");
		ROS.save(demande) ; 
		a = new DemandeDTO(demande.getId() , demande.getMission() , demande.getSpeciality() , demande.getAnneeExp() , demande.getTmps() , demande.getEtat() , demande.getCommentaire() , demande.getPrix()) ;	
          
		return new MessageResponse(true , "Demande ajouté avec succées " , "bien")  ; 
		
	}
	
	@PostMapping("/addFormation")
	public  MessageResponse saveFormation (@RequestBody FormationDemande formation) {
		
		Demande b = new Demande(a.getId() , a.getMission() , a.getSpeciality() , a.getAnneeExp() , a.getTmps() , a.getEtat() , a.getCommentaire(),a.getPrix()) ; 
		
				formation.setDemande(b);
				ROS.saveFormation(formation);
		
				return new MessageResponse(true , "Formation ajouté avec succées " , "bien")  ; 
	}
	
	
	
	
	@PostMapping("/addCertification")
	public  MessageResponse saveCertification (@RequestBody CertifDemande certif) {
		
		Demande b = new Demande(a.getId() , a.getMission() , a.getSpeciality() , a.getAnneeExp() , a.getTmps(),a.getEtat(),a.getCommentaire(),a.getPrix()) ; 
		
				certif.setDemande(b);
				ROS.saveCertification(certif);
		
				return new MessageResponse(true , "Certification ajouté avec succées " , "bien")  ; 
	}
	
	

	@PostMapping("/addSocial")
	public  MessageResponse saveSocial (@RequestBody CompSocialeDemande Social) {
		
		Demande b = new Demande(a.getId() , a.getMission() , a.getSpeciality() , a.getAnneeExp() , a.getTmps(),a.getEtat(),a.getCommentaire(),a.getPrix()) ; 
		
				Social.setDemande(b);
				ROS.saveSocial(Social);
		
				return new MessageResponse(true , "Compétence social ajouté avec succées " , "bien")  ; 
	}
	
	@PostMapping("/addTechnique")
	public  MessageResponse saveTechnique (@RequestBody CompTechDemande Technique) {
		
		Demande b = new Demande(a.getId() , a.getMission() , a.getSpeciality() , a.getAnneeExp() , a.getTmps() , a.getEtat(),a.getCommentaire(),a.getPrix()) ; 
		
				Technique.setDemande(b);
				ROS.saveTechnique(Technique) ;
		
				return new MessageResponse(true , "Compétence technique ajouté avec succées " , "bien")  ; 
	}
	
	
	
	@GetMapping("findDemandeValider")
	List<Demande> findaValiderDemandes()
	{
		
List<Demande> a  = new ArrayList<Demande>() ; 
		
		for (int i = 0; i < ROS.findDemandes().size(); i++) {
			
			if (ROS.findDemandes().get(i).getEtat().equals("a valider")) {
				a.add(ROS.findDemandes().get(i));	
			}
			
		}
		
	return a	 ; 
		
	}
	
	
	
	@GetMapping("findDemandeValidEE")
	List<Demande> findaValidedDemandes()
	{
		
List<Demande> a  = new ArrayList<Demande>() ; 
		
		for (int i = 0; i < ROS.findDemandes().size(); i++) {
			
			if (ROS.findDemandes().get(i).getEtat().equals("accepté")) {
				a.add(ROS.findDemandes().get(i));	
			}
			
		}
		
	return a	 ; 
		
	}
	
	
	@GetMapping("findDemande")
	List<Demande> findAllDemandes()
	{
		
	return ROS.findDemandes()	 ; 
		
	}
	
	
	@GetMapping("findArchive")
	List<Demande> AffichageAccepted()
	{
		List<Demande> a  = new ArrayList<Demande>() ; 
		
		for (int i = 0; i < ROS.findDemandes().size(); i++) {
			
			if (!ROS.findDemandes().get(i).getEtat().equals("a valider")) {
				
				
				
				if (OffService.ExistOffreById(ROS.findDemandes().get(i).getId())== false) {
					a.add(ROS.findDemandes().get(i));
						
				}
				
				
				
			}
			
		}
		
	return a	 ; 
		
	}
	

	
	
	
	
	
	
	
	
	
	@GetMapping("findAccepted")
	List<Demande> AffichageAccepte()
	{
		List<Demande> a  = new ArrayList<Demande>() ; 
		
		for (int i = 0; i < ROS.findDemandes().size(); i++) {
			
			if (ROS.findDemandes().get(i).getEtat().equals("accepté")) {
				
				
				
				if (OffService.ExistOffreById(ROS.findDemandes().get(i).getId())== false) {
					a.add(ROS.findDemandes().get(i));
						
				}
				
				
				
			}
			
		}
		
	return a	 ; 
		
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("findtech/{id}")
	List<CompTechDemande> findtech(@PathVariable  int id)
	{
	
		List<CompTechDemande> a  = new ArrayList<CompTechDemande>() ; 
		for (int i = 0; i < ROS.findAllTech().size(); i++) {
			if (ROS.findAllTech().get(i).getDemande().getId().intValue()== id) {
				a.add(ROS.findAllTech().get(i))	;	
			}
		
		}
	return	a ; 
		
	}
	
	
	@GetMapping("findsocial/{id}")
	List<CompSocialeDemande> findsocial(@PathVariable  int id)
	{
	
		List<CompSocialeDemande> a  = new ArrayList<CompSocialeDemande>() ; 
		for (int i = 0; i < ROS.findAllTech().size(); i++) {
			if (ROS.findAllSocial().get(i).getDemande().getId().intValue()== id) {
				a.add(ROS.findAllSocial().get(i))	;	
			}
		
		}
	return	a ; 
		
	}
	
	@GetMapping("findcertif/{id}")
	List<CertifDemande> findCetif(@PathVariable  int id)
	{
	
		List<CertifDemande> a  = new ArrayList<CertifDemande>() ; 
		for (int i = 0; i < ROS.findAllCertification().size(); i++) {
			if (ROS.findAllCertification().get(i).getDemande().getId().intValue()== id) {
				a.add(ROS.findAllCertification().get(i))	;	
			}
		
		}
	return	a ; 
		
	}
	
	
	

	@GetMapping("findFormation/{id}")
	List<FormationDemande> findFormation(@PathVariable  int id)
	{
	
		List<FormationDemande> a  = new ArrayList<FormationDemande>() ; 
		for (int i = 0; i < ROS.findAllFormation().size(); i++) {
			if (ROS.findAllFormation().get(i).getDemande().getId().intValue()== id) {
				a.add(ROS.findAllFormation().get(i))	;	
			}
		
		}
	return	a ; 
		}
	




@GetMapping("acceptedD/{id}/{budget}")
 public MessageResponse accepter(@PathVariable Long id ,@PathVariable Long budget )
 {
	
  Demande a =	ROS.findDemandeByid(id).get() ; 
  a.setEtat("accepté");
  a.setPrix(budget);
	return ROS.update(id, a);
	
 }



@GetMapping("refusedD/{id}/{commentaire}")
public MessageResponse refuser(@PathVariable Long id , @PathVariable String commentaire  )
{
	
 Demande a =	ROS.findDemandeByid(id).get() ; 
 a.setEtat("refusé");
 a.setCommentaire(commentaire);
	return ROS.update(id, a);
	
}




}
