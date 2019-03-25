package com.Spring.Tut22_MessageSource_PropertyFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*INTRO:
 * @Controller :
 * 		Indicates that an annotated class is a "Controller" (e.g. a web controller).
 *		allowing for implementation classes to be autodetected through classpath scanning.
 *  	It is typically used in combination with annotated handler methods based on the RequestMapping annotation.
 * @Repository : 
 * 		Indicates that an annotated class is a "Repository" (or "DAO").
 *		A class thus annotated is eligible for Spring DataAccessException translation. 
 *		The annotated class is also clarified as to its role in the overall application architecture for the purpose of tools, aspects, etc.
 *	    , allowing for implementation classes to be autodetected through classpath scanning.
 * @Service :
 * 		Indicates that an annotated class is a "Service" (e.g. a business service facade).
 * 		allowing for implementation classes to be autodetected through classpath scanning.
 * 
 * Note: Specifying @Component to a class Circle will make circle (small case) bean and will be auto detected 
 * 		so no need to specify bean in SpringDraw.xml comment out below line 
 * 		<bean id="circle" class="com.Spring.Tut21_Component_Service_Repository_StereotypeAnnotation.Circle">
 * 
 * in SpringDraw.xml add this for auto-scanning of @Component of Class
 * 		 <context:component-scan base-package="com.Spring.Tut21_Component_Service_Repository_StereotypeAnnotation"/>
 * 
 * 
 * Disadv of using @Component : 
 * 		Only one instance of the bean can be achieved for autodetection ,
 * 		means if we want diff bean instance like in case of Point class point2,point3,point3 are 3 diff instances of the bean Point(Advantage of Spring) 
 * */

//@Controller		//For Controller Obj (same as in MVC)
//@Service			//For Service Obj
//@Repository		//for Data object

/**
 * @author Gaurav Sharma
 *
 */
@Component  //Generic type 
public class Circle implements Shape {

	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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
	
	/* 
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
		System.out.println(this.messageSource.getMessage("circle.greeting",null,"Default Greeting Hello!!",null));
		
		System.out.println(this.messageSource.getMessage("circle.point.param",new Object[]{center.getx() ,center.gety()},"Default Greeting Hello!!",null));
		
		System.out.println("Circle point is: ("+center.getx() +", "+center.gety() +")");
		//System.out.println("Message from Cirlce class");
		
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
