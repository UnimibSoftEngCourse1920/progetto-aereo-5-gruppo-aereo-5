package gruppoaereo5.bookBackEnd.config;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

		final String username = "gruppo5.progettoaereo@gmail.com";
        final String password = "progettoJava";
        
     
        public boolean sendEmailRegistrazione(String destinatario, String nome, String cognome) {

            Properties prop = new Properties();
    		prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(destinatario));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(destinatario)
                );
                message.setSubject("Conferma registazione");
                message.setText("Ciao " + cognome + " " +nome +"," + 
                				"La tua iscrizione è avvenuta con successo." +
                				"\n Grazie di esserti registrato al nostro servizio." +
                				"\n /n Gruppo 5 - progetto aereo");

                Transport.send(message);

                return true;

            } catch (MessagingException e) {
            	e.printStackTrace();
                return false;
            }
        }
        
        public boolean sendEmailPrenotazione(String destinatario, int codicePrenotazione) {

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(destinatario));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            message.setSubject("Conferma prenotazione");
            message.setText("Il codice della sua prenotazione è: " + codicePrenotazione +
            				"\n \n Gruppo 5 - progetto aereo");

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
        	e.printStackTrace();
            return false;
        }
    }
        
        public boolean sendEmailScadenza(String destinatario, int codicePrenotazione) {

            Properties prop = new Properties();
    		prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(destinatario));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(destinatario)
                );
                message.setSubject("Scadenza prenotazione");
                message.setText("La prenotazione con codice: " + codicePrenotazione + " sta per scadere."+
                				"\n Ricordati di effettuare il pagamento!"+
                				"\n \n Gruppo 5 - progetto aereo");

                Transport.send(message);

                return true;

            } catch (MessagingException e) {
            	e.printStackTrace();
                return false;
            }
        }
}

