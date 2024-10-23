package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Branch;


public interface BranchMapper {
    void create(Branch branch);

    Branch findById(Integer id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllBranches();

    void deleteBranch(Branch branch);
}
