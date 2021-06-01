package homework5;

public class Employee {

    private String fullName;
    private String function;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String function, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.function = function;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFunction() {
        return function;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf("%s - %s - %s - %s - %d - %d%n", fullName, function, email, phoneNumber, salary, age);
    }
}






