package api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CartDTO;
import dto.ItemDTO;
import exception.OrderManagerException;
import model.Item;
import service.CartService;

@RestController
@CrossOrigin
@RequestMapping("cart")
@Validated //for validating path variables
public class CartAPI {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping("cart")
	ResponseEntity<CartDTO> createCart(@Valid @RequestBody CartDTO cartDTO) throws OrderManagerException{
		return new ResponseEntity<CartDTO>(cartService.createCart(cartDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("Items")
	public ResponseEntity<List<ItemDTO>>allItems(){
		return new ResponseEntity<List<ItemDTO>>(cartService.allItems(),HttpStatus.OK);
	}
	
	@PutMapping("cart/{cartId}")
	public ResponseEntity<CartDTO> updateCart(@PathVariable Integer cartId, List<Item> order) throws OrderManagerException{
		return new ResponseEntity<CartDTO>(cartService.updateCart(cartId, order),HttpStatus.OK);
	}
	
	@PutMapping("cart/{cartId}")
	public void addItemToCart(Item item, List<Item> order, @PathVariable Integer cartId) throws OrderManagerException{
		return;
	}
	
	@PutMapping("cart/{cartId}")
	public void deleteItemFromCart(Item item, List<Item> order, @PathVariable Integer cartId) throws OrderManagerException {
		return;
	}

}
