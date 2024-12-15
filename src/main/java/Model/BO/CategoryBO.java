package Model.BO;

import java.util.List;

import Model.Bean.Category;
import Model.DAO.CategoryDAO;

public class CategoryBO {
	private CategoryDAO categoryDAO = new CategoryDAO();
	public List<Category> getAll(){
		return categoryDAO.getAll();
	}
	
	public int[] getCategoryRevenue() {
		return categoryDAO.getCategoryRevenue();
	}
	
}
