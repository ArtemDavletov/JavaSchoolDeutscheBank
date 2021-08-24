package com.db.lectures.lecture7.taskBeforeLanch;

public enum Seniority {
    JUN, MIDDLE, SENIOR;
    //jun <10
    //middle >10  <20
    //senior >20

    // you can add any code you want but try to avoid using if block
    public static Seniority defineSeniority(int salary) {
        // Мне не нравится это решение, но это самое простое, что пришло в голову :)
        return salary < 10 ? JUN : (salary < 20 ? MIDDLE : SENIOR);
    }
}
