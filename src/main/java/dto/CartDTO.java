package dto;

import java.math.BigDecimal;

import java.util.List

import javax.validation.constraints.Pattern;

public class CartDTO {
	
	private Integer id;
	
	private long totalPrice;
	
	private List<ItemDTO> order;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public List<ItemDTO> getOrder() {
		return order;
	}
	
	public void setOrder(List<ItemDTO> order) {
		this.order = order;
	}
	
	
}
