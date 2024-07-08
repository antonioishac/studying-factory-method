package br.com.aishac.studying.domains.services.impl.csv;

import br.com.aishac.studying.domains.repositories.ContactRepository;
import br.com.aishac.studying.domains.repositories.entities.ContactEntity;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ContactCsvService implements ContactRepository {

    private static final int NAME = NumberUtils.INTEGER_ZERO;
    private static final int EMAIL = NumberUtils.INTEGER_ONE;
    private static final String ERROR_MESSAGE = "Erro lendo arquivo csv";

    private String fileName;

    @Override
    public List<ContactEntity> allContacts() {
        List<ContactEntity> contacts = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = Objects.requireNonNull(this.getClass().getResource("/" + fileName)).toURI();
            File fileCsv = new File(uri);
            FileReader fileReader = new FileReader(fileCsv);
            csvReader = new CSVReader(fileReader);
            String [] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contacts.add(new ContactEntity(nextLine[NAME].trim(), nextLine[EMAIL].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        } finally {
            try {
                assert csvReader != null;
                csvReader.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

        return contacts;
    }
}
