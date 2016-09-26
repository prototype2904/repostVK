package ru.vkrepostcontest.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Stetskevich Roman on 07.09.2016.
 * @since 0.1
 */
@Component
public class DateUtil {

    private static final String[] months = { "января", "февраля", "марта", "апреля", "мая",
        "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря" };

    private static Calendar calendar = Calendar.getInstance();


    /**
     * получить дату в формате "день *название месяца в родительном падеже*"
     * @param date
     * @return
     */
    public static String getStringDate(Date date){
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return String.valueOf(day) + " " + months[month];
    }

    /**
     * разница в миллисекундах
     * @param date
     * @return
     */
    public static long getDifferenceInMillis(Date date){
        calendar.setTime(date);
        long timeInMillis = calendar.getTimeInMillis();
        Date now = new Date();
        calendar.setTime(now);
        //now - date
        return calendar.getTimeInMillis() - timeInMillis;
    }

    /**
     * Сложить
     * @param milliseconds
     * @return
     */
    public static Date addMilliSeconds(long milliseconds){
        calendar.setTime(new Date());
        calendar.setTimeInMillis(calendar.getTimeInMillis() + milliseconds);
        return calendar.getTime();
    }
}
