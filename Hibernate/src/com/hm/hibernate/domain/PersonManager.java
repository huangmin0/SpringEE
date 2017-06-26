package com.hm.hibernate.domain;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hm.hibernate.util.HibernateUtil;

public class PersonManager {

	public static void main(String[] args) {
		PersonManager mgr=new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}
	//创建并保存Person对象
	private void createAndStorePerson() {
		//打开线程安全的session 对象
		Session session=HibernateUtil.currentSession();
		//打开事物
		Transaction ts=session.beginTransaction();
		//创建Person对象
		Person person=new Person();
		//为Person对象设置属性
		person.setAge(20);
		person.setName("crazyit.org");
		//向Person的school的属性中添加两个元素
		person.getSchools().add("小学");
		person.getSchools().add("中学");
		session.save(person);
		ts.commit();
		HibernateUtil.closeSession();
		
	}

}
