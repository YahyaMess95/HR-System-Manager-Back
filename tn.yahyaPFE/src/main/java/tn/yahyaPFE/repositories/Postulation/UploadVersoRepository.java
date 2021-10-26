package tn.yahyaPFE.repositories.Postulation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.UploadVerso;

public interface UploadVersoRepository extends JpaRepository<UploadVerso, Long> {

	Optional<UploadVerso> findById(Long id);
	
}
