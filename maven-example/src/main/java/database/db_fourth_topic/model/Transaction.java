package database.db_fourth_topic.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "transactionId", "fromAccountId", "toAccountId", "amount", "transactionDate" })
public class Transaction {
    @XmlElement
    @JsonProperty("transactionId")
    private int transactionId;

    @XmlElement
    @JsonProperty("fromAccountId")
    private int fromAccountId;

    @XmlElement
    @JsonProperty("toAccountId")
    private int toAccountId;

    @XmlElement
    @JsonProperty("amount")
    private double amount;

    @XmlElement
    @JsonProperty("transactionDate")
    private Date transactionDate;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId + '\'' +
                ", fromAccountId=" + fromAccountId + '\'' +
                ", toAccountId=" + toAccountId + '\'' +
                ", transactionDate=" + transactionDate + '\'' +
                "}";
    }
}
