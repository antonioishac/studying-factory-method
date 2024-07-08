package br.com.aishac.studying.domains.services.impl.xml;

import br.com.aishac.studying.domains.repositories.ContactRepository;
import br.com.aishac.studying.domains.services.impl.SendEmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SendEmailXmlService extends SendEmailService {

    private String fileName;

    @Override
    protected ContactRepository createContacts() {
        return new ContactXmlService(fileName);
    }
}