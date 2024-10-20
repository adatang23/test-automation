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
}
