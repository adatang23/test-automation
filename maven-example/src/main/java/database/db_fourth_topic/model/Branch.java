package database.db_fourth_topic.model;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "branchId", "branchName", "address", "phone"})
public class Branch {
    @XmlElement
    @JsonProperty("branchId")
    private int branchId;

    @XmlElement
    @JsonProperty("branchName")
    private String branchName;

    @XmlElement
    @JsonProperty("address")
    private Address address;

    @XmlElement
    @JsonProperty("phone")
    private String phone;

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", address=" + address + '\'' +
                ", phone=" + phone + '\'' +
                '}';
    }
}
