package springframework.propertyeditorsupport;

import springframework.propertyeditorsupport.Vo.User;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zsy
 */
public class UserEditor extends PropertyEditorSupport {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("\\|");
        User user = new User();
        user.setName(split[0]);
        user.setEmail(split[1]);
        try {
            user.setDate(sdf.parse(split[2]));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        setValue(user);
    }
}
