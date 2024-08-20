import java.util.Objects;

public class User {
    private String userId;
    private String password;
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() { return userId; }
    public String getPassword() { return password; }

    @Override
    public String toString() { return "This user's ID is: " + userId; }
    @Override
    public int hashCode() {
        return Objects.hash(userId, password);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            User user = (User) obj;
            return (user.userId.equals(this.userId) &&
                    user.password.equals(this.password));
        }
    }
}
