/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut13BeanDefinationInheritence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		
		/*1)Loading XML bean definitions from file [C:\workspace\Spring\SpringDemo\SpringDraw.xml]
		 * so xml file should be in project SpringDemo not in src folder*/
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("SpringDraw.xml"));
		//Triangle triangle = (Triangle)factory.getBean("triangle");
		
		//2 method to load file from appl context path  so SpringDraw.xml file shud be in src folder
		ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut13BeanDefinationInheritence/SpringDraw.xml");
		Triangle triangle = (Triangle)context.getBean("triangle"); // change it to .getBean("triangel1");
		System.out.println(" Bean Name :: " + triangle.getClass());
		triangle.draw();
		TriangleList trianglelist = (TriangleList)context.getBean("trianglelist");
		System.out.println(" Bean Name :: " +trianglelist.getClass());
		trianglelist.draw();
		
	}

}
