package database.db_sixth_topic.design_patterns.proxy_pattern;

public class ProxyOperationsPerformed implements OperationsPerformed {
    private String userName;
    private RealOperationsPerformed realOperationsPerformed;

    public ProxyOperationsPerformed(String userName) {
        this.userName = userName;
    }

    @Override
    public void view(Integer id) {
        if (getRole(userName).equals("ADMIN") || getRole(userName).equals("USER")) {
            realOperationsPerformed = new RealOperationsPerformed();
            realOperationsPerformed.view(id);
        } else {
            System.out.println("You can not view this record.");
        }
    }

    @Override
    public void edit(String phone, Integer id) {
        if (getRole(userName).equals("ADMIN")) {
            realOperationsPerformed = new RealOperationsPerformed();
            realOperationsPerformed.edit(phone, id);
        } else {
            System.out.println("You can not edit this record.");
        }
    }

    public String getRole(String userName) {
        //Get user role by username
        return userName;
    }
}
