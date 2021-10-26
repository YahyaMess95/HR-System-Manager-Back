package tn.yahyaPFE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.FormationDemande;

public interface FormationDemandeRepository extends JpaRepository<FormationDemande, Long> {

	List<FormationDemande> findByDemande(Demande demande);
	
	
}
