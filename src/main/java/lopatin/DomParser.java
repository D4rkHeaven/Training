package lopatin;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Put content of xml file into log using DOM
 */
@Slf4j
public class DomParser {
    public void parseByDom() {
        try {
            File xmlFile = new File("plant_catalog.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            log.info(document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("PLANT");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                log.info("\n" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    log.info("COMMON: " + eElement.getElementsByTagName("COMMON").item(0).getTextContent());
                    log.info("BOTANICAL: " + eElement.getElementsByTagName("BOTANICAL").item(0).getTextContent());
                    log.info("ZONE: " + eElement.getElementsByTagName("ZONE").item(0).getTextContent());
                    log.info("LIGHT: " + eElement.getElementsByTagName("LIGHT").item(0).getTextContent());
                    log.info("PRICE: " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
                    log.info("AVAILABILITY: " + eElement.getElementsByTagName("AVAILABILITY").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
