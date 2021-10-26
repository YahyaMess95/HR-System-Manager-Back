package tn.yahyaPFE.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.offre.Certification;
import tn.yahyaPFE.entities.offre.Formation;
import tn.yahyaPFE.entities.offre.Offre;
import tn.yahyaPFE.entities.offre.Social;
import tn.yahyaPFE.entities.offre.Technique;
import tn.yahyaPFE.services.OffreService;
import tn.yahyaPFE.services.RoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Offre")

public class OffreController {

	@Autowired
	private OffreService OffService;

	@Autowired
	private RoService ROS;

	@PostMapping("ajouterOffre/{id}")
	MessageResponse SaveOffre(@RequestBody Offre offre , @PathVariable Long id ) {

		Offre a = new Offre();
		a.setId(id);
		a.setMission(offre.getMission());
		a.setAnneeExp(offre.getAnneeExp());
		a.setDesciption(offre.getDesciption());
		a.setIdUser(offre.getIdUser());
		a.setPrix(offre.getPrix());
		a.setSpeciality(offre.getSpeciality());
		return OffService.saveOffre(a);
	}

	@GetMapping("ajoutertechnique/{id}/{technique}")
	MessageResponse SaveOffreTechnique(@PathVariable Long id, @PathVariable String technique) {

		Technique a = new Technique(technique, id);

		return OffService.saveTechnique(a);

	}

	@GetMapping("ajouterFormation/{id}/{formation}")
	MessageResponse SaveOffreFormation(@PathVariable Long id, @PathVariable String formation) {

		Formation a = new Formation(formation, id);

		return OffService.saveFormation(a);

	}

	@GetMapping("ajouterSocial/{id}/{social}")
	MessageResponse SaveOffreSocial(@PathVariable Long id, @PathVariable String social) {

		Social a = new Social(social, id);

		return OffService.saveSocial(a);

	}

	@GetMapping("ajouterCertification/{id}/{certification}")
	MessageResponse SaveOffreCertification(@PathVariable Long id, @PathVariable String certification) {

		Certification a = new Certification(certification, id);

		return OffService.saveCertification(a);

	}

	
	//////////////////////////////

	@GetMapping("AllOffre")
	List<Offre> findAllOffre(){
		return OffService.AllOffre();
	}
	
	

	@GetMapping("OffreById/{id}")
 Optional<Offre> findOffreById(@PathVariable Long id){
		return OffService.AfficherOffrebyId(id);
	}
	
	
	@GetMapping("certificationById/{id}")
	List<Certification> findCertificationById(@PathVariable Long id)
	{
		
		return OffService.findCertificationById(id);
	}
	
	
	@GetMapping("TechniqueById/{id}")
	List<Technique> findTechniqueById(@PathVariable Long id)
	{
		
		return OffService.findTechniqueById(id);
	}
	
	@GetMapping("SocialById/{id}")
	List<Social> findSocialById(@PathVariable Long id)
	{
		
		return OffService.findSocialById(id);
	}
	
	
	@GetMapping("FormationById/{id}")
	List<Formation> findFormationById(@PathVariable Long id)
	{
		
		return OffService.findFormationById(id);
	}
	
	
	

}
