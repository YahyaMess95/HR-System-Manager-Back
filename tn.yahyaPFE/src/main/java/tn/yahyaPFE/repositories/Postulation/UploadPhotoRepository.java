package tn.yahyaPFE.repositories.Postulation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.UploadPhoto;

public interface UploadPhotoRepository extends JpaRepository<UploadPhoto, Long> {

	Optional<UploadPhoto> findById(Long id);
	
}
