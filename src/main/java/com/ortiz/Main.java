package com.ortiz;

import com.github.javafaker.Faker;
import org.h2.tools.Server;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Server server = Server.createTcpServer("-tcpAllowOthers").start();

            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:~/test1;INIT=RUNSCRIPT FROM 'classpath:schema.sql'", "", "");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from information_schema.columns where table_name='PERSON'");

            ResultSetMetaData meta = rs.getMetaData();

            Table table = new Table();

            table.setName("PERSON");

            while (rs.next()) {
                table.addColumn(new Column(rs.getString("COLUMN_NAME"), ColumnType.valueOfDatatype(rs.getString("TYPE_NAME"))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateInserts(Table table) {
        Faker faker = new Faker();
        ColumnValueFactory columnValueFactory = new ColumnValueFactory(faker);
        for (Column column: table.getColumns()) {
            columnValueFactory.getValue(column);
        }
        StringBuilder sb = new StringBuilder();

        // TODO WITH COLUMN NAME PATTERN, CREATE FAKER VALUE
    }




}