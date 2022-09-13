package model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="OM_ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ITEM_ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private long price;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="SELECTED")
	private boolean selected;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="ITEM_CART_ID")
//	private CartItem cartItem;

}
