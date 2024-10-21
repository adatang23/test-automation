package database.db_fourth_topic.parsers.validator;
import database.db_fourth_topic.model.*;
import database.db_fourth_topic.parsers.parser.JSONParser;
import database.db_fourth_topic.parsers.parser.XMLParser;
import database.db_fourth_topic.parsers.parser.SAXHandler;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.io.File;


public class Executor {
    public static void main(String[] args) {
        // SAX parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File("src/main/java/database/db_fourth_topic/parsers/xml/address.xml"), saxHandler);
            Address address = saxHandler.getAddress();
            System.out.println("SAXParser Address: " + address);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // JAXB and JSON
        String xmlPathCustomer = "src/main/java/database/db_fourth_topic/parsers/xml/customers.xml";
        String xsdPathCustomer = "src/main/java/database/db_fourth_topic/parsers/xsd/customers.xsd";
        String jsonPathCustomer = "src/main/java/database/db_fourth_topic/parsers/json/customers.json";
        // Validate XML
        try {
            if (XMLValidator.validateXMLSchema(xsdPathCustomer, xmlPathCustomer)) {
                // JAXB Parse XML
                XMLParser xmlParser = new XMLParser();
                Customer customer = xmlParser.parseXMLCustomer(xmlPathCustomer);
                System.out.println("Customer from XML: " + customer);
            }
            // JSON Jackson
            JSONParser jsonParser = new JSONParser();
            Customer customer = jsonParser.parseJSONCustomer(jsonPathCustomer);
            System.out.println("Customer from JSON: " + customer);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }

        // JAXB and JSON
        String xmlPathBranch = "src/main/java/database/db_fourth_topic/parsers/xml/branches.xml";
        String xsdPathBranch = "src/main/java/database/db_fourth_topic/parsers/xsd/branches.xsd";
        String jsonPathBranch = "src/main/java/database/db_fourth_topic/parsers/json/branches.json";
        try {
            if (XMLValidator.validateXMLSchema(xsdPathBranch, xmlPathBranch)) {
                // JAXB Parse XML
                XMLParser xmlParser = new XMLParser();
                Branch branch = xmlParser.parseXMLBranches(xmlPathBranch);
                System.out.println("Branch from XML: " + branch);
            }

            JSONParser jsonParser = new JSONParser();
            Branch branch = jsonParser.parseJSONBranches(jsonPathBranch);
            System.out.println("Branch from JSON: " + branch);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
