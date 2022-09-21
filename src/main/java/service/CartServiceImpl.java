package service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.CartDTO;
import dto.ItemDTO;
import exception.OrderManagerException;
import model.Cart;
import model.Item;
import repository.CartRepository;
import repository.ItemRepository;

@Service(value="cartService")
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	private Cart cartFrom(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setTotalPrice(cartDTO.getTotalPrice());
		if(cartDTO.getOrder() != null) {
			List<Item> items = cartDTO.getOrder().stream()
					.map(itemDTO -> itemFrom(itemDTO)).collect(Collectors.toList());
			cart.setOrder(items);
		}
		return cart;
	}
	
	private CartDTO cartDTOFrom(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartId(cart.getCartId());
		cartDTO.setTotalPrice(cart.getTotalPrice());
		List<Item>itemList = cart.getOrder();
		if(itemList!=null) {
			List<ItemDTO> itemDTOList = itemList.stream()
					.map(item -> itemDTOFrom(item))
					.collect(Collectors.toList());
			cartDTO.setOrder(itemDTOList);
		}
		return cartDTO;
	}
	
	private Item itemFrom(ItemDTO itemDTO) {
		Item item = new Item();
		item.setItemId(itemDTO.getItemId());
		item.setName(itemDTO.getName());
		item.setPrice(itemDTO.getPrice());
		item.setDescription(itemDTO.getDescription());
		item.setSelected(itemDTO.getSelected());
		item.setQuantity(itemDTO.getQuantity());
		return item;
	}
	
	private ItemDTO itemDTOFrom(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemId(item.getItemId());
		itemDTO.setName(item.getName());
		itemDTO.setPrice(item.getPrice());
		itemDTO.setDescription(item.getDescription());
		itemDTO.setSelected(item.getSelected());
		itemDTO.setQuantity(item.getQuantity());
		return itemDTO;
	}

	@Override
	public CartDTO createCart(CartDTO cartDTO) throws OrderManagerException {
		// TODO Auto-generated method stub
		Cart cart = cartFrom(cartDTO);
		cart.setOrder(null); //null to begin with
		List<Item> items = new ArrayList<Item>();
		if(cartDTO.getOrder()!=null) {
			cartDTO.getOrder().forEach(itemDTO -> {
				Item item = itemFrom(itemDTO);
				itemRepository.save(item);
			});
			cart.setOrder(items);
		}
		
		cartRepository.save(cart);
		List<ItemDTO> itemDTOs = items.stream().map(item -> itemDTOFrom(item))
				.collect(Collectors.toList());
		cartDTO.setOrder(itemDTOs);
		return cartDTO;
	}

	@Override
	public List<ItemDTO> getItemsByCart(Integer cartId) throws OrderManagerException {
		// TODO Auto-generated method stub
		return cartRepository.findById(cartId).getOrder().stream().map(item->itemDTOFrom(item))
				.collect(Collectors.toList());
	}

	@Override
	public CartDTO updateCart(Integer cartId, List<Item> order) throws OrderManagerException {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findById(cartId);
		cart.setOrder(order);
		return cartDTOFrom(cart);
	}
	
	@Override
	public void addItemToCart(Item item, List<Item> order, Integer cartId) throws OrderManagerException {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findById(cartId);
		order.add(item);
		cart.setOrder(order);
		
	}

	@Override
	public void deleteItemFromCart(Item item, List<Item> order, Integer cartId) throws OrderManagerException {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findById(cartId);
		order.remove(item);
		cart.setOrder(order);
	}

	@Override
	public long calculateTotal(List<Item> order) throws Exception {
		// TODO Auto-generated method stub
		LongSummaryStatistics priceList = order.stream()
				.collect(Collectors.summarizingLong(item->item.getPrice()));
		return priceList.getSum();
	}

	@Override
	public List<ItemDTO> allItems() {
		// TODO Auto-generated method stub
		List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		itemRepository.findAll().forEach(item->itemDTOList.add(itemDTOFrom(item)));
		return itemDTOList;
	}	

}
