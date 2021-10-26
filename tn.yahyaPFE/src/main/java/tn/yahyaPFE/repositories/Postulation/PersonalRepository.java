package tn.yahyaPFE.repositories.Postulation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.Personnel;

public interface PersonalRepository extends JpaRepository<Personnel, Long>{

	 Optional<Personnel> findById(Long id) ;  
	
}
