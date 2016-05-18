package com.kyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class MemberControllerTest {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberServiceProxy memberServiceProxy;

	@Test
	public void test1() {
		for (int i = 0; i < 10; i++) {
			memberService.getList();
		}
	}

	@Test
	public void test2() {
		for (int i = 0; i < 10; i++) {
			memberServiceProxy.getList();
		}
	}
}