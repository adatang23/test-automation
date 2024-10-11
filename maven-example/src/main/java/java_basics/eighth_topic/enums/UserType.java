package java_basics.eighth_topic.enums;

public enum UserType {
    ADMIN_USER("Admin user"),
    VIP_USER("VIP user"),
    PLATINUM_USER("Platinum user"),
    REWARD_USER("Reward user"),
    CUSTOMER_USER("Customer user"),
    NEWLY_REGISTERED_USER("Newly registered user"),
    GUEST_USER("Guest user");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "User type: " + value;
    }
}

