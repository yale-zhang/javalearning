package mockitotest;

public interface  PersonService {
    /**
     * 查询人员用户
     */
    Person getPerson(int id);
    /**
     * 得到人员默认账户
     */
    Account getDefaultAccount(Person p);
}
