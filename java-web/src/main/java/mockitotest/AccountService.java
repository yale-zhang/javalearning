package mockitotest;

public interface AccountService {
    /**
     * 查询人员默认账户余额
     */
    int queryBalanceOfDefaultAccount( int personId );
}
