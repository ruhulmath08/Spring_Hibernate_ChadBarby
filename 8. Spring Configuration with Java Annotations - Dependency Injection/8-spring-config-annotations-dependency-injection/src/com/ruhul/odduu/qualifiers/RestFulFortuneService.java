package com.ruhul.odduu.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class RestFulFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hello RestFulFortuneService";
	}

}