package com.canvas.config.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="email")
@RestController
public class MailController {
	@Autowired
	private JavaMailSender sender;
	/***
	 * this method is reponsible for sending introductory emails to all new 
	 * people who join the website.
	 * @param student_id
	 * @return it returns the appropriate message if the email is sent successfully or not
	 *
	 */
	@GetMapping(value = "/{student_id}")
	public String sendMail(@PathVariable("student_id") String student_id) {
		StringBuilder email = new StringBuilder(student_id);
		email = email.append(".com");
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(email.toString());
			helper.setText("Greetings from EDUCADIA");
			helper.setSubject("Discover new courses and evaluate yourself everyday");
		}catch(MessagingException e) {
			e.printStackTrace();
			return "Error while sending email .... ";
		}
		sender.send(message);
		return "Mail sent successfully";
	}

}
