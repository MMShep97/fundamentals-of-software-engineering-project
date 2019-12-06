package com.canvas.config.controllerTest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;

import com.canvas.config.controller.StudentController;
import com.canvas.config.model.Student;
import com.canvas.config.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	private MockMvc mvc;
	
	@Mock
	private StudentService service;
	
	@InjectMocks
	private StudentController studentController;
	
	private JacksonTester<Student> jsonStudent;
	
	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
//		
//		 mvc = MockMvcBuilders.standaloneSetup(superHeroController)
//	                .setControllerAdvice(new SuperHeroExceptionHandler())
//	                .addFilters(new SuperHeroFilter())
//	                .build();
	}
}
