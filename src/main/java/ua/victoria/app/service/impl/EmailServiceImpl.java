package ua.victoria.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ua.victoria.app.domain.mail.Mail;
import ua.victoria.app.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired 
	private JavaMailSender mailSender;
	
	@Override
	public void sendMessage(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		mailSender.send(message);
	}

}
