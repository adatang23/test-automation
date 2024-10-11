package java_basics.third_topic.third_topic;

import java_basics.third_topic.third_topic.page.digitalwalletpay.CheckoutPage;
import java_basics.third_topic.third_topic.page.digitalwalletpay.TransactionPage;
import java_basics.third_topic.third_topic.constant.ProjectConstant;

public class Main {
    public static void main(String[] args) {
        AppConfig.loadConfiguration();
        ProjectConstant.displayConfig();
        System.out.println("");
        // Calling methods in banktransfer package
        java_basics.third_topic.third_topic.page.banktransfer.TransactionPage paymentPageBankTransfer = new java_basics.third_topic.third_topic.page.banktransfer.TransactionPage();
        java_basics.third_topic.third_topic.page.banktransfer.CheckoutPage checkoutPageBankTransfer = new java_basics.third_topic.third_topic.page.banktransfer.CheckoutPage();
        paymentPageBankTransfer.openPage();
        paymentPageBankTransfer.setPaymentName("BankTransfer_072824");
        paymentPageBankTransfer.getTotalSaving();
        paymentPageBankTransfer.addBillToPayment("waterBill_072224", 62.3);
        paymentPageBankTransfer.addBillToPayment("electricityBill_072624", 167.9);
        paymentPageBankTransfer.removeBillFromPayment("electricityBill_072624", 167.9);
        paymentPageBankTransfer.search("cellPhoneBill_030524");
        checkoutPageBankTransfer.openPage();
        checkoutPageBankTransfer.checkOut("BankTransferAccount02");
        // Calling the static method
        ProjectConstant.incrementPaymentsCount();
        System.out.println("");

        // Calling methods in creditcardpay package
        java_basics.third_topic.third_topic.page.creditcardpay.TransactionPage paymentPageCreditCardPay = new java_basics.third_topic.third_topic.page.creditcardpay.TransactionPage();
        java_basics.third_topic.third_topic.page.creditcardpay.CheckoutPage checkoutPageCreditCardPay = new java_basics.third_topic.third_topic.page.creditcardpay.CheckoutPage();
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
        TransactionPage paymentPageDigitalWalletPay = new TransactionPage();
        CheckoutPage checkoutPageDigitalWalletPay = new CheckoutPage();
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

        // Test the isValidBill(), addBillToPayment(), and removeBillFromPayment() in TransactionPage.java
        // in banktransfer, creditcardpay, and digitialwalletpay packages
        System.out.println("This is a validation test.");
        java_basics.third_topic.third_topic.page.banktransfer.TransactionPage BankTransfer = new java_basics.third_topic.third_topic.page.banktransfer.TransactionPage();
        java_basics.third_topic.third_topic.page.creditcardpay.TransactionPage CreditCardPay = new java_basics.third_topic.third_topic.page.creditcardpay.TransactionPage();
        TransactionPage DigitalWalletPay = new TransactionPage();
        BankTransfer.addBillToPayment("", -8.0);
        BankTransfer.removeBillFromPayment("bill", -10);
        CreditCardPay.addBillToPayment("bill", -12.0);
        CreditCardPay.removeBillFromPayment("", -3.0);
        DigitalWalletPay.addBillToPayment("", -6.0);
        DigitalWalletPay.removeBillFromPayment("bill", -20.0);
    }
}