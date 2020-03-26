package lopatin;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    /**
     * Валидация XML по XSD
     *
     * @param xsdPath - Путь к XSD
     * @param xmlPath - Путь к XML
     * @return true если документ прошёл валидацию, иначе false
     */
    public static boolean validateXml(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
}
