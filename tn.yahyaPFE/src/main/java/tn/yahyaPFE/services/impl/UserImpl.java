package tn.yahyaPFE.services.impl;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.User;
import tn.yahyaPFE.repositories.UserRepository;
import tn.yahyaPFE.services.UserService;
@org.springframework.stereotype.Service
public class UserImpl implements UserService {

	@Autowired
	UserRepository us ;
	
	@Override
	public MessageResponse AjouterUser(User user) {

		
		us.save(user) ; 
		return new MessageResponse(true, "user ajouté avec succés" , " success" );
	}

	@Override
	public List<User> ListUsers() {
	
		return us.findAll() ;
	}

	@Override
	public boolean ModifierUser(Long id) {
		
		return false;
	}

	@Override
	public boolean delete(Long id) {
		us.deleteById(id);
		return true;
	}

	@Override
	public User findUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
