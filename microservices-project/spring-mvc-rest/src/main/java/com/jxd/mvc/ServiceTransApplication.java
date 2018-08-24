package com.jxd.mvc;

import com.jxd.mvc.sevice.ServiceTransTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionStatus;

@ComponentScan("com.jxd.mvc.sevice")
@EnableTransactionManagement
public class ServiceTransApplication {

    @Component(value = "ljlj")
    public class MyTransactionManager implements PlatformTransactionManager{

        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            System.err.println("getTransaction...");
            return new DefaultTransactionStatus(null,true,
                    true,true,true,null);
        }

        @Override
        public void commit(TransactionStatus status) throws TransactionException {
            System.err.println("commit..");
        }

        @Override
        public void rollback(TransactionStatus status) throws TransactionException {
            System.err.println("rollback..");
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ServiceTransApplication.class);
        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.getBeansOfType(ServiceTransTest.class).forEach((beanName,bean)->{
            System.err.println("beanName:"+beanName+",beanType:"+bean.getClass());
            bean.echo();
        });

        annotationConfigApplicationContext.close();
    }
}
