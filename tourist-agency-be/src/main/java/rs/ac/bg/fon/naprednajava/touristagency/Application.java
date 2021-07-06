package rs.ac.bg.fon.naprednajava.touristagency;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;

import rs.ac.bg.fon.naprednajava.touristagency.service.impl.MailService;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class Application {


	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	

	
	/*
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message");

		MailService service = new MailService(javaMailSender);
		//service.sendEmail();
		service.sendEmailWithAttachment();
		


	}
*/
}
