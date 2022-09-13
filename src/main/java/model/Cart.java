package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CART_ID")
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private BigDecimal price;
	@Column(name="QUANTITY")
	private Integer quantity;
	
//	private long id;
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="ITEM_CART_ID")
//	private List<Item> order;
//	private long totalPrice;
	

}