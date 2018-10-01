/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author julian
 */
public class TestFamilySAXParser {
    
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
