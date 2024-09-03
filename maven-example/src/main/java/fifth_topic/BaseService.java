package fifth_topic;

import java.util.*;
import java.util.concurrent.*;

public class BaseService extends AbstractPage {
    private Map<Class<? extends PaymentPage>, PaymentPage> pageCache = new ConcurrentHashMap<>();
    private List<TransactionPage> transactionList = new ArrayList<>();
    private Stack<TransactionPage> transactionStack = new Stack<>();
    private Queue<TransactionPage> transactionQueue = new ArrayDeque<>();
    private SortedSet<Double> transactionSortedSet = new TreeSet<>();

    protected <T extends PaymentPage> T getPageInstance(Class<T> pageClass, Object... parameters) {
        return (T) pageCache.computeIfAbsent(pageClass, key -> initPage(pageClass, parameters));
    }

    private <T extends PaymentPage> T initPage(Class<T> pageClass, Object... parameters) {
        try {
            return pageClass.getDeclaredConstructor().newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize page: " + pageClass.getSimpleName(), e);
        }
    }

    protected <T> T getSynchronizedInstance(Collection<T> transactionCollection) {
        Collection<T> synchronizedTransaction = (Collection<T>) Collections.synchronizedCollection(transactionCollection);
        return (T) synchronizedTransaction;
    }

    protected <T> T getSynchronizedSortedSet(SortedSet<Double> transactionSortedSet) {
        Collection<T> synchronizedTransaction = (Collection<T>) Collections.synchronizedSortedSet(transactionSortedSet);
        return (T) synchronizedTransaction;
    }

    public Map<Class<? extends PaymentPage>, PaymentPage> getPageCache() {
        return pageCache;
    }

    public List<TransactionPage> getTransactionList() {
        return transactionList;
    }

    public Stack<TransactionPage> getTransactionStack() {
        return transactionStack;
    }

    public Queue<TransactionPage> getTransactionQueue() {
        return transactionQueue;
    }

    public SortedSet<Double> getTransactionSortedSet() {
        return transactionSortedSet;
    }
}
