package projects.fifth_topic.enums;

public enum HeaderMenuItems {

    SIGNIN_PAGE("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/"),
    WHATS_NEW_PAGE("https://magento.softwaretestingboard.com/what-is-new.html"),
    WOMEN_PAGE("https://magento.softwaretestingboard.com/women.html"),
    MEN_PAGE("https://magento.softwaretestingboard.com/men.html"),
    GEAR_PAGE("https://magento.softwaretestingboard.com/gear.html"),
    TRAINING_PAGE("https://magento.softwaretestingboard.com/training.html"),
    SALE_PAGE("https://magento.softwaretestingboard.com/sale.html"),
    CREATE_ACCOUNT_PAGE("https://magento.softwaretestingboard.com/customer/account/create/");

    private String href;

    HeaderMenuItems(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}
