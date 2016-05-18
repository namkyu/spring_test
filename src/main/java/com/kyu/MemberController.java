package com.kyu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @FileName : MemberController.java
 * @Project : spring_test
 * @Date : 2016. 1. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Component
public class MemberController {

	@Autowired
	private MemberService memberService;


	public void list() {
		List<String> memberList = memberService.getList();
		System.out.println(memberList);
	}

}
