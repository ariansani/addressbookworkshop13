package com.example.day13workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.model.Contact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day13workshopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testContact() throws Exception{
		Contact c = new Contact();
		c.setName("Arian");
		c.setEmail("ariansani@hotmail.com");
		c.setPhoneNumber("999");
		assertEquals(c.getName(),"Arian");

	}

}
