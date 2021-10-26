package tn.yahyaPFE.repositories.offre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.offre.Social;

public interface SocialRepository extends JpaRepository<Social, Long> {

	List<Social> findSocialByIdOffre(Long id);
}
