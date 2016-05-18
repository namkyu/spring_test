package kyu;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

	@Autowired
    private MessageSource reloadableResourceBundleMessageSource;

	@Autowired
    private MessageSource resourceBundleMessageSource;

	@RequestMapping("/properties/test1")
	@ResponseBody
	public String propertiesTest1(ModelAndView mav, HttpServletRequest request) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(reloadableResourceBundleMessageSource.getMessage("test", null, new Locale("kr")));
		return builder.toString();
	}

	@RequestMapping("/properties/test2")
	@ResponseBody
	public String propertiesTest2(ModelAndView mav, HttpServletRequest request) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(resourceBundleMessageSource.getMessage("test", null, new Locale("kr")));
		return builder.toString();
	}
}