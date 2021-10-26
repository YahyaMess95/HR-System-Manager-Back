package tn.yahyaPFE.controllers;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import tn.yahyaPFE.dto.MessageResponse;
import tn.yahyaPFE.entities.User;
import tn.yahyaPFE.entities.postulation.Competence;
import tn.yahyaPFE.entities.postulation.Personnel;
import tn.yahyaPFE.entities.postulation.Professionel;
import tn.yahyaPFE.entities.postulation.UploadCV;
import tn.yahyaPFE.entities.postulation.UploadPhoto;
import tn.yahyaPFE.entities.postulation.UploadRecto;
import tn.yahyaPFE.entities.postulation.UploadVerso;
import tn.yahyaPFE.services.PostulationService;
import tn.yahyaPFE.services.UserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/Postulation")
public class PostulationController {

	static public Long idPostulation;
	@Autowired
	PostulationService ps;

	@Autowired
	  private	UserService us ; 
    
	@PostMapping("AddPerso/{id}")
	public Long AddPerso(@RequestBody Personnel pr, @PathVariable Long id) {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String formattedDate = myDateObj.format(myFormatObj);
		
		
		
		
		
		
		
		String  gouvernorat="", log="", lat="";
		float logitude=0, latitude=0;
		int index=0;
		String a = pr.getLocalisation() ;
		a = a.replaceAll(" ", "");
		index = a.indexOf("-");
		gouvernorat=a.substring(0, index);
		
		a=a.substring(index+1);
		index = a.indexOf("-");
		log=a.substring(0, index);
		logitude=(float) Float.parseFloat(log);

		lat=a.substring(index+1);
		latitude=  Float.parseFloat(lat);
		
		pr.setLogitude(latitude);
		pr.setLatitude(logitude);
		pr.setLocalisation(gouvernorat);
		
		
		
		
		
		
		
		
		pr.setTmps(formattedDate);
		ps.AddPersonnal(pr, id);
		idPostulation = pr.getId();
		return idPostulation;
	}

	@PostMapping("AddProf")
	public MessageResponse AddProf(@RequestBody Professionel pro) {

		pro.setIdPersonel(idPostulation);
		return ps.AddPro(pro);

	}

	@PostMapping("competence/technique")
	public MessageResponse Addtechnique(@RequestBody Competence cp) {
		cp.setType("technique");
		cp.setIdPersonel(idPostulation);
		return ps.AddCompetence(cp);

	}

	@PostMapping("competence/social")
	public MessageResponse Addsocial(@RequestBody Competence cp) {
		cp.setType("social");
		cp.setIdPersonel(idPostulation);
		return ps.AddCompetence(cp);

	}

	@PostMapping("competence/formation")
	public MessageResponse Addformation(@RequestBody Competence cp) {
		cp.setType("formation");
		cp.setIdPersonel(idPostulation);
		return ps.AddCompetence(cp);

	}

	@PostMapping("competence/certification")
	public MessageResponse Addcompetence(@RequestBody Competence cp) {
		cp.setType("certification");
		cp.setIdPersonel(idPostulation);
		return ps.AddCompetence(cp);

	}
	
	// CV
	public String cvPath = "CV/";

	@RequestMapping(value = "UploadCV", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file)throws IOException {
		
		int random = (int) (Math.random()*((100000000 - 10) + 1));
		File convertFile = new File(cvPath + random + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(cvPath + random + file.getOriginalFilename());
		fout.write(file.getBytes());
		UploadCV a = new UploadCV( idPostulation , random+ file.getOriginalFilename(), file.getContentType());
		ps.AddCV(a);
		fout.close();
		return new ResponseEntity<>("CV is uploaded successfully", HttpStatus.OK);
		
	}
		


	// PHOTO
		public String photoPath = "PHOTO/";

		@RequestMapping(value = "/UploadPhoto", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

		public ResponseEntity<Object> uploadphoto(@RequestParam("file") MultipartFile file)
		throws IOException {
			
			int random = (int) (Math.random()*((100000000 - 10) + 1));
			File convertFile = new File(photoPath + random + file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(photoPath + random + file.getOriginalFilename());
			fout.write(file.getBytes());
			UploadPhoto a = new UploadPhoto(idPostulation , random+ file.getOriginalFilename(), file.getContentType());
			ps.AddPhoto(a);
			fout.close();
			return new ResponseEntity<>("Photo is uploaded successfully", HttpStatus.OK);
			
		}
			



		// RECTO
			public String rectoPath = "RECTO/";

			@RequestMapping(value = "/Uploadrecto", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

			public ResponseEntity<Object> uploadrecto(@RequestParam("file") MultipartFile file)
			throws IOException {
				
				int random = (int) (Math.random()*((100000000 - 10) + 1));
				File convertFile = new File(rectoPath + random + file.getOriginalFilename());
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(rectoPath + random + file.getOriginalFilename());
				UploadRecto a = new UploadRecto(idPostulation, random+ file.getOriginalFilename(), file.getContentType());
				fout.write(file.getBytes());
				ps.AddRecto(a);
				fout.close();
				return new ResponseEntity<>("Recto is uploaded successfully", HttpStatus.OK);
				
			}
				




			// VERSO
			public String versoPath = "VERSO/";

			@RequestMapping(value = "/Uploadverso", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

			public ResponseEntity<Object> uploadverso(@RequestParam("file") MultipartFile file)
			throws IOException {
				
				int random = (int) (Math.random()*((100000000 - 10) + 1));
				File convertFile = new File(rectoPath + random + file.getOriginalFilename());
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(versoPath + random + file.getOriginalFilename());
				UploadVerso a = new UploadVerso(idPostulation, random+ file.getOriginalFilename(), file.getContentType());
				fout.write(file.getBytes());
				ps.AddVerso(a);
				fout.close();
				return new ResponseEntity<>("verso is uploaded successfully", HttpStatus.OK);
				
			}

			//************************************************************************************//
			
			
			
			
			@GetMapping("ListeCandidat")
			List<Personnel> allPersonnel(){
				
				return ps.ListPersonnel();
				
			}
			
			
			@GetMapping("findProffesionel/{id}")
		    Professionel findProffesionel(@PathVariable Long id) {
				
				return ps.findProffesionel(id);
			} 
			
			
			
			@GetMapping("findCompetence/{id}/{type}")
			List<Competence> findCompetences(@PathVariable Long id , @PathVariable String type)
			{
				return ps.findByIdPersonelANDType(id, type) ;
			}
			
			
			@GetMapping("findPhoto/{id}")
			String findphotoName(@PathVariable Long id )
			{
				return ps.findPhotoById(id).get().docName ;  
			}
			
			
			//get recto name 
			String findrecto(@PathVariable Long id )
			{
				return ps.findRectoById(id).get().docName ;  
			}
			

			//get verso name 
			String findverso(@PathVariable Long id )
			{
				return ps.findVersoById(id).get().docName ;  
			}
			
			
			@GetMapping("findPersoById/{id}")
			Optional<Personnel> findPersonel(@PathVariable Long id )  
			{
				return ps.findPersonel(id);
				
			}
			
			@Autowired
		    private JavaMailSender javaMailSender;
			@GetMapping("email/{email}/{id}")
			void sendEmail(@PathVariable String email , @PathVariable Long id) {

		        SimpleMailMessage msg = new SimpleMailMessage();
		        msg.setTo(email);
		        msg.setSubject(" Félicitation votre candidature a retenue notre attention ...");
		   
		        
		        //
		        
		        User a  = new User();
		        int Aleatoire = 1 + (int)(Math.random() * ((10000 - 1) + 1));
		        
		        
		        //
		        
		        a.setEmail(email);
		        a.setNom("");
		        a.setPassword(Aleatoire+""+getRandomStr(5));
		        
		        us.AjouterUser(a);
		        ps.postulationEnable(id) ;
		        
		        msg.setText("veuillez passer ce premier entretien\n\n"
		        		+ "le lien de connexion ... \n"
		        		+ "\n"
		        		+ "\n"
		        		+ "localhost:4200/Login\n"
		        		+ "vos coordonnées ...	\n"
		        		+ "Login : "+email
		        		+"\nMot de passe  : "+Aleatoire	 +getRandomStr(5));
		        
		        
		        javaMailSender.send(msg);

		    }

			public static String getRandomStr(int n) 
		    {
		        //choisissez un caractére au hasard à partir de cette chaîne
		        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		                    + "abcdefghijklmnopqrstuvxyz"; 
		  
		        StringBuilder s = new StringBuilder(n); 
		  
		        for (int i = 0; i < n; i++) { 
		            int index = (int)(str.length() * Math.random()); 
		            s.append(str.charAt(index)); 
		        } 
		        return s.toString(); 
		    } 

}
