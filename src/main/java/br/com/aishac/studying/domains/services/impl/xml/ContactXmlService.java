package br.com.aishac.studying.domains.services.impl.xml;

import br.com.aishac.studying.domains.repositories.ContactRepository;
import br.com.aishac.studying.domains.repositories.entities.ContactEntity;
import com.thoughtworks.xstream.XStream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactXmlService implements ContactRepository {

    private String fileName;

    @Override
    public List<ContactEntity> allContacts() {
        XStream xstream = new XStream();
        xstream.alias("contacts", List.class);
        xstream.alias("contact", ContactEntity.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<ContactEntity>) xstream.fromXML(file);
    }
}
