package tn.yahyaPFE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.yahyaPFE.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
