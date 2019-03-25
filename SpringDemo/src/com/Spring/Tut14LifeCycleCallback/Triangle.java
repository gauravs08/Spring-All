package com.Spring.Tut14LifeCycleCallback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Gaurav Sharma
 *
 */
public class Triangle implements InitializingBean,DisposableBean {
//InitializingBean - afterpropertieSet() : for performing operation that are required to do after Initilization of bean obj.
//DisposableBean - destroy() : for performing operation required after destroying of context only applicable when 
	// context.registerShutdownHook(); is called after context initialised ,this is callback/hookup for context
	
//this above process can also be done manually  in spring xml by attaching properties
	//init-method="myInit" 
	//destroy-method ="myDestroy"	
	//myInit(), mydestroy() methods are manually handled by programmer
	//manually operating Initialising,Destroying helps in independence from spring framework class
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
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

	@Override
	public void destroy() throws Exception {
	System.out.println("Bean Destroy method called...");	
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Intialising... ");		
	}

	public void myInit(){
		System.out.println("Manual Intialising by myInit()... ");		
	}
	public void myDestroy(){
		System.out.println("Manual Destroying by myDestroy()... ");		
	}
}
