public class GradeManager {

    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String original = names[i];
            StringBuilder sb = new StringBuilder(original);
            reversed[i] = sb.reverse().toString();
        }
        return reversed;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to find students who need to retake the exam
    public static String[] findFailingStudents(String[] names, int[] scores) {
        // Count how many failed
        int count = 0;
        for (int score : scores) {
            if (score < 60) count++;
        }

        String[] failing = new String[count];
        int index = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing[index++] = names[i];
            }
        }

        return failing;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // Reverse names
        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Reversed Student Names:");
        for (String name : reversedNames) {
            System.out.println(name);
        }

        // Display letter grades
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < students.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + " scored " + scores[i] + " → Grade: " + grade);
        }

        // Find and show failing students
        String[] failingStudents = findFailingStudents(students, scores);
        System.out.println("\nStudents who need to retake the exam:");
        if (failingStudents.length == 0) {
            System.out.println("None 🎉");
        } else {
            for (String name : failingStudents) {
                System.out.println(name);
            }
        }
    }
}
