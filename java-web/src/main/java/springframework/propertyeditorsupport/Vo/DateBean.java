package springframework.propertyeditorsupport.Vo;
import lombok.Data;

import java.util.Date;

@Data
public class DateBean {
    private Date date;

    public DateBean(Date date) {
        this.date = date;
    }
}
