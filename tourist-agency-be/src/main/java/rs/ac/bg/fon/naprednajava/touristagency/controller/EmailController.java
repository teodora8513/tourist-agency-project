package rs.ac.bg.fon.naprednajava.touristagency.controller;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.naprednajava.touristagency.email.EmailMessage;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.MailService;
	
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/email")
public class EmailController {

	    private final MailService mailService;

	    public EmailController(MailService mailService){
	        this.mailService = mailService;
	    }

	    @PostMapping("/send")
	    public String sendEmail(@RequestBody EmailMessage emailMessage){
	        mailService.sendEmail(emailMessage.getToAddress(), emailMessage.getSubject(), emailMessage.getBodySubject());
	       // mailService.sendEmailWithAttachment();
	        
	        return "\"{\"message\" : \"Email is sent\"}\"";
	    }
	    
	    
	}


