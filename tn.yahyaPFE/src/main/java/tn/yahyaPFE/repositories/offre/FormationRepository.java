package tn.yahyaPFE.repositories.offre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.offre.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	List<Formation> findFormationByIdOffre(Long id);
}
