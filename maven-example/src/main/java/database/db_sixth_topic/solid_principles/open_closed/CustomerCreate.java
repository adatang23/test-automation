package database.db_sixth_topic.solid_principles.open_closed;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import org.apache.ibatis.session.SqlSession;

/**
 * Open Closed principle:
 * Objects or entities should be open for extension but closed for modification.
 * The ObjectCreateBase class should be extendable without modifying the class itself.
 */

public class CustomerCreate extends ObjectCreateBase {

    @Override
    public void create(Object object) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.create((Customer) object);
        }
    }
}
