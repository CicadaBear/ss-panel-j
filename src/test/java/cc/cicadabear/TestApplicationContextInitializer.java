package cc.cicadabear;

import cc.cicadabear.common.util.ThreadLocalHolder;
import org.apache.log4j.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockServletContext;
import org.springframework.util.Log4jConfigurer;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;

/**
 * @author Shengzhao Li
 */
@Configuration
public class TestApplicationContextInitializer implements ApplicationContextInitializer<AbstractApplicationContext> {

    @Override
    public void initialize(AbstractApplicationContext applicationContext) {


        ThreadLocalHolder.clientIp("127.0.0.1");
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        //load database.properties
        Resource[] resources = new Resource[]{
                new ClassPathResource("test.properties"),
                new ClassPathResource("log4j.properties")
        };

        propertyPlaceholderConfigurer.setLocations(resources);
//        PropertyConfigurator.configure("src/com/config/log4j.properties");
        applicationContext.addBeanFactoryPostProcessor(propertyPlaceholderConfigurer);
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Cannot Initialize log4j");
        }


//        Logger rootLogger = Logger.getRootLogger();
//        rootLogger.setLevel(Level.INFO);
//        rootLogger.addAppender(new ConsoleAppender(
//                new PatternLayout("%-6r [%p] %c - %m%n")));
    }

    @Bean
    public ServletContext servletContext() {
        return new MockServletContext();
    }
}