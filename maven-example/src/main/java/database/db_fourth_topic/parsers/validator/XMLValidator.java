package database.db_fourth_topic.parsers.validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {
    static Logger logger = LogManager.getLogger(XMLValidator.class.getName());

    // Method to validate XML against the given XSD
    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            // Create SchemaFactory capable of understanding W3C XML Schema (XSD)
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            // Load the XSD schema file
            Schema schema = factory.newSchema(new File(xsdPath));
            // Create Validator object from the schema
            Validator validator = schema.newValidator();
            // Validate the XML file
            validator.validate(new StreamSource(new File(xmlPath)));
            logger.info("XML is valid.");
            return true;
        } catch (Exception e) {
            logger.info("XML is NOT valid. Reason: " + e.getMessage());
            return false;
        }
    }
}
