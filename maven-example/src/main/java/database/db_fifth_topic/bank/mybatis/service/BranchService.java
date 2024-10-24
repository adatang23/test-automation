package database.db_fifth_topic.bank.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.model.Branch;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class BranchService {
    public void create(Branch branch) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.create(branch);
        }
    }

    public Branch getBranch(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            return branchMapper.findById(id);
        }
    }

    public void updatePhone(String phone, Integer branch_id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.updatePhone(phone, branch_id);
        }
    }

    public void setSafeUpdates(Integer n) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.setSafeUpdates(n);
        }
    }

    public void resetAutoIncrement() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.resetAutoIncrement();
        }
    }

    public void deleteBranch(Branch branch) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            Integer branch_id = branch.getBranch_id();
            if (branch_id != null && branchMapper.findById(branch_id) != null) {
                branchMapper.deleteBranch(branch);
            } else {
                System.out.println("The branch_id is not in the table.");
            }
        }
    }

    public void deleteAllBranches() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.deleteAllBranches();
        }
    }
}
