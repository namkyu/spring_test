package spring.spel;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @FileName : SPELTest.java
 * @Project : spring_test
 * @Date : 2016. 3. 7.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class SPELTest {

	@Test
	public void test() {
		System.out.println(parse("'SPEL'"));
		System.out.println(parse("'test'.concat('11')"));
		System.out.println(parse("new String('test').toUpperCase()"));
		System.out.println(parse("null == null"));
		System.out.println(parse("new String('test') == null"));
	}


	private Object parse(String value) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(value);
		Object message = (Object) exp.getValue();
		return message;
	}

	@Test
	public void test2() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginId", 123);
		map.put("question1", 123);
		evaluationContext.setVariables(map);

		Expression defaultExpression = expressionParser.parseExpression("#loginId + #question1");
		Object result = defaultExpression.getValue(evaluationContext);
		System.out.println(result);
	}

	@Test
	public void test3() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext();

		Member member = new Member();
		member.setA("a");
		member.setB("b");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", member);

		evaluationContext.setVariables(map);

		Expression defaultExpression = expressionParser.parseExpression("#result.a");
		Object result = defaultExpression.getValue(evaluationContext);
		System.out.println(result);
	}
}
