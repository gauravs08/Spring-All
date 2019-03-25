package com.Spring.Tut20_JSR250Annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
	//@Autowired 
	//@Qualifier("circleRelated")
	
	/*INTRO: 
	 * (I)@Resource(name="pointC"): this will automatically bind the "pointC" bean in SpringDraw.xml
	 * 			else will throw Exception  org.springframework.beans.factory.NoSuchBeanDefinitionException:
	 * 			 No bean named 'pointC' is defined
	 *(II)@Resource : only @Resource tell us that there is already a "center" bean present in xml 
	 *				no need to explicitly tell name="center"
	 *			where "center" is are class setter private variable
	 *			if no "center" bean of point present in xml Exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException:
	 *			  No qualifying bean of type [com.Spring.Tut20_JSR250Annotation.Point] is defined: 
	 *			  expected single matching bean but found 5: zeropoint,point2,point3,pointC,center1
	 *
	 *@PostConstruct:
	 *@PreDestroy:
	 */
	@Resource//(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Circle point is: ("+center.getx() +", "+center.gety() +")");

	}
	
	@PostConstruct
	public void InitializeCircle() {
		System.out.println("Initailization Circle point.");
	}
	@PreDestroy  // for this we need to register Hook to context.
	public void DestroyCircle() {
		System.out.println("Destroy of Circle point.");
	}

}
