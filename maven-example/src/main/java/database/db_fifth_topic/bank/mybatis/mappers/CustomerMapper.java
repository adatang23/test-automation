package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    void create(Customer customer);

    Customer findById(Integer id);

    void updatePassword(@Param("a") String password, @Param("b") Integer customer_id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllCustomers();

    void deleteCustomer(Customer customer);
}
