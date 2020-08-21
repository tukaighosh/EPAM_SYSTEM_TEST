package com.example.tukai.orderitemservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.tukai.orderitemservice.controller.OrderItemServiceController;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderItemServiceController.class)
public class OrderItemServiceControllerTest {

	   @Autowired
	   private MockMvc mvc;
	   @MockBean
	   private OrderItemServiceController orderItemServiceController;
	   @Test
	   public void testAddStudent() throws Exception {
	       mvc.perform(MockMvcRequestBuilders.post("/addStudent").content("{\"name\": \"Srishti\",\"className\": \"class VI\",\"schoolName\": \"JHS\",\"marks\": 99}")
	               .contentType(MediaType.APPLICATION_JSON))
	               .andExpect(MockMvcResultMatchers.status().isOk());
	   }
	   
	   @Test
	   public void testGetStudents() throws Exception {
		   mvc.perform(MockMvcRequestBuilders.post("/addStudent").content("{\"name\": \"Tukai\",\"className\": \"class VI\",\"schoolName\": \"JHS\",\"marks\": 100}")
	               .contentType(MediaType.APPLICATION_JSON));
		   mvc.perform(MockMvcRequestBuilders.post("/addStudent").content("{\"name\": \"Bubai\",\"className\": \"class VI\",\"schoolName\": \"JHS\",\"marks\": 99}")
	               .contentType(MediaType.APPLICATION_JSON));
		   
	       mvc.perform(MockMvcRequestBuilders.get("/getStudentDetailsForSchool/JHS")
	               .accept(MediaType.APPLICATION_JSON))
	               .andExpect(MockMvcResultMatchers.status().isOk());
	   }
	   
	   @Test
	   public void testGetStudentWithHighestMarks() throws Exception {
		   mvc.perform(MockMvcRequestBuilders.post("/addStudent").content("{\"name\": \"Tukai\",\"className\": \"class VI\",\"schoolName\": \"JHS\",\"marks\": 100}")
	               .contentType(MediaType.APPLICATION_JSON));
		   mvc.perform(MockMvcRequestBuilders.post("/addStudent").content("{\"name\": \"Bubai\",\"className\": \"class VI\",\"schoolName\": \"JHS\",\"marks\": 99}")
	               .contentType(MediaType.APPLICATION_JSON));

	       mvc.perform(MockMvcRequestBuilders.get("/getStudentWithHighestMarks/JHS")
	               .accept(MediaType.APPLICATION_JSON))
	               .andExpect(MockMvcResultMatchers.status().isOk());
	   }
}

