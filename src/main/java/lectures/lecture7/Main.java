package lectures.lecture7;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int solution(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }
}