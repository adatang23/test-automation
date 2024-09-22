package tenth_topic.connectionpool;

import java.util.concurrent.ThreadFactory;

public class MockConnection {
    private String url;
    private String userName;
    private String password;

    MockConnection(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Url: " + url + ", UserName: " + userName + ", Password: " + password;
    }
}
