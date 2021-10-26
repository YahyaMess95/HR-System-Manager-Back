package tn.yahyaPFE.repositories.offre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.el.stream.Optional;

import tn.yahyaPFE.entities.offre.Offre;

public interface OffreRepository extends JpaRepository<Offre , Long>{


	java.util.Optional<Offre> findById(Long id);
	boolean existsById(Long id );
	
}
