import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Day17_Lambdas_FunctionalInterfaces {
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
        }
    }

    interface Greet {
        void sayHello();
    }

    public static void main(String[] args) {

        Greet g1 = new Greet() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Class");
            }
        };

        g1.sayHello();

        Greet g2 = () -> System.out.println("Hello from Lambda");
        g2.sayHello();

        List<Employee> employees = Arrays.asList(

                new Employee(101, "Alice", "IT", 75000),
                new Employee(102, "Bob", "HR", 50000),
                new Employee(103, "Charlie", "IT", 90000),
                new Employee(104, "John", "Finance", 65000)

        );

        Predicate<Employee> highSalary =
                emp -> emp.getSalary() >= 70000;

        Predicate<Employee> itDepartment =
                emp -> emp.getDepartment().equals("IT");

        System.out.println("High Salary Employees");

        employees.stream()
                .filter(highSalary)
                .forEach(System.out::println);


        System.out.println("IT Employees");

        employees.stream()
                .filter(itDepartment)
                .forEach(System.out::println);


        System.out.println("Salary Ascending ");

        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);


        System.out.println("Salary Descending");

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .reversed()
                )
                .forEach(System.out::println);

        System.out.println("Combined Stream Pipeline");

        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .filter(emp -> emp.getSalary() > 60000)
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .reversed()
                )
                .map(Employee::getName)
                .forEach(System.out::println);

    }
}