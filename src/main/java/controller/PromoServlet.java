package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.CartBO;
import Model.BO.FoodBO;
import Model.BO.PromoBO;
import Model.Bean.Cart;
import Model.Bean.Food;
import Model.Bean.Item;
import Model.Bean.Promo;

@WebServlet(urlPatterns = "/promo")
public class PromoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartBO cartBO = new CartBO();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			int userId = (Integer)session.getAttribute("userId");
			Cart cart = cartBO.getCartByUserId(userId);
			List<Item> listItem = cartBO.getItemFood(cart.getId());
			req.setAttribute("listItem", listItem);
			int soLuong = cartBO.getCartTotalQuantity(cart.getId());
			req.setAttribute("cartSize", soLuong);
		}
		PromoBO promoBO = new PromoBO();
		List<Promo> listAvailablePromo = promoBO.getAvailablePromo();
		req.setAttribute("listAvailablePromo", listAvailablePromo);
		List<Promo> listSoonPromo = promoBO.getSoonPromo();
		req.setAttribute("listSoonPromo", listSoonPromo);
		req.getRequestDispatcher("promo.jsp").forward(req, resp);
	}
}
