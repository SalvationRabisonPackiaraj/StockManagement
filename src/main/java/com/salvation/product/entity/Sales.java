package com.salvation.product.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
public class Sales {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productId;
	private int quantity;
	private int amount;
	
	@CreationTimestamp
	@Column(name="created_at",nullable=false,updatable=false)
	private Timestamp createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Sales(String productId, int quantity, int amount) {
		  super();
		
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Sales() {
		super();
	}

	

	
	
	
	




}

