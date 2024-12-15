package Model.BO;

import java.util.List;

import Model.Bean.Food;
import Model.DAO.FoodDAO;

public class FoodBO {
	private FoodDAO foodDAO = new FoodDAO();
	public List<Food> getAll(){
		return foodDAO.getAll();
	}
	
	public List<Food> searchByName(String key){
		return foodDAO.searchByName(key);
	}
	
	public List<Food> getByCatID(int id){
		return foodDAO.getByCatID(id);
	}
	
	public Food getFoodById(int id) {
		return foodDAO.getFoodById(id);
	}
	
	public List<Food> getBestSellerFood(){
		return foodDAO.getBestSellerFood();
	}
	
	public int deleteFoodById(int id) {
		return foodDAO.deleteFoodById(id);
	}
	
	public int insertFood(String title, String desc, int price, String image, String availability, int cateId) {
		return foodDAO.insertFood(title, desc, price, image, availability, cateId);
	}
	
	public List<Food> searchFood(String text){
		return foodDAO.searchFood(text);
	}
	
	public int updateFoodDetail(int foodId, String title, String desc, int price, String image, int cateId) {
		return foodDAO.updateFoodDetail(foodId, title, desc, price, image, cateId);
	}
	
	public int updateFoodAvailability(int foodId, String availability) {
		return foodDAO.updateFoodAvailability(foodId, availability);
	}
	
	public List<Integer> getFoodIdsByUserId(int userId, int orderId) {
		return foodDAO.getFoodIdsByUserId(userId, orderId);
	}
	
}
