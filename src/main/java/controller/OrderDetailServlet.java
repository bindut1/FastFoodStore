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
import Model.BO.OrdersBO;
import Model.BO.UsersBO;
import Model.Bean.Item;
import Model.Bean.Orders;
import Model.Bean.Users;

@WebServlet(urlPatterns = "/orderDetail")
public class OrderDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdersBO od = new OrdersBO();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			String id_raw = req.getParameter("id");
			int oid;
			if(id_raw == null)
				oid = 0;
			else{
				oid = Integer.parseInt(id_raw);			
			}
			Orders order = od.getOrdersByOrderId(oid);
			req.setAttribute("order", order);
			int discountAmount = od.getDiscountByOrderId(oid);
			req.setAttribute("discountAmount", discountAmount);
			List<Item> listItem = od.getItemLine(oid);
			req.setAttribute("listItem", listItem);
			int userId = (Integer)session.getAttribute("userId");
					
			req.setAttribute("itemSize", listItem.size());
			req.getRequestDispatcher("orderDetail.jsp").forward(req,resp);
		}else {
			resp.sendRedirect("home");
		}
	}
}
