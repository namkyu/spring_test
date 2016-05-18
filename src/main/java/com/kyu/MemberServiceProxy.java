package com.kyu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @FileName : MemberService.java
 * @Project : spring_test
 * @Date : 2016. 1. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
public class MemberServiceProxy {

	public MemberServiceProxy() {
		System.out.println("New Instance MemberServiceProxy!!");
	}

	public List<String> getList() {
		List<String> memberList = new ArrayList<String>();
		memberList.add("사람1");
		memberList.add("사람2");
		memberList.add("사람3");
		return memberList;
	}
}
