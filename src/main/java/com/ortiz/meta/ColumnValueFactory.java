package com.ortiz.meta;

import com.github.javafaker.Faker;
import com.ortiz.meta.Column;
import com.ortiz.meta.ColumnType;

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
