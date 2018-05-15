package mockitotest;


public class Person {
    private int     id;
    private String  name;
    private Account defaultAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Account defaultAccount) {
        this.defaultAccount = defaultAccount;
    }
}
