package lectures.lecture7.task4;

public class EmployeeEntity {
    private Integer salary;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EmployeeEntity(Integer salary) {
        this.salary = salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public static int compareTo(EmployeeEntity e1, EmployeeEntity e2) {
        return e1.getSalary() < e2.getSalary() ? e1.getSalary() : e2.getSalary();
    }
}
