package com.db.labs.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackFridayService {
    private static String genFirstDateOfTheYear(int year) {
        return year + "-01-13";
    }

    private static String genLastDateOfTheYear(int year) {
        return year + "-12-31";
    }

    public static void printBlackFridayPerYearSorted(int startYear, int endYear) {
        //todo do that!!!!!
        LocalDate start = LocalDate.parse(genFirstDateOfTheYear(startYear));
        LocalDate end = LocalDate.parse(genLastDateOfTheYear(endYear));

        Stream.iterate(start, date -> date.isBefore(end), date -> date.plusMonths(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(date -> date.getDayOfMonth() == 13)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(LocalDate::getYear, Collectors.counting()),
                        Map::entrySet))
                .stream().sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).reversed())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        printBlackFridayPerYearSorted(1971, 1980);
    }
}
