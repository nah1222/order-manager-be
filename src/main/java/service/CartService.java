package service;

import java.util.List;
import java.util.Optional;

import dto.CartDTO;
import exception.OrderManagerException;
import model.Cart;

public interface CartService {
	
	public Cart addCart(Cart cart) throws OrderManagerException;
	
	public Optional<Cart> getCart(long id) throws OrderManagerException;
	
	void addProductToCart(Long id, CartDTO cart)throws OrderManagerException;
	
	List<CartDTO> getCustomerCarts(Long id) throws OrderManagerException;
	
	void modifyQuantityOfProductInCart(Long id, Integer quantity, Integer productId) throws OrderManagerException;
	
	void deleteProductFromCart(Long id, String name) throws OrderManagerException;
}