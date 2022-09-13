package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.OrderManagerException;
import service.CartService;
import model.Cart;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class CartContoller<Cart> {
	
	private CartService cartService;
	
	@Autowired
	public void CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/orders/{id}")
	public Optional<Cart> getCart(@PathVariable long id) throws OrderManagerException{
		return (Optional<Cart>) cartService.getCart(id);
	}
	
	@PostMapping("/orders")
	public Cart addCart(@RequestBody Cart cart) throws OrderManagerException {
		return cartService.addCart(cart);
	}

}
