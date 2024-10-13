package database.db_third_topic.bank.dao;
import java.sql.SQLException;
import database.db_third_topic.bank.model.Branch;


public interface BranchDAO extends GenericDao<Branch, Integer> {
    void create(Branch element) throws SQLException;
    Branch findById(Integer id) throws SQLException;
    void setSafeUpdates(Integer n) throws SQLException;
    void resetAutoIncrement() throws SQLException;
    void deleteAllBranches() throws SQLException;
    void deleteBranch(Branch branch) throws SQLException;
    void updateBranchPhone(Branch branch, String phone) throws SQLException;
}
