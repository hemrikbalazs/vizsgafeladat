package persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hemrik Balázs
 */
class Util {
    static final DateTimeFormatter formatter;

    static {
        formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    }

    private Util() {
    }

    public static String dateToString(LocalDate date) {
        return formatter.format(date);
    }

    public static LocalDate stringToDate(String dateString) {
        return LocalDate.parse(dateString);
    }
}
