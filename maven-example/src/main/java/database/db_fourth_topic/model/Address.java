package database.db_fourth_topic.model;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "city", "street", "zipCode" })
public class Address {
    @XmlElement
    @JsonProperty("city")
    private String city;

    @XmlElement
    @JsonProperty("street")
    private String street;

    @XmlElement
    @JsonProperty("zipCode")
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                "}";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
