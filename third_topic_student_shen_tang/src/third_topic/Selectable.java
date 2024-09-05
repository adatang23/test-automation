package third_topic;

import java.util.Arrays;

public interface Selectable {
    default void select(String[] billList) {
        System.out.println("Selected bills are "
                + Arrays.toString(billList).replace("]", "").replace("[", "") + ".");
    }
}
