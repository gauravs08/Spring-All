/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut11AppContextAware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gaurav Sharma
 *
 */
public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		
		/*1)Loading XML bean definitions from file [C:\workspace\Spring\SpringDemo\SpringDraw.xml]
		 * so xml file should be in project SpringDemo not be in src folder*/
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("SpringDraw.xml"));
		//Triangle triangle = (Triangle)factory.getBean("triangle");
		
		//2 method to load file from appl context path  so SpringDraw.xml file shud be in src folder
		ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut11AppContextAware/SpringDraw11.xml");
		Triangle triangle = (Triangle)context.getBean("triangle");
		
		triangle.draw();
		
	}

}
