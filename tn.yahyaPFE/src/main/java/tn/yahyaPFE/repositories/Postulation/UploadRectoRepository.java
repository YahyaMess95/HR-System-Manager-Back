package tn.yahyaPFE.repositories.Postulation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.UploadRecto;

public interface UploadRectoRepository extends JpaRepository<UploadRecto, Long> {

	Optional<UploadRecto> findById(Long id);
	
}
