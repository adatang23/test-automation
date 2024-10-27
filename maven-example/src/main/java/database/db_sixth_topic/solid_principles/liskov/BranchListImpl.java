package database.db_sixth_topic.solid_principles.liskov;
import database.db_fifth_topic.bank.mybatis.model.Branch;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;

/**
 * Liskov principle:
 * Every subclass or derived class should be substitutable for their base or parent class.
 * BranchListImpl or CustomerListImpl class can be substitutable for MyObjectList interface.
 */

public class BranchListImpl <T> implements MyObjectList<T> {
    private ArrayList<T> branchArrayList = new ArrayList<>();

    @Override
    public void add(T element) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.create((Branch) element);
        }
        branchArrayList.add(element);
    }

    @Override
    public T get(int index) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            return (T) branchMapper.findById(index);
        }
    }

    @Override
    public void remove(int index) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            if (branchMapper.findById(index) != null) {
                Branch branch = branchMapper.findById(index);
                branchMapper.deleteBranch(branch);
            } else {
                System.out.println("The index is not in the table.");
            }
        }
        branchArrayList.remove(index-1);
    }

    @Override
    public int size() {
        return branchArrayList.size();
    }
}
