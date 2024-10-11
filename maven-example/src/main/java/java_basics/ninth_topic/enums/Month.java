package java_basics.ninth_topic.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    // collection streaming with terminal (forEach()) or non-terminal operations
    /*
    public static void findByDays(int day) {
        Arrays.stream(Month.values())
                .mapToInt(Month::getDay)
                .filter(x -> x == day)
                .distinct()
                .forEachOrdered(System.out::println);
    }*/
}


