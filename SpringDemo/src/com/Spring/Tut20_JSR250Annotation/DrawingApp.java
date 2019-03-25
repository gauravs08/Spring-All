/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut20_JSR250Annotation;

import org.springframework.context.support.AbstractApplicationContext;
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
		//ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut20_JSR250Annotation/SpringDraw.xml");
		//Triangle triangle = (Triangle)context.getBean("triangle");
		
		/*INTRO: Shape interface
		 * Below we are using interface shape for drawing circle and triangle 
		 we are not using Triangle triangle = (Triangle)context.getBean("triangle"); 
		 we are using Shape class as base class to draw both shape and triangle.
		 in future if rectangle need to be drawn just make rectangle class which implements shape */
		/*Shape tri = (Shape)context.getBean("triangle");
		tri.draw();*/
		
		/*we have made new circle bean entry in springdraw.xml
		 * but we dont specify any point in circle bean ,
		 * to make that point compulsory for circle bean we need to add required annotation @Required 
		 * and add a preprocessor class */
		AbstractApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut20_JSR250Annotation/SpringDraw.xml");
		context.registerShutdownHook();
		Shape circle = (Shape)context.getBean("circle");
		circle.draw();
		
	}

}
