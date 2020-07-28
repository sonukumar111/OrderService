package com.order.manager.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Order_Details")
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 4885476974379140111L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer orderNo;
	
	
	@Size(min = 3, max = 30, message = "customer name should be >3 & <30")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed in customer name")
	private String customerName;
	
	@Temporal(TemporalType.DATE)
	@Past
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date orderDate;
	
	@Size(min = 20, max = 150, message = "shipping address should be >2 & <150")
	private String shippingAddress;

	@Digits(fraction = 2, integer = 5)
	private BigDecimal totalInDoller;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_no_fk", referencedColumnName = "orderNo")
	private List<OrderItem> orderItems;
	
	public OrderBean() {
		super();
	}

	public OrderBean(Integer orderNo, String customerName, Date orderDate, String shippingAddress,
			BigDecimal totalInDoller) {
		super();
		this.orderNo = orderNo;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.totalInDoller = totalInDoller;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getTotalInDoller() {
		return totalInDoller;
	}

	public void setTotalInDoller(BigDecimal totalInDoller) {
		this.totalInDoller = totalInDoller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerName=" + customerName + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", orderItems=" + orderItems + ", totalInDoller="
				+ totalInDoller + "]";
	}	
}
