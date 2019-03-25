/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut10_BeanAutowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingAppTut10 {

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
		ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut10_BeanAutowiring/SpringDrawTut10.xml");
		Triangle triangle = (Triangle)context.getBean("triangle");
		
		triangle.draw();
		
	}

}
