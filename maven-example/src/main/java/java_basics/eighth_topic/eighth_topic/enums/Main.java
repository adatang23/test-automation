package java_basics.eighth_topic.eighth_topic.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class MonthTest {
    static {
        // Generate a monthlist
        List<Month> monthList = new ArrayList<>();
        for (Month m: Month.values()) {
            monthList.add(m);
        }

        // Calculate the number of days in a common year
        System.out.println("This is a test of the Month enum:");
        System.out.println("The number of days in a common year is: "
                + monthList.stream().mapToInt(i -> i.getDay()).sum() + "\n");
    }
}

class SphereConstructionTest {
    // Test the SphereConstruction enum with Fields, Methods, and a static Block
    static {
        String constructionName = null;
        double maxUnitPrice = 0;
        System.out.println("This is a test of the SphereConstruction enum:");
        for (SphereConstruction s: SphereConstruction.values()) {
            double currentUnitPrice = s.calculateUnitPrice();
            System.out.printf("The calculated unit price of %s is %.2f dollars/m3\n", s, currentUnitPrice);
            if (currentUnitPrice > maxUnitPrice) {
                constructionName = s.name();
                maxUnitPrice = currentUnitPrice;
            }
        }
        if (constructionName != null) {
            System.out.printf(constructionName + " has the largest unitPrice: %.2f dollars/m3\n", maxUnitPrice);
        }
    }
}


class TransactionTest {
    // Test the TransactionMethod enum with Fields, Methods, and a static Block
    static {
        System.out.println("This is a test of the TransactionMethod enum:");
        Transaction bankTransfer = new Transaction(TransactionMethod.BANKTRANSFER_METHOD, 100.0);
        bankTransfer.tellTransactionResult();
        Transaction creditCard = new Transaction(TransactionMethod.CREDITCARD_METHOD, 2000.0);
        creditCard.tellTransactionResult();
        Transaction debitCart = new Transaction(TransactionMethod.DEBITCARD_METHOD, 500.0);
        debitCart.tellTransactionResult();
        Transaction cash = new Transaction(TransactionMethod.CASH_METHOD, 800.0);
        cash.tellTransactionResult();
        Transaction digitalWallet = new Transaction(TransactionMethod.DIGITALWALLET_METHOD, 3000.0);
        digitalWallet.tellTransactionResult();
        Transaction moneyOrder = new Transaction(TransactionMethod.MONEYORDER_METHOD, 400);
        moneyOrder.tellTransactionResult();
        Transaction check = new Transaction(TransactionMethod.CHECK_METHOD, 5000);
        check.tellTransactionResult();
        System.out.println("");
    }
}

class UserTest {
    // Test the UserType enum with Fields, Methods, and a static Block
    static {
        System.out.println("This is a test of the UserType enum:");
        for (UserType userType: UserType.values()) {
            System.out.println(userType.toString());
        }
    }
}

class WeeklyScheduleTest {
    // Test the WeeklySchedule enum with Fields, Methods, and a static Block
    static {
        List<WeeklySchedule> weeklyScheduleList = new ArrayList<>();

        // Test the tellDailySchedule() method
        System.out.println("This is a test of the WeeklySchedule enum:");
        for (WeeklySchedule w: WeeklySchedule.values()) {
            WeeklyScheduleDay dayTest = new WeeklyScheduleDay(w);
            dayTest.tellDailySchedule();
            weeklyScheduleList.add(w);
        }
        System.out.println("");

        // Select the days with a schedule > 0 hours
        Predicate<WeeklySchedule> busySchedule = x -> x.getHours() > 0;
        System.out.println("The days with a busy schedule: ");
        weeklyScheduleList.stream().filter(busySchedule).forEach(System.out::println);
        System.out.println("");
    }
}



public class Main {
    public static void main(String[] args) {
        // 3. Create 5 complex Enums(with fields, methods, blocks)
        // Test the Month enum with Fields, Methods, and a static Block
        new MonthTest();
        System.out.println("");

        // Test the Planet enum with Fields, Methods, and a static Block
        new SphereConstructionTest();
        System.out.println("");

        // Test the TransactionMethod enum with Fields, Methods, and a static Block
        new TransactionTest();
        System.out.println("");

        // Test the UserType enum with Fields, Methods, and a static Block
        new UserTest();
        System.out.println("");

        // Test the WeeklySchedule enum with Fields, Methods, and a static Block
        new WeeklyScheduleTest();
        System.out.println("");
    }
}
