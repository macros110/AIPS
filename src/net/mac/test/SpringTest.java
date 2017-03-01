package net.mac.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {

	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("applicationContent.xml"));
		IService hello = (IService) factory.getBean("service");
		hello.service("Macros");
		factory.destroySingletons();
	}
}
