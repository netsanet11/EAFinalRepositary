package edu.mum.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("sendMailExample")
public class SendMailExample {
        @Autowired
        private MailSender mailSender;
        @Autowired
        private SimpleMailMessage templateMailMessage;
        public void setSimpleMailMessage(SimpleMailMessage templateMailMessage) {
            this.templateMailMessage = templateMailMessage;
        }

        public void sendMail(String from, String to, String subject, String msg) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(msg);
            mailSender.send(simpleMailMessage);
        }
		public void sendMailWithTemplate(String dear, String content, String email) {
            SimpleMailMessage message = new SimpleMailMessage(templateMailMessage);
            message.setTo(email);
            message.setText(String.format( templateMailMessage.getText(), dear, content));
            mailSender.send(message);
			
		}
        
}
