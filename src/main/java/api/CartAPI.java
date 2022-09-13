package api;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CartDTO;
import exception.OrderManagerException;
import service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart-api")
@Validated //for validating path variables
public class CartAPI {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private Environment environment;
	
	public void addItemToCart(@RequestBody CartDTO cartDTO, @Pattern(regexp="[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+") @PathVariable("id") String id) throws OrderManagerException{
		cartService.addCart(null);
	}
	

}
