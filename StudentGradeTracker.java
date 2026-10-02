import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<int[]> studentMarks = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest Student");
            System.out.println("5. Find Lowest Student");
            System.out.println("6. Summary Report");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                viewStudents();
            } else if (choice == 3) {
                calculateAverage();
            } else if (choice == 4) {
                findHighestStudent();
            } else if (choice == 5) {
                findLowestStudent();
            } else if (choice == 6) {
                summaryReport();
            } else if (choice == 7) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    public static void addStudent() {

        sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        studentNames.add(name);
        studentMarks.add(marks);

        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {

        if (studentNames.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < studentNames.size(); i++) {

            System.out.println("\nStudent Name: " + studentNames.get(i));

            int[] marks = studentMarks.get(i);

            System.out.print("Marks: ");

            for (int j = 0; j < marks.length; j++) {
                System.out.print(marks[j] + " ");
            }

            System.out.println();
        }
    }

    public static void calculateAverage() {

        if (studentNames.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < studentNames.size(); i++) {

            int[] marks = studentMarks.get(i);
            int total = 0;

            for (int j = 0; j < marks.length; j++) {
                total = total + marks[j];
            }

            double average = (double) total / marks.length;

            System.out.println(
                    studentNames.get(i) +
                    " - Average: " + average
            );
        }
    }

    public static void findHighestStudent() {

        if (studentNames.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        int highestTotal = 0;
        double highestAverage = 0;
        String highestStudent = "";

        for (int i = 0; i < studentMarks.size(); i++) {

            int[] marks = studentMarks.get(i);
            int total = 0;

            for (int j = 0; j < marks.length; j++) {
                total = total + marks[j];
            }

            double average = (double) total / marks.length;

            if (total > highestTotal) {
                highestTotal = total;
                highestAverage = average;
                highestStudent = studentNames.get(i);
            }
        }

        System.out.println("\n===== Highest Student =====");
        System.out.println("Student Name: " + highestStudent);
        System.out.println("Total: " + highestTotal);
        System.out.println("Average: " + highestAverage);
    }

    public static void findLowestStudent() {

        if (studentNames.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        int lowestTotal = Integer.MAX_VALUE;
        double lowestAverage = 0;
        String lowestStudent = "";

        for (int i = 0; i < studentMarks.size(); i++) {

            int[] marks = studentMarks.get(i);
            int total = 0;

            for (int j = 0; j < marks.length; j++) {
                total = total + marks[j];
            }

            double average = (double) total / marks.length;

            if (total < lowestTotal) {
                lowestTotal = total;
                lowestAverage = average;
                lowestStudent = studentNames.get(i);
            }
        }

        System.out.println("\n===== Lowest Student =====");
        System.out.println("Student Name: " + lowestStudent);
        System.out.println("Total: " + lowestTotal);
        System.out.println("Average: " + lowestAverage);
    }

    public static void summaryReport() {

        if (studentNames.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== SUMMARY REPORT ==========");

        for (int i = 0; i < studentNames.size(); i++) {

            int[] marks = studentMarks.get(i);

            int total = 0;
            int highest = marks[0];
            int lowest = marks[0];

            for (int j = 0; j < marks.length; j++) {

                total = total + marks[j];

                if (marks[j] > highest) {
                    highest = marks[j];
                }

                if (marks[j] < lowest) {
                    lowest = marks[j];
                }
            }

            double average = (double) total / marks.length;

            System.out.println("\nStudent Name : " + studentNames.get(i));

            System.out.print("Marks        : ");
            for (int j = 0; j < marks.length; j++) {
                System.out.print(marks[j] + " ");
            }

            System.out.println();
            System.out.println("Total        : " + total);
            System.out.println("Average      : " + average);
            System.out.println("Highest Mark : " + highest);
            System.out.println("Lowest Mark  : " + lowest);
        }

        System.out.println("\n====================================");
    }
}
