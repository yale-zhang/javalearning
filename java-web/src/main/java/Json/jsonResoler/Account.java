package Json.jsonResoler;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{

    private List<Accountbook> accountbook;

    public List<Accountbook> getAccountbook() {
        return accountbook;
    }

    public void setAccountbook(List<Accountbook> accountbook) {
        this.accountbook = accountbook;
    }
}
