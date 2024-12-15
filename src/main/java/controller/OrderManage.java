package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.OrdersBO;
import Model.Bean.Orders;

@WebServlet(urlPatterns = "/orderManage")
public class OrderManage  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdersBO od = new OrdersBO();
		
		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			String type_raw = req.getParameter("type");
			int userId = (Integer)session.getAttribute("userId");
			int type;
			if(type_raw == null) {
				List<Orders> listOrder = od.getOrdersByUserId(userId);
				req.setAttribute("listOrder", listOrder);
				
			}else {
				type = Integer.parseInt(type_raw);
				List<Orders> listOrder = od.getOrderByStatus(type, userId);
				req.setAttribute("listOrder", listOrder);
			}
			req.getRequestDispatcher("orderManage.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("home");
		}
	}
}
