package com.ortiz.meta;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private String name;

    private List<Column> columns;

    public Table() {
        this.columns = new ArrayList<>();
    }

    public boolean addColumn(Column column) {
        return this.columns.add(column);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
