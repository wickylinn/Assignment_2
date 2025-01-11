import java.util.*;

interface Payable {
    double getPaymentAmount();
}


class Person implements Payable, Comparable<Person> {
    private static int count = 0;
    private final int id;
    private String name;
    private String surname;

    public Person() {
        this.id = ++count;
    }

    public Person(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    public String getPosition() {
        return "Student";
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(other.getPaymentAmount(), this.getPaymentAmount());
    }
}

class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, String surname, String position, double salary) {
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }

    @Override
    public double getPaymentAmount() {
        return salary;
    }
}

class Student extends Person {
    private double gpa;
    private static final double STIPEND = 36660.00;

    public Student() {
        super();
    }

    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    @Override
    public double getPaymentAmount() {
        return gpa > 2.67 ? STIPEND : 0;
    }
}

public class MyApplication {
    public static void main(String[] args) {
        List<Payable> people = new ArrayList<>();

        people.add(new Employee("John", "Lennon", "Manager", 27045.78));
        people.add(new Employee("George", "Harrison", "Developer", 50000.00));

        people.add(new Student("Ringo", "Starr", 2.5));
        people.add(new Student("Paul", "McCartney", 3.5));

        Collections.sort(people);

        printData(people);
    }

    public static void printData(Iterable<Payable> payables) {
        for (Payable p : payables) {
            System.out.println(p.toString() + " earns " + p.getPaymentAmount() + " tenge");
        }
    }
}