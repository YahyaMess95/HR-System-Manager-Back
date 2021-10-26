package tn.yahyaPFE.repositories.offre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.offre.Certification;

public interface certificationRepository extends JpaRepository<Certification, Long>{

	
	List<Certification> findCertificationByIdOffre(Long id );
}
