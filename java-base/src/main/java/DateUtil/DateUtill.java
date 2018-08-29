package DateUtil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtill {
    public static void main(String[] args) {

        int year=2018;
        int month=8;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        System.out.println(DateUtil.endOfMonth(cal));
        DateTime dateTime = DateUtil.parse("2018-8", "yyyy-MM");
        DateTime endOfMonth = DateUtil.endOfMonth(dateTime);
        String format = new SimpleDateFormat("yyyy-MM-dd ").format(DateUtil.endOfMonth(dateTime));
        System.out.println(endOfMonth.dayOfMonth());

        DateTime endOfMonth1 = DateUtil.endOfMonth(dateTime);
        String format1 = DateUtil.format(endOfMonth1, "yyyy-MM-dd");
        System.out.println(format1);
        DateTime dateTime1 = DateUtil.beginOfMonth(dateTime);
        System.out.println(dateTime1);


    }

}
