package third_topic;

import third_topic.constant.ProjectConstant;
import third_topic.page.banktransfer.*;
import third_topic.page.banktransfer.PaymentPage;
import third_topic.page.creditcardpay.*;
import third_topic.page.creditcardpay.CheckoutPage;
import third_topic.page.digitalwalletpay.*;

import java.lang.module.Configuration;

public class Main {
    public static void main(String[] args) {
        AppConfig.loadConfiguration();
        ProjectConstant.displayConfig();
        System.out.println("");
        // Calling methods in banktransfer package
        PaymentPage paymentPageBankTransfer = new PaymentPage();
        third_topic.page.banktransfer.CheckoutPage checkoutPageBankTransfer = new third_topic.page.banktransfer.CheckoutPage();
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
        third_topic.page.creditcardpay.PaymentPage paymentPageCreditCardPay = new third_topic.page.creditcardpay.PaymentPage();
        CheckoutPage checkoutPageCreditCardPay = new CheckoutPage();
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
        third_topic.page.digitalwalletpay.PaymentPage paymentPageDigitalWalletPay = new third_topic.page.digitalwalletpay.PaymentPage();
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