package com.springdatajpa.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="products", 
		schema="ecommerce"
)
public class Product {
	
	/***************************************************************************************************
	 * 4 strategies -> AUTO, IDENTITY, SEQUENCE, TABLE
	 * AUTO -     This will use dialect default strategy, in mysql it will use SEQUENCE strategy. 
	 * IDENTITY - This will relies on an auto-incremented database column and lets the database generate 
	 * 			  a new value with each insert operation.
	 * SEQUENCE - This is the most widely used generation Strategy
	 * TABLE -    Rarely used
	 ***************************************************************************************************/
	
	// @GeneratedValue(strategy=GenerationType.IDENTITY) 
	// @GeneratedValue(strategy=GenerationType.AUTO) 
	// @GeneratedValue(strategy=GenerationType.TABLE) 

	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_generator")
	@SequenceGenerator(
			name="product_generator",
			sequenceName="product_sequence_name",
			allocationSize=1
	)
	private Long Id;
	private String sku;
	@Column(name="product_name", nullable=false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpdated;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
