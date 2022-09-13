package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.CartDTO;
import exception.OrderManagerException;
import model.Cart;
import repository.CartRepository;

@Service(value="cartService")
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	
	
	
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Optional<Cart> getCart(long id){
		return cartRepository.findById(id);
	}

	@Override
	public void addProductToCart(Long id, CartDTO cart) throws OrderManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartDTO> getCustomerCarts(Long id) throws OrderManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyQuantityOfProductInCart(Long id, Integer quantity, Integer productId)
			throws OrderManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductFromCart(Long id, String name) throws OrderManagerException {
		// TODO Auto-generated method stub
		
	}

}
