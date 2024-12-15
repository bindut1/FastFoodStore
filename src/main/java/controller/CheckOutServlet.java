package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.CartBO;
import Model.BO.OrdersBO;
import Model.BO.PromoBO;
import Model.BO.UsersBO;
import Model.Bean.Cart;
import Model.Bean.Item;
import Model.Bean.Promo;
import Model.Bean.Users;

@WebServlet(urlPatterns = "/checkout")
public class CheckOutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartBO cartBO = new CartBO();
		PromoBO promoBO = new PromoBO();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			int userId = (Integer)session.getAttribute("userId");
			UsersBO userDAO = new UsersBO();
			Users users = userDAO.getUserDetail(userId);
			req.setAttribute("users", users);
			Cart cart = cartBO.getCartByUserId(userId);
			List<Item> listItem = cartBO.getItemFood(cart.getId());
			req.setAttribute("listItem", listItem);
			cartBO.updateTotalMoney(cart.getId());
			int soLuong = cartBO.getCartTotalQuantity(cart.getId());
			req.setAttribute("cartSize", soLuong);
			List<Promo> listPromo = promoBO.getAvailablePromo();
			req.setAttribute("listPromo", listPromo);
			
			if(soLuong == 0) {
				resp.sendRedirect("home");
			}
			else req.getRequestDispatcher("payment.jsp").forward(req,resp);
			
		}
		else resp.sendRedirect("home");
		
	}
}