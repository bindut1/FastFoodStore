package Model.BO;

import java.util.*;

import Model.Bean.Cart;
import Model.Bean.Item;
import Model.Bean.Items;
import Model.DAO.CartDAO;

public class CartBO {
	private CartDAO cartDAO = new CartDAO();
	
	public List<Items> getItemByCartId(int cartId){
		return cartDAO.getItemByCartId(cartId);
	}
	
	public Cart getCartByUserId(int userId) {
		return cartDAO.getCartByUserId(userId);
	}
	
	public Items getItemByFoodId(int cartId, int foodId) {
		return cartDAO.getItemByFoodId(cartId, foodId);
	}
	
	public int addItem(int cartId, int foodId, int quantity) {
		return cartDAO.addItem(cartId, foodId, quantity);
	}
	
	public List<Item> getItemFood(int cartId){
		return cartDAO.getItemFood(cartId);
	}
	
	public int delItemFromCart(int cartId, int foodId) {
		return cartDAO.delItemFromCart(cartId, foodId);
	}
	
	public int updateItemQuantity(int cartId, int foodId, String deli) {
		return cartDAO.updateItemQuantity(cartId, foodId, deli);
	}
	
	public Cart getCart(int cartId) {
		return cartDAO.getCart(cartId);
	}
	
	public int updateTotalMoney(int cartId) {
		List<Item> listItem = getItemFood(cartId);
		int tong = 0;
		for(Item i : listItem) {
			tong += i.getPrice() * i.getQuantity();
		}
		return cartDAO.updateTotalMoney(tong, cartId);
	}
	public int getCartTotalQuantity(int cartId) {
		List<Item> listItem = getItemFood(cartId);
		int soLuong = 0;
		for(Item i : listItem) {
			soLuong += i.getQuantity();
		}
		return soLuong;
	}
}
