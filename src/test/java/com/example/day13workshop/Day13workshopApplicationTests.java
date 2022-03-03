package com.example.day13workshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.controller.AddressbookController;

@SpringBootTest
class Day13workshopTests {
	@Autowired
	private AddressbookController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
