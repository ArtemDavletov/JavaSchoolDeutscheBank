package lectures.lecture7.task4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtil {
    public static void main(String[] args) {

    }

    public static List<String> solution(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream().sorted(Comparator.comparingInt(EmployeeEntity::getSalary).reversed()).map(EmployeeEntity::getName).collect(Collectors.toList());
    }
}
