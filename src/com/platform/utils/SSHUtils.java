package com.platform.utils;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSHUtils {
	
	private static ThreadLocal<SessionFactory> sessionFactoryLocal;
	private static ThreadLocal<ApplicationContext> applicationContextLocal;
	
	
	//��ʵʹ��spring+junit4�Ĳ��Կ�ܸ����㣬���Բο�spring�����ĵ�
	
	public static SessionFactory getSessionFactory() {
//		if (sessionFactoryLocal ==  null) {
//			Configuration cfg = new Configuration().configure();//���hibernate.cfg.xml���ַ�ʽ,��ʹ��spring���÷�ʽҪ��ioc��ʽ��ȡ
//			Properties properties = cfg.getProperties();
//			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(properties).build();
//			SessionFactory sf = cfg.buildSessionFactory(registry);
//			sessionFactoryLocal = new ThreadLocal<SessionFactory>();
//			sessionFactoryLocal.set(sf);
//		}
//		return sessionFactoryLocal.get();
		
		//ʹ��spring ioc�ķ�ʽ  XmlBeanDefinitionReader
		//BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		SessionFactory tempSessionFactory = getAppContext().getBean("sessionFactory",SessionFactory.class);
		return tempSessionFactory;
 	}
	
	public static ApplicationContext getAppContext(){
        if(applicationContextLocal == null){
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            applicationContextLocal = new ThreadLocal<ApplicationContext>();
            applicationContextLocal.set(context);
        }
        return applicationContextLocal.get();
    }
	
	
    public static void main(String[] args) {
        //����appContext
        //ApplicationContext appContext = getAppContext();
        //String[] names = appContext.getBeanDefinitionNames();
        //System.out.println(Arrays.toString(names));
        
        //����sessionFactory
        SessionFactory sessionFactory = getSessionFactory();
        Session openSession = sessionFactory.openSession();
        System.out.println(openSession);
        openSession.close();


    }

}
