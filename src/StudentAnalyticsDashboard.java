import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class StudentAnalyticsDashboard {

    static class Student {
        private int id;
        private String name;
        private String subject;
        private int marks;
        private LocalDate examDate;

        public Student(int id, String name, String subject, int marks, LocalDate examDate) {
            this.id = id;
            this.name = name;
            this.subject = subject;
            this.marks = marks;
            this.examDate = examDate;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSubject() {
            return subject;
        }

        public int getMarks() {
            return marks;
        }

        public LocalDate getExamDate() {
            return examDate;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + ", marks=" + marks + ", examDate=" + examDate + '}';
        }
    }

    public static void main(String[] args) {

        System.out.println("Loading Student Analytics Dashboard...\n");

        CompletableFuture<List<Student>> future = CompletableFuture.supplyAsync(() -> {

            System.out.println("Fetching student data from database...");

            try {
                Thread.sleep(2000); // Simulate database delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return List.of(
                    new Student(1, "Alice", "Java", 91, LocalDate.of(2026, 7, 1)),
                    new Student(2, "Bob", "Java", 44, LocalDate.of(2026, 7, 1)),
                    new Student(3, "Charlie", "Python", 65, LocalDate.of(2026, 7, 2)),
                    new Student(4, "John", "Python", 32, LocalDate.of(2026, 7, 2))
            );
        });

        future.thenAccept(students -> {

            System.out.println("TOP SCORERS");

            students.stream()
                    .sorted(Comparator.comparing(Student::getMarks).reversed())
                    .limit(5)
                    .forEach(System.out::println);

            System.out.println("SUBJECT-WISE AVERAGE ");

            Map<String, Double> averages = students.stream()
                    .collect(Collectors.groupingBy(
                            Student::getSubject,
                            Collectors.averagingInt(Student::getMarks)
                    ));

            averages.forEach((subject, avg) ->
                    System.out.printf("%-10s : %.2f%n", subject, avg));

            System.out.println(" PASS / FAIL ");

            Map<Boolean, List<Student>> result = students.stream()
                    .collect(Collectors.partitioningBy(
                            s -> s.getMarks() >= 60
                    ));

            System.out.println("PASS STUDENTS");

            result.get(true).forEach(System.out::println);

            System.out.println("FAIL STUDENTS");

            result.get(false).forEach(System.out::println);

            System.out.println("FORMATTED EXAM DATES ");

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd MMM yyyy");

            students.forEach(student ->
                    System.out.println(
                            student.getName() + " -> "
                                    + student.getExamDate().format(formatter)
                    )
            );

        }).join();

    }
}
