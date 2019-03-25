/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut9InitializingCollections;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Gaurav Sharma
 *
 */
public class DrawingAppTut9 {

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
		ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut9InitializingCollections/SpringDrawTut9.xml");
		Triangle9 triangle = (Triangle9)context.getBean("triangle");
		
		triangle.draw();
		
	}

}
