package database.db_fifth_topic.bank.mybatis.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int POSTGRESQL = 3;

    static Logger logger = LogManager.getLogger(MyBatisUtil.class.getName());

    private MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory(int whichFactory) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        switch(whichFactory) {
            case MYSQL:
                return new SqlSessionFactoryBuilder().build(reader, "developement");
            case ORACLE:
                return new SqlSessionFactoryBuilder().build(reader, "oracle");
            case POSTGRESQL:
                return new SqlSessionFactoryBuilder().build(reader, "postgres");
            default:
                return null;
        }
    }
}
