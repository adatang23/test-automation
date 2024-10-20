package database.db_fourth_topic.model;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;
import java.util.Date;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "id", "name", "password", "dob", "address", "accounts", "transactions"})
public class Customer {
    @XmlElement
    @JsonProperty("id")
    private int id;

    @XmlElement
    @JsonProperty("name")
    private String name;

    @XmlElement
    @JsonProperty("password")
    private String password;

    @XmlElement
    @JsonProperty("dob")
    private Date dob;

    @XmlElement
    @JsonProperty("address")
    private Address address;

    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
    @JsonProperty("accounts")
    private List<Account> accounts;

    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    @JsonProperty("transactions")
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob + '\'' +
                ", address=" + address + '\'' +
                ", accounts=" + accounts + '\'' +
                ", transactions=" + transactions + '\'' +
                '}';
    }
}
