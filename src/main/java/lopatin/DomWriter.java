package lopatin;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Класс для создания XML по XSD через DOM
 */
public class DomWriter {
    public void createXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult file = new StreamResult(new File("books.xml"));
            Element rootElement = document.createElementNS("", "Books");

            rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "book.xsd");
            Node book1 = rootElement.appendChild(getBook(document));

            Node book2 = rootElement.appendChild(getBook(document));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            document.appendChild(rootElement);
            DOMSource source = new DOMSource(document);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Node getBook(Document document ) {



            Element book = document.createElement("book");
            book.appendChild(getAuthor(document));
            book.appendChild(getField(document, "pagecount", Integer.toString((int) (Math.random() * 1000))));
            book.appendChild(getField(document, "namebook", stringGen()));
            book.appendChild(getField(document, "publisher", stringGen()));


        return book;
    }
    /**
     * Метод создания автора книги
     * @param document - заполняемый документ
     *  firstname - имя
     *  lastname - фамилия
     *  secondname - отчество
     * @return автора c заполненными полями
     */
    private Node getAuthor(Document document){
        Element author = document.createElement("author");
        author.appendChild(getField(document, "firstname", stringGen()));
        author.appendChild(getField(document, "lastname", stringGen()));
        author.appendChild(getField(document, "secondname", stringGen()));
        return author;
    }

    /**
     * Метод заполнения поля документа
     * @param document - заполняемый документ
     * @param field - поле документа
     * @param value - значение поля
     * @return заполненное поле документа
     */
    private Node getField(Document document, String field, String value){
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    /**
     * Метод генерации случайной строки
     * @return строку со случайным набором букв
     */
    private String stringGen() {
        String string = "randomletters";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }
}
