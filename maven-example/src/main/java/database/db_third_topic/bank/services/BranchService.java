package database.db_third_topic.bank.services;
import java.sql.*;
import database.db_third_topic.bank.dao.BranchDAO;
import database.db_third_topic.bank.exception.DAOException;
import database.db_third_topic.bank.factory.DAOFactory;
import database.db_third_topic.bank.model.Branch;


public class BranchService {
    private final BranchDAO branchDAO;

    public BranchService(DAOFactory daoFactory) throws DAOException {
        this.branchDAO = daoFactory.getBranchDAO();
    }

    public void createBranch(Branch branch) throws SQLException {
        branchDAO.create(branch);
    }

    public void updateBranchPhone(Branch branch, String phone) throws SQLException {
        branchDAO.updateBranchPhone(branch, phone);
    };

    public void resetAutoIncrement() throws SQLException {
        branchDAO.resetAutoIncrement();
    }

    public void setSafeUpdates(Integer n) throws SQLException{
        branchDAO.setSafeUpdates(n);
    }

    public void deleteAllBranches() throws SQLException {
        branchDAO.deleteAllBranches();
    }

    public void deleteBranch(Branch branch) throws SQLException {
        branchDAO.deleteBranch(branch);
    }

    public Branch getBranch(Integer id) throws SQLException {
        return branchDAO.findById(id);
    }
}
