package rs.ac.bg.fon.naprednajava.touristagency.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Slanje mejla bez slike
     * @param toAddress
     * @param subject
     * @param bodyText
     * @throws MailException
     */
    public void sendEmail( String toAddress, String subject, String bodyText) throws MailException {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(bodyText);

        javaMailSender.send(msg);
    }
    /**
     * Slanje mejla sa slikom
     * @throws MessagingException
     * @throws IOException
     */
    public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("jevtic.teodora@gmail.com");

        helper.setSubject("My traveling reservation");

        helper.setText("<h1>Thank you for making your reservation! </h1>", true);

        helper.addAttachment("travel.jpg", new PathResource("tourist-agency-be/src/main/resources/travel.jpg"));

        javaMailSender.send(msg);

    }

}
