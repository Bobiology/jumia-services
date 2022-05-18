package com.jumia.services.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jumia.services.controllers.CustomerController;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerContollerTest {
	@Mock
	CustomerController customerController;
		
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void customerControllerWhenFetchingCountryPhoneNumbersRespondWithStatusCode200() throws Exception {
		String uri = "/customers";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
				
	}
	@Test
	public void evaluatesPageableParameter() throws Exception {
		mockMvc.perform(get("/customers")
				.param("page", "2")
				.param("size", "20")
				.param("sort", "id,desc")
				.param("sort", "phone,asc"))
				.andExpect(status().isOk());
		
	}
}