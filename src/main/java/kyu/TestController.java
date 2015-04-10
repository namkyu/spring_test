package kyu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @FileName : TestController.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Controller
public class TestController {

	@RequestMapping("/properties/test")
	@ResponseBody
	public void propertiesTest(ModelAndView mav, HttpServletRequest request) throws Exception {
		System.out.println("test");
	}
}
