package spring.spel;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
	public void 스프링SPEL테스트() {
		assertThat("SPEL", is(parse("'SPEL'")));
		assertThat("test11", is(parse("'test'.concat('11')")));
		assertThat("TEST", is(parse("new String('test').toUpperCase()")));
		assertThat(true, is(parse("null == null")));
		assertThat(false, is(parse("new String('test') == null")));
	}

	private Object parse(String value) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(value);
		Object message = (Object) exp.getValue();
		return message;
	}

	@Test
	public void 스프링SPEL테스트_MAP() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginId", 123);
		map.put("question1", 123);
		evaluationContext.setVariables(map);

		Expression defaultExpression = expressionParser.parseExpression("#loginId + #question1");
		Object result = defaultExpression.getValue(evaluationContext);
		assertThat(246, is(result));
	}

	@Test
	public void 스프링SPEL테스트_멤버변수접근() {
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
		assertThat("a", is(result));
	}
}
