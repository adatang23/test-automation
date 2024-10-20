package database.db_fourth_topic.parsers.validator;
import database.db_fourth_topic.model.*;
import database.db_fourth_topic.parsers.parser.JSONParser;
import database.db_fourth_topic.parsers.parser.XMLParser;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Executor {
    public static void main(String[] args) {
        String xmlPathCustomer = "src/main/java/database/db_fourth_topic/parsers/xml/customers.xml";
        String xsdPathCustomer = "src/main/java/database/db_fourth_topic/parsers/xsd/customers.xsd";
        String jsonPathCustomer = "src/main/java/database/db_fourth_topic/parsers/json/customers.json";
        // Validate XML
        try {
            if (XMLValidator.validateXMLSchema(xsdPathCustomer, xmlPathCustomer)) {
                // Parse XML
                XMLParser xmlParser = new XMLParser();
                Customer customer = xmlParser.parseXMLCustomer(xmlPathCustomer);
                System.out.println("Customer from XML: " + customer);
            }

            JSONParser jsonParser = new JSONParser();
            Customer customer = jsonParser.parseJSONCustomer(jsonPathCustomer);
            System.out.println("Customer from JSON: " + customer);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }

        String xmlPathBranch = "src/main/java/database/db_fourth_topic/parsers/xml/branches.xml";
        String xsdPathBranch = "src/main/java/database/db_fourth_topic/parsers/xsd/branches.xsd";
        String jsonPathBranch = "src/main/java/database/db_fourth_topic/parsers/json/branches.json";

        try {
            if (XMLValidator.validateXMLSchema(xsdPathBranch, xmlPathBranch)) {
                // Parse XML
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
