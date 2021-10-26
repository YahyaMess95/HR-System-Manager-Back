package tn.yahyaPFE.repositories.Postulation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.UploadCV;

public interface UploadCVRepository extends JpaRepository<UploadCV, Long>  {

    Optional<UploadCV> findById(Long id);
	
}
