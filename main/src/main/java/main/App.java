package main;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();

        while (true) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, " +
                    "4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, " +
                    "6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, " +
                    "8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = scanner.nextLine();
                    Student student = new Student(name, studentNumber);
                    university.addStudent(student);
                    break;

                case 2:
                    System.out.println("Opiskelijat:");
                    List<Student> students = university.getStudents();
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + ": " + students.get(i));
                    }
                    break;

                case 3:
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int studentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student selectedStudent = university.getStudents().get(studentIndex);
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = scanner.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = scanner.nextInt();
                    selectedStudent.addGrade(course, grade);
                    break;

                case 4:
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    int selectedStudentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student selectedStudentToDisplay = university.getStudents().get(selectedStudentIndex);
                    List<Grade> studentGrades = selectedStudentToDisplay.getGrades();
                    for (Grade studentGrade : studentGrades) {
                        System.out.println(studentGrade);
                    }
                    break;

                case 5:
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    int averageStudentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student averageStudent = university.getStudents().get(averageStudentIndex);
                    double average = Calculator.getAverageGrade(averageStudent);
                    System.out.println("Keskiarvo on " + average);
                    break;

                case 6:
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    int medianStudentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student medianStudent = university.getStudents().get(medianStudentIndex);
                    double median = Calculator.getMedianGrade(medianStudent);
                    System.out.println("Mediaani on " + median);
                    break;

                case 7:
                    university.saveToFile();
                    break;

                case 8:
                    university.loadFromFile();
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Syöte oli väärä. Yritä uudelleen.");
                    break;
            }
        }
    }
}