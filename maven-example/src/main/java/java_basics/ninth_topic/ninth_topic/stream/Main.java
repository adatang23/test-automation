package java_basics.ninth_topic.ninth_topic.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java_basics.ninth_topic.ninth_topic.enums.*;
import ninth_topic.enums.*;

public class Main {
    public static void main(String[] args) {
        // Test collection streaming findByUserType() in ninth_topic/enums/UserType
        System.out.println("Test collection streaming findByUserType():");
        String customInfor1 = "NewlyRegistered_jsmith_091024";
        String[] cust1 = customInfor1.split("_");
        UserType customType1 = UserType.findByUserType(cust1[0]);
        System.out.println(customType1 + "\n");

        // Test collection streaming in ninth_topic/enums/TransactionList
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction(TransactionMethod.BANKTRANSFER_METHOD, 100.0));
        transactionList.add(new Transaction(TransactionMethod.CREDITCARD_METHOD, 230.0));
        transactionList.add(new Transaction(TransactionMethod.BANKTRANSFER_METHOD, 360.0));
        transactionList.add(new Transaction(TransactionMethod.DEBITCARD_METHOD, 420.0));
        transactionList.add(new Transaction(TransactionMethod.CREDITCARD_METHOD, 330.0));

        // Test groupTransactionPriceByMethods() TransactionMethod: SumPrice
        System.out.println("Test collection streaming groupTransactionPriceByMethods():");
        System.out.println(TransactionList.groupTransactionPriceByMethods(transactionList));
        System.out.println("");

        // Test groupTransactionByPrice() Math.floor(price/100.0): TransactionList
        System.out.println("Test collection streaming groupTransactionByPrice():");
        Map<Double, List<Transaction>> ans = TransactionList.groupTransactionByPrice(transactionList);
        for (Map.Entry<Double, List<Transaction>> entry: ans.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("");

        // Test collection streaming sortConstructionByUnitPrice()
        // in ninth_topic/enums/SphereConstruction
        System.out.println("Test collection streaming sortConstructionByUnitPrice():");
        SphereConstruction.sortConstructionByUnitPrice();
        System.out.println("");

        // Test collection streaming findBySchedule()
        // in ninth_topic/enums/WeeklySchedule
        System.out.println("Test collection streaming findBySchedule():");
        String tempSchedule = "PRACTICE";
        WeeklySchedule day = WeeklySchedule.findBySchedule(tempSchedule);
        System.out.println("The schedule of " + day + " is " + tempSchedule + "\n");

        // Test collection streaming sortBusyDayHours()
        // in ninth_topic/enums/WeeklySchedule
        System.out.println("Test collection streaming sortBusyDayHours():");
        double hours = 0.5;
        WeeklySchedule.sortBusyDayHours(hours);
        System.out.println("");

        // Test collection streaming getSumHours()
        // in ninth_topic/enums/WeeklySchedule
        System.out.println("Test collection streaming getSumHours():");
        System.out.print("The total hours of weekly schedule are: " + WeeklySchedule.getSumHours() + "\n");
    }
}
