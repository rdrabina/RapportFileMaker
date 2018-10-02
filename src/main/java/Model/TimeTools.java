package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeTools {
    public static String getFormattedDate(Calendar calendar){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd.MM.yyyy", Locale.ENGLISH);
        return sdf.format(calendar.getTime());
    }

    public static int getDaysInMonth(Calendar calendar) {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static void setMonth(Calendar calendar, Integer month) {
        calendar.set(Calendar.MONTH, month - 1);
    }

    public static void setDay(Calendar calendar, int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }
}
