package com.ortiz;

import com.github.javafaker.Faker;

public class ColumnValueFactory {

    private final Faker faker;

    public ColumnValueFactory(Faker faker) {
        this.faker = faker;
    }

    public String getValue(Column column) {
        if (column.getColumnType() == ColumnType.NUMBER) {
            return "" + faker.number().numberBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if (column.getColumnType() == ColumnType.STRING) {
            return "" + faker.name().fullName();
        }
        // TODO OTHERS
        return null;
    }

}
