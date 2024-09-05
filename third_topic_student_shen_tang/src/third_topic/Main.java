package third_topic;

import third_topic.constant.ProjectConstant;
import third_topic.page.banktransfer.TransactionPage;

public class Main {
    public static void main(String[] args) {
        AppConfig.loadConfiguration();
        ProjectConstant.displayConfig();
        System.out.println("");

        // Calling methods in banktransfer package
        TransactionPage paymentPageBankTransfer = new TransactionPage();
        third_topic.page.banktransfer.CheckoutPage checkoutPageBankTransfer = new third_topic.page.banktransfer.CheckoutPage();
        paymentPageBankTransfer.openPage();
        paymentPageBankTransfer.setPaymentName("BankTransfer_072824");
        paymentPageBankTransfer.getTotalSaving();
        paymentPageBankTransfer.addBillToPayment(" ", -2);
        paymentPageBankTransfer.addBillToPayment("abc", -2);
        paymentPageBankTransfer.addBillToPayment("waterBill_072224", 62.3);
        paymentPageBankTransfer.addBillToPayment("electricityBill_072624", 167.9);
        paymentPageBankTransfer.removeBillFromPayment(" ", -2);
        paymentPageBankTransfer.removeBillFromPayment("abc", -2);
        paymentPageBankTransfer.removeBillFromPayment("electricityBill_072624", 167.9);
        paymentPageBankTransfer.search("cellPhoneBill_030524");
        checkoutPageBankTransfer.openPage();
        checkoutPageBankTransfer.checkOut("BankTransferAccount02");

        // Calling the static method
        ProjectConstant.incrementPaymentsCount();
        System.out.println("");

        // Calling methods in creditcardpay package
        third_topic.page.creditcardpay.TransactionPage paymentPageCreditCardPay = new third_topic.page.creditcardpay.TransactionPage();
        third_topic.page.creditcardpay.CheckoutPage checkoutPageCreditCardPay = new third_topic.page.creditcardpay.CheckoutPage();
        paymentPageCreditCardPay.openPage();
        paymentPageCreditCardPay.setPaymentName("CreditCardPay_080224");
        paymentPageCreditCardPay.addBillToPayment("mortageBill_072624", 3500.0);
        paymentPageCreditCardPay.addBillToPayment("electricityBill_072624", 167.9);
        paymentPageCreditCardPay.secure("123456");
        paymentPageCreditCardPay.timeout(true);
        checkoutPageCreditCardPay.openPage();
        checkoutPageCreditCardPay.checkOut("CreditCardAccount03");

        // Calling the static method
        ProjectConstant.incrementPaymentsCount();
        System.out.println("");

        // Calling methods in digitalwalletpay package
        third_topic.page.digitalwalletpay.TransactionPage paymentPageDigitalWalletPay = new third_topic.page.digitalwalletpay.TransactionPage();
        third_topic.page.digitalwalletpay.CheckoutPage checkoutPageDigitalWalletPay = new third_topic.page.digitalwalletpay.CheckoutPage();
        paymentPageDigitalWalletPay.openPage();
        paymentPageDigitalWalletPay.setPaymentName("DigitalWalletPay_080524");
        paymentPageDigitalWalletPay.addBillToPayment("mortageBill_072624", 3500.0);
        paymentPageDigitalWalletPay.addBillToPayment("cellPhoneBill_072724", 67.8);
        paymentPageDigitalWalletPay.addBillToPayment("internetBill_072924", 50.0);
        paymentPageDigitalWalletPay.select(new String[]{"mortageBill_072624", "cellPhoneBill_072724", "internetBill_072924"});
        paymentPageDigitalWalletPay.getTotalCredit();
        paymentPageDigitalWalletPay.setTotalCredit(5000.0);
        checkoutPageDigitalWalletPay.openPage();
        checkoutPageDigitalWalletPay.checkOut("DigitalWalletAccount02");

        // Calling the static method
        ProjectConstant.incrementPaymentsCount();
        System.out.println("");
    }
}