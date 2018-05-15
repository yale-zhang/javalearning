package mockitotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

//Junit4.x提供注解@RunWith,可以指定单元测试“运行类”,运行类必须继承自org.junit.runner.Runner并实现run方法。
// Spring Test框架提供的运行类是 SpringJUnit4ClassRunner ,使用该类可以轻松的将Spring和JUnit进行集成。
@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试运行类
@ContextConfiguration(locations = {"/applicationContext.xml"})//指定Spring配置文件的位置
//下面的注解指明使用的事务管理器
//如果defualtRollBack为true,测试运行结束后，默认回滚事务，不影响数据库
//@TransactionConfiguration(transactionManager = "txManager",defaultRollback = true)
//@Transactional////指定默认所有测试方法的事务特性
public class AccountServiceTest {

    @Inject
    private AccountService accountService;

    @Test
    public void test()
    {
        assertEquals( 68861, accountService.queryBalanceOfDefaultAccount( 100 ) );
    }
}
