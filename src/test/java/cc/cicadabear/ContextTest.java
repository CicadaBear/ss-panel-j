package cc.cicadabear;


import cc.cicadabear.common.util.ThreadLocalHolder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * @author Shengzhao Li
 */
@ContextConfiguration(locations = {
        "classpath:application-context.xml",
        "classpath:application-security-context.xml"},
        initializers = {TestApplicationContextInitializer.class})
public abstract class ContextTest extends AbstractTransactionalTestNGSpringContextTests {


    @Autowired
    private SessionFactory sessionFactory;

    @BeforeTransaction
    public void before() throws Exception {
        ThreadLocalHolder.setThreadLocalSession(sessionFactory.openSession());
    }

    @AfterTransaction
    public void after() throws Exception {
        ThreadLocalHolder.getSession().close();
    }
}