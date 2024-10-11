package java_basics.ninth_topic.ninth_topic.enums;
import java.util.Arrays;

public enum UserType {
    ADMIN_USER("Admin"),
    VIP_USER("VIP"),
    PLATINUM_USER("Platinum"),
    REWARD_USER("Reward"),
    CUSTOMER_USER("Customer"),
    NEWLY_REGISTERED_USER("NewlyRegistered"),
    GUEST_USER("Guest");

    private final String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    // Collection stream with terminal and non-terminal operations
    public static UserType findByUserType(String type) {
        return Arrays
                .stream(UserType.values())
                .filter(x -> x.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format("No matched type %s.", type)));
    }

    @Override
    public String toString() {
        return "User type: " + type;
    }
}

