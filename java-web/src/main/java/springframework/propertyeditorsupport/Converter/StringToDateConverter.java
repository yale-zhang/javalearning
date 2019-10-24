package springframework.propertyeditorsupport.Converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private String dateFormat;

    public void setDateFormat(String dateFormat){
        this.dateFormat = dateFormat;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        try {
            return df.parse(source);
        } catch (ParseException e) {
           throw new IllegalArgumentException(e);
        }
    }
}
