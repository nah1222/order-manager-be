package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.CartDTO;
import dto.ItemDTO;
import exception.OrderManagerException;
import model.Cart;
import model.Item;

public interface CartService {
	
	CartDTO createCart(CartDTO cartDTO) throws OrderManagerException;
	
	List<ItemDTO> getItemsByCart(Integer cartId) throws OrderManagerException;
	
	CartDTO updateCart(Integer cartId, List<Item> order) throws OrderManagerException;
	
	void addItemToCart(Item item, List<Item> order, Integer cartId) throws OrderManagerException;
	
	void deleteItemFromCart(Item item, List<Item> order, Integer cartId) throws OrderManagerException;
	
	long calculateTotal(List<Item> order) throws Exception;
	
	List<ItemDTO> allItems();
	
	
}