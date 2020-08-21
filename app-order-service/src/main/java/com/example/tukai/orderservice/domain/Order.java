package com.example.tukai.orderservice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER_TABLE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAdrress;
	
	@Column(name = "TOTAL")
	private Double total;
}
