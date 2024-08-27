import java.util.Arrays;
import java.util.Objects;

public class Admin extends User {
    private String[] transactionList;
    private String[] userList;

    public Admin(String userId, String password, String[] transactionList, String[] userList) {
        super(userId, password);
        this.transactionList = transactionList;
        this.userList = userList;
    }

    public String[] getTransactionList() {
        return transactionList;
    }

    public String[] getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "The admin with an ID of " + getUserId()
                + " has a transaction list " + Arrays.toString(transactionList)
                + ", and a user list" + Arrays.toString(userList) + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getPassword(), Arrays.toString(getTransactionList()),
                Arrays.toString(getUserList()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Admin admin = (Admin) obj;
            return (admin.getUserId().equals(this.getUserId())
                    && admin.getPassword().equals(this.getPassword())
                    && Arrays.equals(admin.transactionList, this.transactionList)
                    && Arrays.equals(admin.userList, this.userList));
        }
    }
}
