package database.db_sixth_topic.design_patterns.facade_pattern;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.model.Branch;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class DisplayBranch implements DisplayObject {
    @Override
    public void displayObject(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            Branch branch = branchMapper.findById(id);
            if (branch != null) {
                System.out.println("Branch's name: " + branch.getBranch_name() + '\n'
                        + "Branch's phone: " + branch.getPhone() + '\n'
                        + "Branch's address: " + branch.getAddress());
            } else {
                System.out.println("The branch is not in the table.");
            }
        }

    }
}
