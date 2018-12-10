package aviator;

import java.util.Date;

public class variable {
    int i;
    float f;
    Date date;
    // 构造方法
    public variable(int i, float f, Date date) {
        this.i = i;
        this.f = f;
        this.date = date;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
