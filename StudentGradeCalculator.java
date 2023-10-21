import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of subjects: ");
        int totalSubjects = scanner.nextInt();
        if (totalSubjects <= 0) {
            System.out.println("Invalid number of subjects. Please enter a positive number.");
            return;
        }
        // Create arrays to store subject names and marks
        String[] subjectNames = new String[totalSubjects];
        double[] subjectMarks = new double[totalSubjects];
        System.out.println("Enter the names of the subjects:");
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter the name for Subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.next();
        }
        System.out.println("Enter marks obtained in each subject (out of 100).");
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks for " + subjectNames[i] + ": ");
            double marks = scanner.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Marks must be between 0 and 100.");
                i--; // Decrement to re-enter marks for the same subject
            } else {
                subjectMarks[i] = marks;
            }
        }
        scanner.close();
        double totalMarks = 0.0;
        for (int i = 0; i < totalSubjects; i++) {
            totalMarks += subjectMarks[i];
        }
        double averagePercentage = totalMarks / totalSubjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}

