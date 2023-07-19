package com.sendmail.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnviarCorreo {
    @Autowired
    private JavaMailSender mail;

    @PostMapping("enviarCorreoCron")
    public ResponseEntity<?> enviar_correo(){
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo("hostjosealberto@outlook.com");
        email.setFrom("aramirez@ahio.com.mx");
        email.setSubject("SEND MAIL AHIO");
        email.setText("MAIL FROM BACKEND DEV");

        mail.send(email);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
