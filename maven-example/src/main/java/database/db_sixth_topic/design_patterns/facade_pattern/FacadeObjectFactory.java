package database.db_sixth_topic.design_patterns.facade_pattern;

public class FacadeObjectFactory {
    private DisplayObject displayCustomer;
    private DisplayObject displayBranch;

    public FacadeObjectFactory() {
        displayCustomer = new DisplayCustomer();
        displayBranch = new DisplayBranch();
    }

    public void displayCustomer(Integer id) {
        displayCustomer.displayObject(id);
    }

    public void displayBranch(Integer id) {
        displayBranch.displayObject(id);
    }
}
