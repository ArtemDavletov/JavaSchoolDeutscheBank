package com.db.lectures.lecture7.taskBeforeLanch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

@RequiredArgsConstructor
@Getter
public enum Seniority {
    JUN(10), MIDDLE(20), SENIOR(Integer.MAX_VALUE);
    //jun <10
    //middle >10  <20
    //senior >20
    private final int value;

    // you can add any code you want but try to avoid using if block
    public static Seniority defineSeniority(int salary) {
//        return salary < 10 ? JUN : (salary < 20 ? MIDDLE : SENIOR);
        return Arrays.stream(values()).filter(v -> v.value >= salary).findFirst().get();
    }
}
