package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    void create(Customer customer);

    Customer findById(Integer id);

    void updateUserName(@Param("a") String userName, @Param("b") Integer customer_id);

    void updatePassword(@Param("a") String password, @Param("b") Integer customer_id);

    void updatePhone(@Param("a") String phone, @Param("b") Integer customer_id);

    void updateEmail(@Param("a") String email, @Param("b") Integer customer_id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllCustomers();

    void deleteCustomer(Customer customer);
}
