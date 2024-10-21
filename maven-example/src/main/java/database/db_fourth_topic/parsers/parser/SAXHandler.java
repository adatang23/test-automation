package database.db_fourth_topic.parsers.parser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import database.db_fourth_topic.model.*;

public class SAXHandler extends DefaultHandler {
    private Address address = null;
    private StringBuilder data = null;
    boolean bCity = false;
    boolean bStreet = false;
    boolean bZipCode = false;

    public Address getAddress() {
        return address;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("Address")) {
            address = new Address();
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("street")) {
            bStreet = true;
        } else if (qName.equalsIgnoreCase("zipCode")) {
            bZipCode = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException {
        if (bCity) {
            address.setCity(data.toString());
            bCity = false;
        } else if (bStreet) {
            address.setStreet(data.toString());
            bStreet = false;
        } else if (bZipCode) {
            address.setZipCode(data.toString());
            bZipCode = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
