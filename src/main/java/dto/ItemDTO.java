package dto;

public class ItemDTO {
	
	private Integer itemId;
	
	private String name;
	
	private long price;
	
	private String description;
	
	private boolean selected;
	
	private Integer quantity;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemDTO [id=" + itemId + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", selected=" + selected + ", quantity=" + quantity + "]";
	}

}
