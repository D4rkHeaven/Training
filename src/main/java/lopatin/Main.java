package lopatin;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        DomParser parser = new DomParser();
        StaxParser staxParser = new StaxParser();
        DomWriter domWriter = new DomWriter();
        XmlValidator xmlValidator= new XmlValidator();
        parser.parseByDom();
        staxParser.parseByStax();
        domWriter.createXML(5);
        System.out.println( xmlValidator.validateXml("src/main/resources/book.xsd", "book.xml"));
    }
}

