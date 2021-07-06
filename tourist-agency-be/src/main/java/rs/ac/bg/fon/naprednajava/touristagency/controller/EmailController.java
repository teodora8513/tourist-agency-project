package rs.ac.bg.fon.naprednajava.touristagency.controller;



import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.naprednajava.touristagency.email.EmailMessage;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.MailService;
	
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/email")
public class EmailController {

	    private MailService mailService;

	    @Autowired
	    public EmailController(MailService mailService){
	        this.mailService = mailService;
	    }

	    @PostMapping("/send")
	    public String sendEmail(@RequestBody EmailMessage emailMessage) throws MessagingException, IOException{
	        //mailService.sendEmail(emailMessage.getToAddress(), emailMessage.getSubject(), emailMessage.getBodySubject());
	      mailService.sendEmailWithAttachment();
	        
	        return "\"{\"message\" : \"Email is sent\"}\"";
	    }
	    
	    
	}

