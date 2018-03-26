package tw.com.pai.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IMailService {

	public void htmlFormEmailSender(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException, MessagingException;
}
