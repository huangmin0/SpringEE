package com.hm.hibernate.util;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;

	static {
		try {
			// 使用默认的hiber.cfg.xml配置文件创建Configuration实例
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	//ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session currentSession() throws HibernateException {
		Session s = session.get();
		if (s == null) {
			// 如果该线程还没有session，那么创建一个session
			s = sessionFactory.openSession();
			// 将获得的session变量存储在ThreadLocal变量session里
			session.set(s);
		}
		return s;

	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null) 
			s.close();
			session.set(null);
		

	}
}
