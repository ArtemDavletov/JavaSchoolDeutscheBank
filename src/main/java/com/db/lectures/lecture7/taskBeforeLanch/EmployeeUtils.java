package com.db.lectures.lecture7.taskBeforeLanch;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class EmployeeUtils {


    public static Map<Seniority, Long> groupBySeniority(List<Employee> employees) {
        //todo implement this without using if block
        return employees.stream().map(Employee::getSalary).collect(Collectors.groupingBy(Seniority::defineSeniority, Collectors.counting()));
    }


    public static Map<String, Employee> toMapNameVsEmployee(List<Employee> employees) {
        return employees.stream()
                .collect(toMap(Employee::getName, identity(),
                        (e1, e2) -> (e1.getSalary() > e2.getSalary() ? e1 : e2)));
    }


    public static List<String> getNamesSortedBySalary(List<Employee> employees) {
        return employees.stream()
//               .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .map(Employee::getName).collect(Collectors.toList());
    }

    public static int totalSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    //todo do not use this on numbers - this way is for reducing objects, not promitives
    public static int totalSalaryReduceSolution(List<Employee> employees) {
        Optional<Integer> integerOptional = employees.stream()
                .filter(employee -> employee.getName().startsWith("A"))
                .map(Employee::getSalary)
                .reduce(Integer::sum);


        return integerOptional.get();

    }

    public static void main(String[] args) {
        List<Employee> list = List.of(
                Employee.builder().name("Lena").salary(10).build(),
                Employee.builder().name("Masha").salary(12).build(),
                Employee.builder().name("Masha").salary(120).build(),
                Employee.builder().name("Kolya").salary(9).build()
        );

        Map<Seniority, Long> map = groupBySeniority(list);
        System.out.println(map);
    }

}
