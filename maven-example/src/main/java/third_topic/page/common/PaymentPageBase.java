package third_topic.page.common;

import third_topic.BasePage;

public abstract class PaymentPageBase extends BasePage {

    public abstract void addBillToPayment(String billName, double price);
    public abstract void removeBillFromPayment(String billName, double price);
}
