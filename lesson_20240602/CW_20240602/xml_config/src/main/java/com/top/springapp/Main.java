package com.top.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean1 = context.getBean("testBean", TestBean.class);
        TestBean testBean2 = context.getBean("testBean", TestBean.class);
        testBean1.setName("Oleq");

        System.out.println(testBean1.getName());
        System.out.println(testBean2.getName());
    }
}
