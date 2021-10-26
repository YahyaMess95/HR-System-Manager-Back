package tn.yahyaPFE.repositories.offre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.offre.Technique;

public interface TechniqueRepository extends JpaRepository<Technique, Long> {

	List<Technique> findTechniqueByIdOffre(Long id);
	
}
