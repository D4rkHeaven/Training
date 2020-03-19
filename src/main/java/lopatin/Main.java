package lopatin;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        DomParser parser = new DomParser();
        StaxParser staxParser = new StaxParser();
        DomWriter domWriter = new DomWriter();
        PlantRedactor plantRedactor = new PlantRedactor();
        parser.parseByDom();
        staxParser.parseByStax();
        domWriter.createXML(5);
        System.out.println( XmlValidator.validateXml("src/main/resources/book.xsd", "book.xml"));
        plantRedactor.modify("plant_catalog.xml");
    }
}

