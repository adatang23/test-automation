package ninth_topic.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public enum TransactionMethod {
    BANKTRANSFER_METHOD("Bank Transfer method"),
    CREDITCARD_METHOD("Credit Card method"),
    DEBITCARD_METHOD("Debit Card method"),
    CASH_METHOD("Cash method"),
    DIGITALWALLET_METHOD("Digital Wallet method"),
    MONEYORDER_METHOD("Money Order method"),
    CHECK_METHOD("Check method");

    private final String type;


    TransactionMethod(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "This is " + type;
    }

}





