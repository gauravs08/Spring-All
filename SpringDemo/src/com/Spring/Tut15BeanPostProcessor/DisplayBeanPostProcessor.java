/**
 * 
 */
package com.Spring.Tut15BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanPostProcessor implements BeanPostProcessor {

	/*  INTRO : BeanPostProcessor 
	-implemented in below class .
	-no need to put an id or put an reference in other bean obj above.
	-automatically called before/after initialization of every bean obj present.
	-all inner bean will be initialised before outer one.
	*/
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("In After Initializaion BeanPostProcessor::" + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("In Before Initializaion BeanPostProcessor::" + beanName);
		return bean;
	}

}
