package com.example.tukai.orderitemservice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class OrderItemRepositoryTest {
   @Autowired
   private TestEntityManager entityManager;
   @Autowired
   private OrderItemRepository studentRepository;
   @Test
   public void whenFindAll() {
       OrderItem student1 = new OrderItem();
      
       entityManager.persist(student1);
       entityManager.flush();
       OrderItem student2 = new OrderItem();
      
       entityManager.persist(student2);
       entityManager.flush();
       List<OrderItem> students = studentRepository.findAll();
       assertThat(students.size()).isEqualTo(2);
       assertThat(students.get(0)).isEqualTo(student1);
       assertThat(students.get(1)).isEqualTo(student2);
   }
   @Test
   public void whenFindAllById() {
	   OrderItem student = new OrderItem();
      
       entityManager.persist(student);
       entityManager.flush();
       OrderItem testStudent = studentRepository.findOne(student.getId());
       assertThat(testStudent.equals(student));
   }
}
