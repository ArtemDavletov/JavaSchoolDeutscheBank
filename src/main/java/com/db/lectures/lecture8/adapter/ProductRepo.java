package com.db.lectures.lecture8.adapter;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Evgeny Borisov
 */
public class ProductRepo {

    private List<Supplier<? extends Costable>> products = List.of(Chair::new,Table::new);

    public Costable getProduct() {
//        return RandomUtil.getRandomElement(products).get();
        return null;
    }
}
