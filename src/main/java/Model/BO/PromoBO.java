package Model.BO;

import java.util.List;

import Model.Bean.Promo;
import Model.DAO.PromoDAO;

public class PromoBO {
	private PromoDAO promoDAO = new PromoDAO();
	public List<Promo> getAllPromo() {
		return promoDAO.getAllPromo();
	}
	public List<Promo> getAvailablePromo(){
		return promoDAO.getAvailablePromo();
	}
	public List<Promo> getSoonPromo(){
		return promoDAO.getSoonPromo();
	}
	public Promo getPromoById(String promoId) {
		return promoDAO.getPromoById(promoId);
	}
	
	public int addPromo(String id, int discount, double minimumPay, String startDate, String endDate) {
		return promoDAO.addPromo(id, discount, minimumPay, startDate, endDate);
	}

	public int editPromo(String promoId, int discount, double minimumPay, String startDate, String endDate) {
		return promoDAO.editPromo(promoId, discount, minimumPay, startDate, endDate);
	}
	public int deletePromo(String promoId) {
		return promoDAO.deletePromo(promoId);
	}
		
}
