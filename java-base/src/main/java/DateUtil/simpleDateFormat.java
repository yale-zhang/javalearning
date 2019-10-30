package DateUtil;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class simpleDateFormat {
    /**
     * jdk SimpleDateFormat 时间操作工具类
     */
    public static void main(String[] args) {
        Date myDate = new Date();
        String date = DateFormat.getDateInstance().format(myDate);//
        String dateTime = DateFormat.getDateTimeInstance().format(myDate);
        String time = DateFormat.getTimeInstance().format(myDate);
        System.out.println(myDate);//Wed Oct 30 10:06:19 CST 2019
        System.out.println(date);//2019-10-30
        System.out.println(dateTime);//2019-10-30 10:06:19
        System.out.println(time);//10:08:12

        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
        sdf.applyPattern("yyyy-MM-dd HH:mm");
        System.out.println(sdf.format(myDate));
        StringBuffer strBuffer = new StringBuffer("时间格式是:");
        FieldPosition fieldPosition = new FieldPosition(DateFormat.Field.DAY_OF_MONTH);
        StringBuffer buffer = sdf.format(myDate, strBuffer, fieldPosition);
        System.out.println(buffer);
    }
}
