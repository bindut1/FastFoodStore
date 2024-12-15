package Model.BO;

import java.util.List;
import java.util.Map;

import Model.Bean.Item;
import Model.Bean.Orders;
import Model.DAO.OrdersDAO;

public class OrdersBO {
	private OrdersDAO ordersDAO = new OrdersDAO();
	public int addOrder(int userId, int totalCost, String note, String status, String paymentMethod, String receiverName, String shipAddress, String phoneNumber, String promoId) {
		return ordersDAO.addOrder(userId, totalCost, note, status, paymentMethod, receiverName, shipAddress, phoneNumber, promoId);
	}
	
	public List<Orders> getOrderByStatus(int type, int userId) {
		return ordersDAO.getOrderByStatus(type, userId);
	}
	public List<Orders> adminGetOrderByStatus(int type) {
		return ordersDAO.adminGetOrderByStatus(type);
	}
	
	public List<Orders> getAllOrder(int userId) {
		return ordersDAO.getAllOrder();
	}
	
	public List<Orders> getAllOrder() {
		return ordersDAO.getAllOrder();
	}
	
	public List<Item> getItemLine(int orderId){
		return ordersDAO.getItemLine(orderId);
	}
	
	public List<Orders> getOrdersByUserId(int userId){
		return ordersDAO.getOrdersByUserId(userId);
	}
	
	public Orders getOrdersByOrderId(int orderId){
		return ordersDAO.getOrdersByOrderId(orderId);
	}
	
	public Orders getNewestOrder(){
		return ordersDAO.getNewestOrder();
	}
	
	public int changeOrderStatus(int orderId, String status) {
		return ordersDAO.changeOrderStatus(orderId, status);
	}
	public int changeOrderStatus(int orderId, String status, String note) {
		return ordersDAO.changeOrderStatus(orderId, status, note);
	}
	
	public Map<String, Integer> getLast7DaysRevenue(String date) {
		return ordersDAO.getLast7DaysRevenue(date);
	}
	
	public int countFoodHasSold(String date) {
		return ordersDAO.countFoodHasSold(date);
	}
	
	public int countUser(String date) {
		return ordersDAO.countUser(date);
	}
	
	public int countOrders(String date) {
		return ordersDAO.countOrders(date);
	}
	public int calTotalRevenue(String date) {
		return ordersDAO.calTotalRevenue(date);
	}
	public List<Orders> SearchOrders(int key){
		return ordersDAO.SearchOrders(key);
	}
	
	public String getEmailByOrderId(int orderId) {
		return ordersDAO.getEmailByOrderId(orderId);
	}
	public int getDiscountByOrderId(int orderId) {
		return ordersDAO.getDiscountByOrderId(orderId);
	}
	public int[] getCurrentWeekRevenue() {
		return ordersDAO.getCurrentWeekRevenue();
	}
	public int[] getLastWeekRevenue() {
		return ordersDAO.getLastWeekRevenue();
	}
	public int[] getCurrentYearRevenue() {
		return ordersDAO.getCurrentYearRevenue();
	}
	public int[] getLastYearRevenue() {
		return ordersDAO.getLastYearRevenue();
	}
}
