

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class SpringBeanLoadingTest {

	@Resource
	private String namkyu;

	@Test
	public void test() {
		// src/main/resource/spring.xml
//		assertThat(namkyu, is("namkyu"));

		// src/test/resource/spring.xml
		assertThat(namkyu, is("test_namkyu"));
	}
}
