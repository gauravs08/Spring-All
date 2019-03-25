/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut22_MessageSource_PropertyFile;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
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
		
		ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut22_MessageSource_PropertyFile/SpringDraw.xml");
		Shape circle = (Shape)context.getBean("circle");
		/* this "circle" bean will be autodetected at application path and
		if finds annotation @Component in class Circle then it will get that bean*/
		
		circle.draw();
		/*Below line getmessage from myMessages.properties 
		 *  key  "greeting" is searched  if not foung default message is printed from arg 3rd 
		 *  arg1 : key
		 *  arg2 : place holder or dynamic text as object[]{}
		 *  arg3 : default msg when key is not present in properties bundle
		 *  arg4 : locale obj as per Defined EN,FN etc
		 *  */
		//System.out.println("Message from Drawing Class");
		//Locale l = new Locale("EN");
		System.out.println(context.getMessage("draw.greeting",null,"Default Greeting Hello!!",null));
	}

}
