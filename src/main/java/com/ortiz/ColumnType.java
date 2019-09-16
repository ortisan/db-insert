package com.ortiz;

public enum ColumnType {
    NUMBER,
    STRING,
    DATE;

    public static ColumnType valueOfDatatype(String dataType) {
        if ("INTEGER".equals(dataType))  {
            return NUMBER;
        }

        if ("VARCHAR".equals(dataType)) {
            return STRING;
        }

        return null;
    }
}
