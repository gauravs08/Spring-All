package com.Spring.Tut19AutowiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;

public class Circle implements Shape {

	private Point center;
	
	public Point getCenter() {
		return center;
	}
	
	/* by adding @Required - it make below method compulsory which interns force spring to send point obj ,
	 * if not passed then it will not create the circle bean
	 * here "center" Point obj is required for creation of circle 
	 * error msg: BeanInitializationException: Property 'center' is required for bean 'circle' 
	 * req: add a class bean in xml <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
	 * 		as it is check in preprocessor of creating bean on=bj.
	   
	   @Autowired : this will auto wired the circle with require point bean without mentioning 
	   			ways-
	   			(I)	<property name="center" ref="point2"/> in "circle" bean
	   	 only thing that it required is the single point bean present in the whole springdraw.xml
	   	 if there are multiple point reference it will not get which it shud pick up 
	   			(II) how to choose which point bean when there are multiple point bean present in xml
	   			by using @Qualifier annotation 
	   	@Qualifier : by placing <qualifier name="circleRequired"> in the particular point bean 
	   	 			this help in picking up right point bean 
	   				*/
	 
	//@Required
	@Autowired 
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Circle point is: ("+center.getx() +", "+center.gety() +")");

	}

}
