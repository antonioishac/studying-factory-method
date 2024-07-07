package br.com.aishac.studying.domains.services.impl;

import br.com.aishac.studying.domains.repositories.ContactRepository;
import br.com.aishac.studying.domains.repositories.entities.ContactEntity;
import br.com.aishac.studying.domains.services.ISendEmailService;
import java.util.List;

public abstract class SendEmailService implements ISendEmailService {

    protected abstract ContactRepository createContacts();

    @Override
    public Boolean sendEmail(String message) {
        List<ContactEntity> contacts = createContacts().allContacts();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada: ".concat(message));
        System.out.println();

        contacts.forEach( c -> {
            System.out.println("From: <contact@aishac.com.br>");
            System.out.printf("To: [%s] <%s>\n", c.name(), c.email());
            System.out.println(message);
            System.out.println();
        });

        return Boolean.TRUE;
    }
}
