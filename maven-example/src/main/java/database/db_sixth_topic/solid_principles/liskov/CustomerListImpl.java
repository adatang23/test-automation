package database.db_sixth_topic.solid_principles.liskov;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;

/**
 * Liskov principle:
 * Every subclass or derived class should be substitutable for their base or parent class.
 * BranchListImpl or CustomerListImpl class can be substitutable for MyObjectList interface.
 */

public class CustomerListImpl <T> implements MyObjectList<T> {
    private ArrayList<T> customerArrayList = new ArrayList<>();

    @Override
    public void add(T element) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.create((Customer) element);
        }
        customerArrayList.add(element);
    }

    @Override
    public T get(int index) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            return (T) customerMapper.findById(index);
        }
    }

    @Override
    public void remove(int index) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            if (customerMapper.findById(index) != null) {
                Customer customer = customerMapper.findById(index);
                customerMapper.deleteCustomer(customer);
            } else {
                System.out.println("The index is not in the table.");
            }
        }
        customerArrayList.remove(index-1);
    }

    @Override
    public int size() {
        return customerArrayList.size();
    }
}
