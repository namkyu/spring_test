package kyu;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dispatcher-servlet.xml", "/spring.xml" })
@WebAppConfiguration
public class TestControllerTest {

	@Autowired
	private WebApplicationContext context;
	@Autowired
    private MessageSource reloadableResourceBundleMessageSource;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void MockMvc이용해서콘트롤러테스트() throws Exception {
		MvcResult result = mockMvc.perform(get("/properties/test1").accept(MediaType.TEXT_HTML))
								.andDo(print())
								.andExpect(status().isOk())
								.andReturn();
		String body = result.getResponse().getContentAsString();
		String message = reloadableResourceBundleMessageSource.getMessage("test", null, new Locale("kr"));
		assertThat(message, is(body));
	}
}
