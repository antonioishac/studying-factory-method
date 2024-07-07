package br.com.aishac.studying.domains.repositories;

import br.com.aishac.studying.domains.repositories.entities.ContactEntity;
import java.util.List;

public interface ContactRepository {

    List<ContactEntity> allContacts();
}
