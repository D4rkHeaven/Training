package lopatin;

import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * Put content of xml file into log using STAX
 */
@Slf4j
public class StaxParser {
    public void parseByStax() throws FileNotFoundException, XMLStreamException {

        File file = new File("plant_catalog.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));

        while (streamReader.hasNext()) {
            streamReader.next();
            if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
                if (streamReader.getLocalName().equalsIgnoreCase("plant")) {
                    log.info("PLANT");
                }
                if (streamReader.getLocalName().equalsIgnoreCase("common")) {
                    log.info("COMMON: " + streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("botanical")) {
                    log.info("BOTANICAL: " + streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("zone")) {
                    log.info("ZONE: " + streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("light")) {
                    log.info("LIGHT: " + streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("price")) {
                    log.info("PRICE: " + streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("availability")) {
                    log.info("AVAILABILITY: " + streamReader.getElementText());
                }
            }
        }
    }
}
