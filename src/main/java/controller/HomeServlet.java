package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.CartBO;
import Model.BO.FoodBO;
import Model.Bean.Cart;
import Model.Bean.Food;
import Model.Bean.Item;

import java.util.*;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodBO fd = new FoodBO();
		CartBO cartBO = new CartBO();
		List<Food> listBestSellerFood = fd.getBestSellerFood();

		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			int userId = (Integer)session.getAttribute("userId");
			Cart cart = cartBO.getCartByUserId(userId);
			List<Item> listItem = cartBO.getItemFood(cart.getId());
			req.setAttribute("listItem", listItem);
			int soLuong = cartBO.getCartTotalQuantity(cart.getId());
			req.setAttribute("cartSize", soLuong);
		}
		req.setAttribute("listBestSellerFood", listBestSellerFood);
		req.getRequestDispatcher("home1.jsp").forward(req, resp);
	}	
}
