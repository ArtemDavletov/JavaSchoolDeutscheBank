package com.db.lectures.lecture8.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PricableToCostableAdapter implements Pricable {
    private final Costable costable;

    @Override
    public int getPrice() {
        return costable.cost();
    }
}
