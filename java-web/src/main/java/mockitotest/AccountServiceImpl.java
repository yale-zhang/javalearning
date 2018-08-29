package mockitotest;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private Map<Integer, Object[]> accountDatabase;

    @Inject
    private PersonService          personService;

    @PostConstruct
    public void init()
    {
        accountDatabase = new HashMap<Integer, Object[]>();
        //字段：账号,余额
        accountDatabase.put( 100, new Object[] { "6225100", 68861 } );
        accountDatabase.put( 101, new Object[] { "6225101", 1851 } );
        accountDatabase.put( 102, new Object[] { "6225102", 845 } );
        accountDatabase.put( 103, new Object[] { "6225103", 16598 } );
    }

    @Override
    public int queryBalanceOfDefaultAccount( int personId )
    {
        Person person = personService.getPerson( personId );
        Account defaultAccount = person.getDefaultAccount();
        return (Integer) accountDatabase.get( defaultAccount.getId() )[1];
    }
}
