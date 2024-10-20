package database.db_fourth_topic.model;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "accountId", "userId", "openedDate", "balance", "branch" })
public class Account {
    @XmlElement
    @JsonProperty("accountId")
    private int accountId;

    @XmlElement
    @JsonProperty("userId")
    private int userId;

    @XmlElement
    @JsonProperty("openedDate")
    private Date openedDate;

    @XmlElement
    @JsonProperty("balance")
    private double balance;

    @XmlElement
    @JsonProperty("branch")
    private Branch branch;

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", userId='" + userId + '\'' +
                ", openedDate=" + openedDate + '\'' +
                ", balance=" + balance + '\'' +
                ", branch=" + branch + '\'' +
                '}';
    }
}
