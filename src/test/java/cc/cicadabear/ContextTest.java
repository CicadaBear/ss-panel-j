package cc.cicadabear;


import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.shared.BeanProvider;
import cc.cicadabear.domain.shared.security.SecurityUserDetails;
import cc.cicadabear.web.context.SpringSecurityHolder;
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
//        BeanProvider.initialize(applicationContext);
//        SecurityUtils securityUtils = new SecurityUtils();
//        securityUtils.setSecurityHolder(new SpringSecurityHolder() {
//            @Override
//            public SecurityUserDetails userDetails() {
//                return null;
//            }
//        });
    }

    @AfterTransaction
    public void after() throws Exception {
        ThreadLocalHolder.getSession().close();
    }
}