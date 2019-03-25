package com.Spring.Tut18RequiredAnnotation;

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
	 * 		as it is check in preprocessor of creating bean on=bj.*/
	 
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Circle point is: ("+center.getx() +", "+center.gety() +" )");

	}

}
