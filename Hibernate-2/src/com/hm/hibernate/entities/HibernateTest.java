package com.hm.hibernate.entities;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HibernateTest
{
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	}
	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Test
	public void testSessionFlash()
	{
		News news=(News) session.get(News.class, 1);
		news.setAuthor("Oracle");
		
	}
	@Test
	public void save(){
		News news =new News();
		news.setTitle("AA");
		news.setAuthor("BB");
		news.setDate(new Date());
		session.save(news);
		System.out.println(news);
	}
	
	@Test
	public void testSessionCache()
	{
		News news=(News) session.get(News.class, 1);
		System.out.println(news);
		
		News news1=(News) session.get(News.class, 1);
		System.out.println(news1);
	}

}
