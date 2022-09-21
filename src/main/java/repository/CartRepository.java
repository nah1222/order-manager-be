package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dto.CartDTO;
import dto.ItemDTO;
import model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

	Cart findById(Integer cartId);
}
