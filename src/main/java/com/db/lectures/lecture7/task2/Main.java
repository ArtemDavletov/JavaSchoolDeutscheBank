package com.db.lectures.lecture7.task2;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("");
        System.out.println(Main.solution(path));
    }

    @SneakyThrows
    public static long solution(Path filePath) {
        return Files.lines(filePath).flatMap(i -> Arrays.stream(i.split(" "))).count();
    }
}
