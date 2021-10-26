package tn.yahyaPFE.repositories.Postulation;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.Professionel;

public interface ProfessionalRepository extends JpaRepository<Professionel, Long> {

	Professionel findByIdPersonel(Long idPersonel);
	
	
	
}
