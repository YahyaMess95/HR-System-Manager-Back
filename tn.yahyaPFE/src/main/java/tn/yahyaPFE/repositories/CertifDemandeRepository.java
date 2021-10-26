package tn.yahyaPFE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.CertifDemande;
import tn.yahyaPFE.entities.Demande;
import tn.yahyaPFE.entities.FormationDemande;

public interface CertifDemandeRepository extends JpaRepository<CertifDemande, Long> {
	List<CertifDemande> findByDemande(Demande demande);
}
