package com.ortiz.velocity;

import org.apache.velocity.tools.config.DefaultKey;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DefaultKey("datetime")
public class DateTimeTool {

    private static final String LOCAL_DATETIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    private static final String LOCAL_DATE_FORMAT_DEFAULT = "yyyy-MM-dd";

    public String formatDateTime(String format, LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public String formatLocalDate(String format, LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(formatter);
    }

    public String formatLocalDateTime(LocalDateTime dateTime) {
        return formatDateTime(LOCAL_DATETIME_FORMAT_DEFAULT, dateTime);
    }

    public String formatLocalDate(LocalDate localDate) {
       return formatLocalDate(LOCAL_DATE_FORMAT_DEFAULT, localDate);
    }
}
