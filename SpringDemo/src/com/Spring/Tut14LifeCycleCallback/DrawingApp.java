/* Spring Tutorial 05 - ApplicationContext and Property Initialization
 * Spring Tutorial 06 - Using Constructor Injection
 * */
package com.Spring.Tut14LifeCycleCallback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
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
		 * so xml file should be in project SpringDemo not in src folder*/
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("SpringDraw.xml"));
		//Triangle triangle = (Triangle)factory.getBean("triangle");
		
		//2 method to load file from appl context path  so SpringDraw.xml file shud be in src folder
		
		//ApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut14LifeCycleCallback/SpringDraw.xml");
		
		//AbstractApplicationContext is used for hookup for callback mode 
		AbstractApplicationContext context =new ClassPathXmlApplicationContext("com/Spring/Tut14LifeCycleCallback/SpringDraw.xml");
		Triangle triangle = (Triangle)context.getBean("triangle"); // change it to .getBean("triangel1");
		
		
		/*since this is desktop application not a web app so need to register hook
		 *  to shut down context when we are finish up with. 
		    if not registered then initialised method is called for sure.
		    but disposal/destroy method will not be called*/
		/* NOTE::  need to implement Triangle class with InitializingBean,DisposableBean <<I>>
		 * public class Triangle implements InitializingBean,DisposableBean*/
		context.registerShutdownHook();// comment this to check the destroy/disposal method is called or not.
		
		System.out.println(" Bean Name :: " + triangle.getClass());
		triangle.draw();
		TriangleList trianglelist = (TriangleList)context.getBean("trianglelist");
		System.out.println(" Bean Name :: " +trianglelist.getClass());
		trianglelist.draw();
		
	}

}
