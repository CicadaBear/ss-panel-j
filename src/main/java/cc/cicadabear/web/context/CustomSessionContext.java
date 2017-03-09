package cc.cicadabear.web.context;

/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import cc.cicadabear.common.util.ThreadLocalHolder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jta.platform.spi.JtaPlatform;
import org.springframework.orm.hibernate4.SpringJtaSessionContext;

import javax.transaction.TransactionManager;

/**
 * @author Jack
 */
public class CustomSessionContext implements CurrentSessionContext {

    private final SessionFactoryImplementor sessionFactory;

    private final CurrentSessionContext jtaSessionContext;


    /**
     * Create a new SpringSessionContext for the given Hibernate SessionFactory.
     *
     * @param sessionFactory the SessionFactory to provide current Sessions for
     */
    public CustomSessionContext(SessionFactoryImplementor sessionFactory) {
        this.sessionFactory = sessionFactory;
        JtaPlatform jtaPlatform = sessionFactory.getServiceRegistry().getService(JtaPlatform.class);
        TransactionManager transactionManager = jtaPlatform.retrieveTransactionManager();
        this.jtaSessionContext = (transactionManager != null ? new SpringJtaSessionContext(sessionFactory) : null);
    }


    /**
     * Retrieve the Spring-managed Session for the current thread, if any.
     */
    public Session currentSession() throws HibernateException {
        return ThreadLocalHolder.getSession();
    }

}
