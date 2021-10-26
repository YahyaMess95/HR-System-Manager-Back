package tn.yahyaPFE.services;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.User;

@Service
public interface UserService  {

	MessageResponse AjouterUser(User user) ;
	List<User> ListUsers() ;
	boolean ModifierUser( Long id) ;
	boolean delete(Long id ) ; 
	User findUser(String email , String password) ; 
	
	
}
