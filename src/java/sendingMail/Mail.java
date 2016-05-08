/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendingMail;

import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Aleksandra
 */
@ManagedBean(name = "mail")
@RequestScoped

public class Mail implements Serializable {

    private String header;
    private String name;
    private String mailAddress;
    private String contain;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public void sendMail() {
        final String username = "defto94@gmail.com";
        final String password = "alekssandra";
        Properties properities = new Properties();
        properities.put("mail.smtp.auth", "true");
        properities.put("mail.smtp.starttls.enable", "true");
        properities.put("mail.smtp.host", "smtp.gmail.com");
        properities.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properities,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("defto94@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("defto94@gmail.com"));
            message.setSubject("Żeby zdrowo żyć");
            //message.setText("FROM: " + name + "<br/>" + mailAddress + " " + header + " " + contain);
            message.setContent(
                    "<b>Od: </b>" + name + ", <b>adres e-mail: </b>" + mailAddress + "<br/> "
                    + "<b>Temat: </b>" + header + "<br/>"
                    + "<b>Wiadomosc: </b>" + contain + "<br/>", "text/html");
            Transport.send(message);
        } catch (MessagingException me) {
            throw new RuntimeException(me);
        }
    } 
}
