package tn.yahyaPFE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.yahyaPFE.dto.MessageResponse;

import tn.yahyaPFE.entities.User;
import tn.yahyaPFE.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/USER")
public class UserController {
	
	@Autowired
  private	UserService us ; 
	
	@PostMapping("/AddUser")
	public  MessageResponse SaveUser (@RequestBody User user) {
		
	
				us.AjouterUser(user) ; 
		
				return new MessageResponse(true , "utilisateur ajouté avec succées " , "bien")  ; 
	}
	
	

}
