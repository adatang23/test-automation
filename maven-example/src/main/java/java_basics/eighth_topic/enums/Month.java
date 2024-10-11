package java_basics.eighth_topic.enums;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private final int day;
    Month(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}


