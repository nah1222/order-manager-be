package dto;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

public class CartDTO {
	
//	@NotNull(message="{id.absent}")
//	@Pattern(regexp="[a-zA-Z0-9._]+[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message="{invalid.email.format}")
	private long id;
//	@Pattern(regexp="([A-Za-z])+(\\s[A-Za-z]+)*", message = "{cart.invalid.name}")
	private String name;
	private String description;
	private BigDecimal price;
	private boolean selected;
	private Integer quantity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
