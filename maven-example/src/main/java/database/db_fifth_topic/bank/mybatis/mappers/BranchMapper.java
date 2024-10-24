package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Branch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BranchMapper {
    void create(Branch branch);

    Branch findById(Integer id);

    void updatePhone(@Param("a") String phone, @Param("b") Integer branch_id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllBranches();

    void deleteBranch(Branch branch);
}
