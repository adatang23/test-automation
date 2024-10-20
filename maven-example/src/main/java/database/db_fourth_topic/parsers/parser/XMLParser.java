package database.db_fourth_topic.parsers.parser;
import database.db_fourth_topic.model.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {
    public Customer parseXMLCustomer(String xmlPathCustomer) throws JAXBException {
        // create JAXBContext which will be used to create a Binder
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        // unmarshaller obj to convert xml data to java content tree
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        // unmarshaller xml data to java content tree
        return (Customer) unmarshaller.unmarshal(new File(xmlPathCustomer));
    }

    public Branch parseXMLBranches(String xmlPathBranch) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Branch.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Branch) unmarshaller.unmarshal(new File(xmlPathBranch));
    }
}
