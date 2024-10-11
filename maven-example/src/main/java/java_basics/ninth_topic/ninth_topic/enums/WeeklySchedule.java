package java_basics.ninth_topic.ninth_topic.enums;

import java.util.Arrays;

public enum WeeklySchedule {
    SUNDAY("No assignment", 0),
    MONDAY("Lecture", 1.5),
    TUESDAY("Practice", 1.0),
    WEDNESDAY("Meeting", 3.0),
    THURSDAY("Lecture", 1.5),
    FRIDAY("Practice", 1.0),
    SATURDAY("No assignment", 0);

    private final String schedule;
    private final double hours;

    WeeklySchedule(String schedule, double hours) {
        this.schedule = schedule;
        this.hours = hours;
    }

    public String getSchedule() {
        return schedule;
    }

    public double getHours() {
        return hours;
    }

    // collection stream with terminal and non-terminal operations
    public static WeeklySchedule findBySchedule(String schedule) {
        return Arrays.stream(WeeklySchedule.values())
                .filter(x -> x.schedule.toLowerCase().startsWith(schedule.toLowerCase()))
                .sorted()
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format("No matched schedule: %s.", schedule)));
    }


    // collection stream with terminal (forEach) and non-terminal operations
    public static void sortBusyDayHours(double hours) {
        Arrays.stream(WeeklySchedule.values())
                .mapToDouble(WeeklySchedule::getHours)
                .filter(x -> x >= hours)
                .sorted()
                .forEach(System.out::println);
    }

    // collection stream with terminal (forEach) and non-terminal operations
    public static double getSumHours() {
        return Arrays.stream(WeeklySchedule.values())
                .mapToDouble(WeeklySchedule::getHours)
                .sum();
    }
}

class WeeklyScheduleDay {
    WeeklySchedule weeklySchedule;

    public WeeklyScheduleDay(WeeklySchedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public void tellDailySchedule() {
        switch (weeklySchedule) {
            case SUNDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case MONDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case TUESDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case WEDNESDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case THURSDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case FRIDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
            case SATURDAY:
                System.out.println(weeklySchedule.name() + ": " + weeklySchedule.getSchedule());
                break;
        }
    }
}
