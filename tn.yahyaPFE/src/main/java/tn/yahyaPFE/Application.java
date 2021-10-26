package tn.yahyaPFE;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;



@SpringBootApplication
@EnableAutoConfiguration(exclude = {  SecurityAutoConfiguration.class })
public class Application {
	    
	    @Autowired
	    private JavaMailSender javaMailSender;
	    
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	
	 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	  
}
