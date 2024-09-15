package eighth_topic.lambda;
import java.util.stream.*;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;


public class Main {
    public static void main(String[] args) {
        // 1. Use at least 5 lambda functions from the java.util.function package
        List<Integer> userTypeCounts = Arrays.asList(6,5,4,3,2,1);
        List<String> userName = Arrays.asList("jsmith03", "mbrown06", "dmiller02", "pjohnson07", "tanderson11");

        // java.util.function.Predicate;
        System.out.println("This is a test of the Predicate Interface.");
        Predicate<Integer> filterNumbers = x -> x % 2 == 0;
        userTypeCounts.stream().filter(filterNumbers).forEach(System.out::println);
        System.out.println("");

        // java.util.function.Consumer;
        System.out.println("This is a test of the Consumer Interface.");
        Consumer<Integer> plusTwo = x -> System.out.println(x+2);
        userTypeCounts.forEach(plusTwo);
        System.out.println("");

        // java.util.function.Function;
        System.out.println("This is a test of the Function Interface.");
        Function<String, Integer> length = x -> x.length();
        userName.stream().map(x -> length.apply(x)).forEach(System.out::println);
        System.out.println("");

        // java.util.function.Supplier;
        System.out.println("This is a test of the Supplier Interface.");
        Supplier<java.time.LocalDate> dateSupplier = () -> java.time.LocalDate.now();
        System.out.println(dateSupplier.get());
        System.out.println("");

        // java.util.function.UnaryOperator;
        System.out.println("This is a test of the UnaryOperator Interface.");
        UnaryOperator<String> toUpperCase = x -> x.toUpperCase();
        userName.stream().map(x -> toUpperCase.apply(x)).forEach(System.out::println);
        System.out.println("");

        // java.util.function.BinaryOperator;
        System.out.println("This is a test of the BinaryOperator Interface.");
        BinaryOperator<Integer> compare = (x, y) -> (x > y) ? 1: ((x==y) ? 0:-1);
        System.out.println(compare.apply(20, 10));
        System.out.println("");


        // 2. Create 3 custom Lambda functions with generics
        // Lambda to filter payments based on a specific method
        MethodFilter<Payment> isBankTransfer = (Payment payment) -> "BankTransfer".equals(payment.getMethod());
        // Lambda to convert currency from USD to Euro
        CurrencyConverter<Payment, Double> applyConverter = (Payment payment) -> payment.getPrice() * 0.9;
        // Lambda to check if the payment due date is before 2024-09-12
        OverdueChecker<Payment> overDueChecker = (Payment payment) -> payment.getDueDate().compareTo("2024-09-12") < 0;

        // Create payments
        Payment cellphoneBill = new Payment("CellphoneBill01", "BankTransfer",
                65.5, "2024-09-15");
        Payment waterBill = new Payment("WaterBill02", "CreditCard",
                73.8, "2024-08-31");
        Payment rent = new Payment("Rent06", "BankTransfer",
                1880.0, "2024-09-30");
        Payment electicityBill = new Payment("ElectricityBill07", "DigitalWallet",
                142.6, "2024-09-04");

        // Apply currency convertion
        double euroPrice = applyConverter.convert(rent);
        System.out.println("Price for Rent in Euro: " + euroPrice);
        System.out.println("");

        // Check payment overdue
        System.out.println("Is the cell phone bill over due? " + overDueChecker.isOverdue(cellphoneBill));
        System.out.println("Is the water bill over due? " + overDueChecker.isOverdue(waterBill));
        System.out.println("Is the rent over due? " + overDueChecker.isOverdue(rent));
        System.out.println("Is the electricity bill over due? " + overDueChecker.isOverdue(electicityBill));
        System.out.println("");

        // Filter payments by method
        List<Payment> payments = Arrays.asList(cellphoneBill, waterBill, rent, electicityBill);
        List<Payment> bankTransfers = payments.stream()
                .filter(isBankTransfer::filter)
                .collect(Collectors.toList());
        System.out.println("Number of Bank Transfers: " + bankTransfers.size());
        System.out.println("");
    }
}
