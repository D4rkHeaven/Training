package lopatin;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        DomParser parser = new DomParser();
        parser.parseByDom();
        StaxParser staxParser = new StaxParser();
        staxParser.parseByStax();
    }
}

