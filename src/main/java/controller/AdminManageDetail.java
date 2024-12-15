package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.CategoryBO;
import Model.BO.FoodBO;
import Model.BO.OrdersBO;
import Model.BO.UsersBO;
import Model.Bean.Category;
import Model.Bean.Food;
import Model.Bean.Item;
import Model.Bean.Orders;
import Model.Bean.Roles;
import Model.Bean.Users;

@WebServlet(urlPatterns = {"/ManageUserDetail", "/ManageFoodDetail", "/ManageOrdersDetail"})
public class AdminManageDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("roleAdmin") != null) {
			switch(path) {
			case "/ManageUserDetail":
				UsersBO usersBO = new UsersBO();
				String id_raw = req.getParameter("id");
				int userId;
				if(id_raw != null) {
					userId = Integer.parseInt(id_raw);
					Users user = usersBO.getUserDetail(userId);
					req.setAttribute("user", user);
					List<Roles> listRoles = usersBO.getListRoles();
					req.setAttribute("listRole", listRoles);
					req.getRequestDispatcher("adminManageUserDetail.jsp").forward(req, resp);
				}
				break;
			case "/ManageFoodDetail":
				FoodBO foodBO = new FoodBO();
				CategoryBO cateDAO = new CategoryBO();
				String id_raw2 = req.getParameter("id");
				int foodId;
				if(id_raw2 != null) {
					foodId = Integer.parseInt(id_raw2);
					Food food = foodBO.getFoodById(foodId);
					List<Category> listCate = cateDAO.getAll();
					req.setAttribute("listCate", listCate);
					req.setAttribute("food", food);
					
					req.getRequestDispatcher("adminManageFoodDetail.jsp").forward(req, resp);
				}
				break;
			case "/ManageOrdersDetail":
				OrdersBO ordersBO = new OrdersBO();
				String id_raw3 = req.getParameter("id");
				int orderId;
				if(id_raw3 != null) {
					orderId = Integer.parseInt(id_raw3);
					Orders o = ordersBO.getOrdersByOrderId(orderId);
					int type = Integer.parseInt(req.getParameter("type"));
					req.setAttribute("type", type);
					List<Item> listItem = ordersBO.getItemLine(orderId);
					UsersBO usersDAO1 = new UsersBO();
					Users user1 = usersDAO1.getUserDetail(o.getUserId());
					req.setAttribute("user", user1);
					req.setAttribute("listItem", listItem);
					req.setAttribute("order", o);
					int discountAmount = ordersBO.getDiscountByOrderId(orderId);
					req.setAttribute("discountAmount", discountAmount);
					req.getRequestDispatcher("adminManageOrdersDetail.jsp").forward(req, resp);
				}
				break;
			}
		}else
			resp.sendRedirect("home");
	}
}
