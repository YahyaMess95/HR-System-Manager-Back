package tn.yahyaPFE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.CompSocialeDemande;
import tn.yahyaPFE.entities.CompTechDemande;
import tn.yahyaPFE.entities.Demande;

public interface CompSocialDemandeRepository extends JpaRepository<CompSocialeDemande, Long>{
	List<CompSocialeDemande> findByDemande(Demande demande);
}
