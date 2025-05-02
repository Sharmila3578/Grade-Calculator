import java.io.*;
import java.util.*;

public class GradeCalculator {
    private List<Student> students;
    private final String fileName = "grades.txt";

    public GradeCalculator() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(String name, int marks) {
        students.add(new Student(name, marks));
        saveToFile();
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                writer.write(s.getName() + "," + s.getMarks());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            // Ignore if file does not exist on first run
        }
    }
}
