package database.db_fifth_topic.bank.mybatis.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {

    static Logger logger = LogManager.getLogger(MyBatisUtil.class.getName());

    private MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return new SqlSessionFactoryBuilder().build(reader);
    }
}
