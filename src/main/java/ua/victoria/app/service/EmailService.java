package ua.victoria.app.service;

import ua.victoria.app.domain.mail.Mail;

public interface EmailService {

	void sendMessage(Mail mail);
}
