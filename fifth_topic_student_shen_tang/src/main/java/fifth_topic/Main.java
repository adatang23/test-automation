package fifth_topic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BaseService baseService = new BaseService();

        // Test the Collection of ConcurrentHashMap
        try {
            Class pageClass1 = Class.forName("fifth_topic.BankTransferPage");
            Class pageClass2 = Class.forName("fifth_topic.CreditCardPayPage");
            Class pageClass3 = Class.forName("fifth_topic.DigitalWalletPayPage");
            Class[] parameters1 = null;
            Class[] parameters2 = null;
            Class[] parameters3 = null;
            baseService.getPageInstance(pageClass1, parameters1);
            baseService.getPageInstance(pageClass2, parameters2);
            baseService.getPageInstance(pageClass3, parameters3);
            Map<Class<? extends PaymentPage>, PaymentPage> pageCache = baseService.getPageCache();
            System.out.println("The keys and values stored in the pageCache ConcurrentHashMap are:");
            for (Map.Entry<Class<? extends PaymentPage>, PaymentPage> entry : pageCache.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                System.out.println("Key: " + key + ", Value: " + value);
            }
            System.out.println("");

            System.out.println("Test the paymentMethod() methods:");
            for (Map.Entry<Class<? extends PaymentPage>, PaymentPage> entry : pageCache.entrySet()) {
                PaymentPage valueclass = entry.getValue();
                ((PaymentPage) valueclass).paymentMethod();
            }
            System.out.println("");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        // Test the Collection of List and synchronizedCollection()
        System.out.println("Test the synchronizedCollection():");
        List<TransactionPage> transactionList = baseService.getTransactionList();
        transactionList.add(new SaleTransactionPage("SaleTransaction01", 100));
        transactionList.add(new SaleTransactionPage("SaleTransaction02", 200));
        transactionList.add(new SaleTransactionPage("SaleTransaction03", 300));
        transactionList.add(new RefundTransactionPage("RefundTransaction01", 50));
        transactionList.add(new RefundTransactionPage("RefundTransaction02", 60));
        Collection<TransactionPage> synchronizedList = (Collection<TransactionPage>) baseService.getSynchronizedInstance(transactionList);
        synchronized (synchronizedList) {
            Iterator<TransactionPage> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                iterator.next().transaction();
            }
        }
        System.out.println("");

        // Test the Collection of Stack
        System.out.println("Test the Stack:");
        Stack<TransactionPage> transactionStack = baseService.getTransactionStack();
        transactionStack.push(new SaleTransactionPage("SaleTransaction01", 100));
        transactionStack.push(new SaleTransactionPage("SaleTransaction02", 200));
        transactionStack.pop();
        transactionStack.push(new RefundTransactionPage("RefundTransaction01", 50));
        transactionStack.push(new RefundTransactionPage("RefundTransaction02", 60));
        transactionStack.pop();
        transactionStack.forEach((n) -> n.transaction());
        System.out.println("");


        // Test the Collection of Queue
        System.out.println("Test the Queue:");
        Queue<TransactionPage> transactionQueue = baseService.getTransactionQueue();
        transactionQueue.add(new SaleTransactionPage("SaleTransaction01", 100));
        transactionQueue.add(new SaleTransactionPage("SaleTransaction02", 200));
        transactionQueue.remove();
        transactionQueue.add(new RefundTransactionPage("RefundTransaction01", 50));
        transactionQueue.add(new RefundTransactionPage("RefundTransaction02", 60));
        transactionQueue.remove();
        transactionQueue.forEach((n) -> n.transaction());
        System.out.println("");


        // Test the Collection of SortedSet
        System.out.println("Test the SortedSet:");
        SortedSet<Double> transactionSortedSet = baseService.getTransactionSortedSet();
        TransactionPage transaction1 = new SaleTransactionPage("SaleTransaction01", 300);
        TransactionPage transaction2 = new SaleTransactionPage("SaleTransaction02", 200);
        TransactionPage transaction3 = new SaleTransactionPage("SaleTransaction03", 100);
        TransactionPage transaction4 = new RefundTransactionPage("RefundTransaction01", 60);
        TransactionPage transaction5 = new RefundTransactionPage("RefundTransaction02", 50);
        TransactionPage transaction6 = new RefundTransactionPage("RefundTransaction03", 40);

        transactionSortedSet.add(transaction1.getPrice());
        transactionSortedSet.add(transaction2.getPrice());
        transactionSortedSet.add(transaction3.getPrice());
        transactionSortedSet.add(transaction4.getPrice());
        transactionSortedSet.add(transaction5.getPrice());
        transactionSortedSet.add(transaction6.getPrice());
        SortedSet<Double> synchronizedSortedSet = baseService.getSynchronizedSortedSet(transactionSortedSet);
        System.out.println(synchronizedSortedSet);
        System.out.println("");


        // Test GenericLinkedList, add, addFirst, add(position, value), pop, remove
        System.out.println("Test the Generic LinkedList:");
        GenericLinkedList<Integer> list1 = new GenericLinkedList<>();
        list1.add(100);
        list1.add(200);
        list1.add(300);
        list1.addFirst(500);
        list1.add(5, 400);
        list1.pop();
        list1.remove(100);
        System.out.println(list1.toString());


        // Test GenericLinkedList with custom classes
        GenericLinkedList<PaymentPage> list2 = new GenericLinkedList<>();
        PaymentPage pay1 = new BankTransferPage();
        PaymentPage pay2 = new CreditCardPayPage();
        PaymentPage pay3 = new DigitalWalletPayPage();
        list2.add(pay1);
        list2.add(pay2);
        list2.addFirst(pay3);
        System.out.println(list2.toString());
    }
}