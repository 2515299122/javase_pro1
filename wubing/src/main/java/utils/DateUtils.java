package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String changePattern(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
