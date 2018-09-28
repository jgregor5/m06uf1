package sax;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author julian
 */
public class FamilySAXParser extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start document   : ");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end document     : ");
    }

    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

        System.out.println("start element    : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("end element      : " + qName);
    }

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {
        System.out.println("characters : " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            InputStream xmlInput = new FileInputStream("data/family.xml");
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new FamilySAXParser();
            saxParser.parse(xmlInput, handler);

        } catch (Throwable err) {
            err.printStackTrace();
        }
    }
}
