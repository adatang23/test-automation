package java_basics.third_topic.third_topic.page.common;

import java_basics.third_topic.third_topic.BasePage;

public abstract class TransactionPageBase extends BasePage {

    public abstract void addBillToPayment(String billName, double price);
    public abstract void removeBillFromPayment(String billName, double price);
}
