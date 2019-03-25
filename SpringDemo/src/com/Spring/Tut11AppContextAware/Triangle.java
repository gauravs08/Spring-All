package com.Spring.Tut11AppContextAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Gaurav Sharma
 *
 */
public class Triangle implements ApplicationContextAware, BeanNameAware{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context = null;
	
	public void draw()
	{
		System.out.println("PointA (x,y):: " +getPointA().getx()+ "," +getPointA().gety());
		System.out.println("PointB (x,y):: " +getPointB().getx()+ "," +getPointB().gety());
		System.out.println("PointC (x,y):: " +getPointC().getx()+ "," +getPointC().gety());
	}
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	/*these BeanName and ApplicationContext are called at the time of initialisation of Spring Bean obj 
	 * so they will be called first . check the output to see the effect these will be first to be sysout*/ 
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is::"+beanName); //here beanName is "triangle"
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		System.out.println("ApplicationContext is :: "+this.context);
	}

	
}
