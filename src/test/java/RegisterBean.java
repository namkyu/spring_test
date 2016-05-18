import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lombok.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @FileName : RegisterBean.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class RegisterBean {

	@Autowired
	private ApplicationContext context;


	@Test
	public void registBean() {

		// get BeanFactory from ApplicationContext
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) context).getBeanFactory();

		// 멤버 필드 값 셋팅
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("prop1", "prop1");
		propertyValues.addPropertyValue("prop2", "prop2");

		// bean 생성
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(Test1.class);
		beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
		beanDefinition.setPropertyValues(propertyValues);

		// factory에 bean 등록
		factory.registerBeanDefinition("test1", beanDefinition);

		Test1 test = context.getBean(Test1.class);
		assertThat("method1", is(test.method1()));
		assertThat("method2", is(test.method2()));

		String namkyu = context.getBean("namkyu", String.class);
		assertThat("namkyu", is(namkyu));
	}
}

@Data
class Test1 {

	private String prop1;
	private String prop2;

	public String method1() {
		return "method1";
	}

	public String method2() {
		return "method2";
	}
}
