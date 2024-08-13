public class Main {
    public static void main(String[] args) {
        Payment bankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024", 63.2, "Bank of America");
        Payment creditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024", 85, "2442977812");
        Payment digitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024", 102, "PayPal");

        System.out.println(bankerTransfer.toString());
        System.out.println(creditCardPay.toString());
        System.out.println(digitalWalletPay.toString());

        Payment newBankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024", 63.2, "Bank of America");
        System.out.println("Are the hash code of bankerTransfer and newBankerTransfer the same? " +
                (bankerTransfer.hashCode() == newBankerTransfer.hashCode()));
        System.out.println("Are the object bankerTransfer and the object newBankerTransfer equal? " +
                (bankerTransfer.equals(newBankerTransfer)));

        Payment newCreditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024", 85, "2442977812");
        System.out.println("Are the hash code of creditCardPay and newCreditCardPay the same? " +
                (creditCardPay.hashCode() == newCreditCardPay.hashCode()));
        System.out.println("Are the object creditCardPay and the object newCreditCardPay equal? " +
                (creditCardPay.equals(newCreditCardPay)));

        Payment newDigitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024", 102, "PayPal");
        System.out.println("Are the hash code of digitalWalletPay and newDigitalWalletPay the same? " +
                (digitalWalletPay.hashCode() == newDigitalWalletPay.hashCode()));
        System.out.println("Are the object digitalWalletPay and object newDigitalWalletPay equal? " +
                (digitalWalletPay.equals(newDigitalWalletPay)));
    }
}