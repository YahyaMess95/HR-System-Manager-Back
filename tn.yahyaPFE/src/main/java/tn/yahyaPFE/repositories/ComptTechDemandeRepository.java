package tn.yahyaPFE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.CompTechDemande;
import tn.yahyaPFE.entities.Demande;

public interface ComptTechDemandeRepository extends JpaRepository<CompTechDemande, Long> {
	List<CompTechDemande> findByDemande(Demande demande);

}
