package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProv {
	public static SessionFactory fact;

	public static SessionFactory getFact() {
		if (fact == null) {
			fact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return fact;
	}

	public void closeFact()
	{
		if(fact.isOpen())
		{
			fact.close();
		}
	}
}
