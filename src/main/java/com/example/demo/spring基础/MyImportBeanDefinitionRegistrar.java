package com.example.demo.spring基础;

import com.example.demo.spring基础.entity.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 17:12
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		registry.registerBeanDefinition("black", new RootBeanDefinition(Blue.class));
	}
}
