package ca.pragmaticcoding.widgetsfx;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateWidgets {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private static final DateTimeFormatter jsonFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String formatDate(LocalDate dateToFormat) {
        return dateToFormat.format(formatter);
    }

    public static LocalDate dateFromJson(String jsonDateTime) {
        return LocalDateTime.parse(jsonDateTime, DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC)).toLocalDate();
    }
}
