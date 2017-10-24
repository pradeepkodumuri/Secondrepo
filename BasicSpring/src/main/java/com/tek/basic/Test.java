package com.tek.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
		Restarunt res= (Restarunt) context.getBean("casual");
		res.setWelcomeNote(" tis is first welcome note");
		res.greetCustomer();
		Restarunt res1= (Restarunt)context.getBean("casual");
		res1.setWelcomeNote("second note");
		res1.greetCustomer();
	}

}
