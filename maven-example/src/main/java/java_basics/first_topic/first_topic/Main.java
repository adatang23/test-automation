package java_basics.first_topic.first_topic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 2: Print the sorted array as a string
        int[] array = {74, 96, 5, 34, 58, 30, 7, 87, 32};
        insertionSort(array);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));

        // Task 1: Print information about the user
        if (args.length != 4) {
            System.out.println("Please enter a user's first name, last name, age, and phone number separated by space.");
            return;
        }
        String firstName = args[0];
        String lastName = args[1];
        int age = Integer.parseInt(args[2]);
        int phoneNumber = Integer.parseInt(args[3]);
        System.out.println("The user is " + firstName + " " +
                lastName + ", who is " + age + " years old. The user's phone number is " +
                phoneNumber + ".");
    }

    // Function to implement insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}