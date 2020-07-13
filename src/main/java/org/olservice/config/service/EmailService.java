package org.olservice.config.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.olservice.config.model._Usuario;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class EmailService {

    @Inject
    Mailer mailer;

    public Response enviarEmailConfirmacao(_Usuario usuario) {
        mailer.send(Mail.withText(usuario.getEmail(), "Ativação da conta", "This is my body"));
        return Response.accepted().build();
    }

}
