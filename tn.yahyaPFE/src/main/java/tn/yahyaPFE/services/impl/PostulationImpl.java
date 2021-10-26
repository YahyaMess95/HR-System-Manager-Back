package tn.yahyaPFE.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.postulation.Competence;
import tn.yahyaPFE.entities.postulation.Personnel;
import tn.yahyaPFE.entities.postulation.Professionel;
import tn.yahyaPFE.entities.postulation.UploadCV;
import tn.yahyaPFE.entities.postulation.UploadPhoto;
import tn.yahyaPFE.entities.postulation.UploadRecto;
import tn.yahyaPFE.entities.postulation.UploadVerso;
import tn.yahyaPFE.repositories.Postulation.CompetenceRepository;
import tn.yahyaPFE.repositories.Postulation.PersonalRepository;
import tn.yahyaPFE.repositories.Postulation.ProfessionalRepository;
import tn.yahyaPFE.repositories.Postulation.UploadCVRepository;
import tn.yahyaPFE.repositories.Postulation.UploadPhotoRepository;
import tn.yahyaPFE.repositories.Postulation.UploadRectoRepository;
import tn.yahyaPFE.repositories.Postulation.UploadVersoRepository;
import tn.yahyaPFE.services.PostulationService;
@Service
public class PostulationImpl implements PostulationService {

	@Autowired
	CompetenceRepository cr;

	@Autowired
	PersonalRepository pr;

	@Autowired
	ProfessionalRepository pf;

	@Autowired
	UploadCVRepository ucv;

	@Autowired
	UploadPhotoRepository photo;

	@Autowired
	UploadRectoRepository recto;

	@Autowired
	UploadVersoRepository verso;

	@Override
	public MessageResponse AddPersonnal(Personnel p , Long id ) {

		p.setIdOffre(id);
		pr.save(p);
		return new MessageResponse(true, "infos perso ajouté avec succées", "succées");
	}

	@Override
	public MessageResponse AddCompetence(Competence c) {
		cr.save(c);
		return new MessageResponse(true, "competence ajouté avec succées", "succées");

	}

	@Override
	public MessageResponse AddPro(Professionel p) {
		
		pf.save(p);
		return new MessageResponse(true, "proffesionel ajouté avec succées", "succées");
	}

	@Override
	public MessageResponse AddPhoto(UploadPhoto up) {

		photo.save(up);
		return new MessageResponse(true, "Image ajouté avec succées", "succées");
	}

	@Override
	public MessageResponse AddRecto(UploadRecto up) {
		recto.save(up);
		return new MessageResponse(true, "Recto ajouté avec succées", "succées");
	}

	@Override
	public MessageResponse AddVerso(UploadVerso up) {
		verso.save(up);
		return new MessageResponse(true, "Verso ajouté avec succées", "succées");
	}

	@Override
	public MessageResponse AddCV(UploadCV up) {
		ucv.save(up);
		return new MessageResponse(true, "cv ajouté avec succées", "succées");
	}

	@Override
	public List<Personnel> ListPersonnel() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Competence> findByIdPersonelANDType(Long id, String type) {
		// TODO Auto-generated method stub
		return cr.findByIdPersonelAndType(id, type);
	}

	@Override
	public Professionel findProffesionel(Long id) {
		// TODO Auto-generated method stub
		return  pf.findByIdPersonel(id);
	}

	@Override
	public Optional<UploadCV> findByCVId(Long id) {
		// TODO Auto-generated method stub
		return ucv.findById(id);
	}

	@Override
	public Optional<UploadPhoto> findPhotoById(Long id) {
		// TODO Auto-generated method stub
		return photo.findById(id);
	}

	@Override
	public Optional<UploadRecto> findRectoById(Long id) {
		// TODO Auto-generated method stub
		return recto.findById(id);
	}

	@Override
	public Optional<UploadVerso> findVersoById(Long id) {
		// TODO Auto-generated method stub
		return verso.findById(id);
	}

	@Override
	public Optional<Personnel> findPersonel(Long id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}

	@Override
	public boolean postulationEnable(Long id ) {

	Personnel	per = new Personnel()  ; 
		per=	pr.findById(id).get() ; 
		per.setId(id);
		per.setEtat("enabled");
		pr.save(per);
		
		return true;
	}

}
