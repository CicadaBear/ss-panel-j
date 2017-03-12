package cc.cicadabear.common.aspect;

import cc.cicadabear.common.util.ThreadLocalHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jack on 3/12/17.
 */
@Aspect
public class TimeCounterAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private long startTime;

    @Before("execution(* cc.cicadabear.web.controller..*(..))")
    public void before() {
        startTime = System.currentTimeMillis();
        ThreadLocalHolder.getRequest().setAttribute("startTime", startTime);
        logger.debug("before timestamp" + startTime);
    }

    @After("execution(* cc.cicadabear.web.controller..*(..))")
    public void after() {
        long now = System.currentTimeMillis();
        logger.debug("after timestamp" + now);
        ThreadLocalHolder.getRequest().setAttribute("runningTime", now - startTime);
    }


}

