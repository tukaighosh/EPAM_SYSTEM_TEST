package com.example.tukai.orderitemservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.service.OrderItemServiceImpl;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class OrderItemServiceTest {

	 @TestConfiguration
	    static class StudentServiceImplTestContextConfiguration {
	  
	        @Bean
	        public OrderItemServiceImpl studentService() {
	            return new OrderItemServiceImpl();
	        }
	    }
	 
	    @Autowired
	    private OrderItemServiceImpl studentService;
	 
	    @MockBean
	    private OrderItemRepository studentRepository;
	    
	    @Autowired
	    private TestEntityManager entityManager;
	
	@Test
	public void testAddStudent()
	{
		   OrderItem student = new OrderItem();
	      
		   Mockito.when(studentRepository.saveAndFlush(Mockito.any())).thenReturn((OrderItem)entityManager.persistAndFlush(student));
		   OrderItem student1 = new OrderItem();
	       
	       OrderItem resultStudent = studentService.saveOrderItem(student1);
	       assertThat(resultStudent.getId()).isNotNull();
	}
}
