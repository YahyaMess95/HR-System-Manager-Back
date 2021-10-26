package tn.yahyaPFE.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.Demande;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
	   Optional<Demande> findById(Long id );
	  
}
