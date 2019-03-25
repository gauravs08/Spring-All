package com.Spring.Tut15BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * @author Gaurav Sharma
 *
 */
public class DisplayBeanFactoryPP implements BeanFactoryPostProcessor {

	/*  INTRO : BeanFactoryPostProcessor 
	-implemented in below class .
	-no need to put an id or put an reference in other bean obj above.
	-automatically called Before initialization of  bean obj present only once.
	*/
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
	System.out.println("My Bean Factory post processor called....");

	}

}
