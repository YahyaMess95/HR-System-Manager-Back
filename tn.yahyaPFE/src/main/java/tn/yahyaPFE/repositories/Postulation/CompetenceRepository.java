package tn.yahyaPFE.repositories.Postulation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.postulation.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {

	List <Competence> findByIdPersonelAndType(Long id , String type ) ; 
	
}
