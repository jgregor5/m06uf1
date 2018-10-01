package sax.employee;

/**
 *
 * @author julian
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class EmployeesSAXParser {

    public static void main(String[] args) {

        // get the SAX factory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            // build the parser from the factory
            SAXParser saxParser = saxParserFactory.newSAXParser();
            
            // build the handler
            EmployeesHandler handler = new EmployeesHandler(true);
            
            // parse
            saxParser.parse(new File("data/employees.xml"), handler);
            
            // list employees
            List<Employee> empList = handler.getEmpList();
            for (Employee emp : empList) {
                System.out.println(emp);
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
