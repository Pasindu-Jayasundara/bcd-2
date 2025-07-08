package org.example.ee.core.mail;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import org.example.ee.core.util.Env;

import java.util.Base64;

public class VerificationMail extends Mailable{

    private String to;
    private String verificationCode;

    public VerificationMail(String to, String verificationCode) {
        this.to = to;
        this.verificationCode = verificationCode;
    }

    @Override
    public void build(Message message) throws Exception {

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Verification Mail");

        String encodeTo = Base64.getEncoder().encodeToString(to.getBytes());
        String encodeCode = Base64.getEncoder().encodeToString(verificationCode.getBytes());

        String link = Env.getProperty("application.path")+"/verify?id="+encodeTo+"&vc="+encodeCode;

        // message.setText("text message: "+verificationCode); normal text
        message.setContent(link,"text/html; charset=utf-8"); // html
    }


}
