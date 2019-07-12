package Data;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.time.Clock;
import java.time.Instant;

public class DateAPI {
    public static void main(String[] args) {
        //Clock提供访问当前日期和时间。
       /* Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date from = Date.from(instant);
        System.out.print(from);*/

       //时区是由ZoneId表示，通过静态工厂方法可以很容易地访问。
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zoneId = ZoneId.of("Asia/Hong_Kong");
        System.out.println(zoneId);
        //LocalTime代表没有时区的时间，例如晚上10点或17:30:15。
        LocalTime now = LocalTime.now(zoneId);
        System.out.println(now);
    }
}
