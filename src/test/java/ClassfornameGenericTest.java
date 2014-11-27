import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lombok.Data;

import org.junit.Test;

/**
 * @FileName : ClassfornameGenericTest.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ClassfornameGenericTest {

	@Test
	public void genericClassfornameTest() throws Exception {

		TestGeneric<String> testGeneric = new TestGeneric<String>();
		Class<?> clazz = testGeneric.getClass();

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("field=" + field + ", genericType=" + field.getGenericType());
		}

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("method=" + method + ", returnType=" + method.getReturnType());
		}

	}

}

@Data
class TestGeneric<T> {
	private String prop1;
	private T t;
}