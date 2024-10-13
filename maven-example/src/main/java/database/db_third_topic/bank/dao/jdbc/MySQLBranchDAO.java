package database.db_third_topic.bank.dao.jdbc;
import database.db_third_topic.bank.connection.DBConnection;
import database.db_third_topic.bank.constant.ProjectConstant;
import database.db_third_topic.bank.dao.BranchDAO;
import database.db_third_topic.bank.exception.DAOException;
import java.sql.*;

import static database.db_third_topic.bank.constant.ProjectConstant.*;
import static database.db_third_topic.bank.util.DAOUtil.preparedStatement;
import database.db_third_topic.bank.model.Branch;
import database.db_third_topic.bank.model.Customer;


public class MySQLBranchDAO implements BranchDAO {
    @Override
    public void create(Branch branch) throws SQLException {
        if (branch.getBranch_id() != null) {
            throw new IllegalArgumentException("Branch is already created, the branch_id is not null.");
        }
        Object[] values = {branch.getBranch_name(), branch.getAddress(), branch.getPhone()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_INSERT_BRANCH, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    branch.setBranch_id(generatedKeys.getInt(1));
                    System.out.println("Successfully Inserted branch_id " + generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Creating branch failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void updateBranchPhone(Branch branch, String phone) throws SQLException {
        if (branch.getBranch_id() == null) {
            throw new IllegalArgumentException("Branch does not existed.");
        }
        Object[] values = {phone, branch.getBranch_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_UPDATE_BRANCH_PHONE, false, values)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void setSafeUpdates(Integer n) throws SQLException {
        Object[] values = {n};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_SET_SAFE_UPDATES,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void resetAutoIncrement() throws SQLException {
        Integer start = 1;
        Object[] values = {start};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_RESET_AUTO_INCREMENT_BRANCH,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAllBranches() throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_ALL_BRANCH,
                     false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteBranch(Branch branch) throws SQLException {
        Object[] values = {branch.getBranch_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_BRANCH,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Branch findById(Integer id) throws SQLException { return find(id); }

    private Branch find(Object... values) throws SQLException {
        Branch branch = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, ProjectConstant.SQL_FIND_BY_BRANCH_ID,
                     false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                branch = getBranchFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return branch;
    }

    /**
     * Mapped Branch from the current row of the given ResultSet
     */
    private Branch getBranchFromResultSet(ResultSet resultSet) throws SQLException {
        Branch branch = new Branch();
        branch.setBranch_id(resultSet.getInt("branch_id"));
        branch.setBranch_name(resultSet.getString("branch_name"));
        branch.setAddress(resultSet.getString("address"));
        branch.setPhone(resultSet.getString("phone"));
        return branch;
    }

}
