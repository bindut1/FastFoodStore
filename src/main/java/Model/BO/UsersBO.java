package Model.BO;

import java.util.List;

import Model.Bean.Roles;
import Model.Bean.Users;
import Model.DAO.UsersDAO;

public class UsersBO {
	private UsersDAO usersDAO = new UsersDAO();
	public Users getAccount(String username, String password) {
		return usersDAO.getAccount(username, password);
	}
	public Users getUserDetail(int userId) {
		return usersDAO.getUserDetail(userId);
	}
	public List<Users> searchUser(String fullname) {
		return usersDAO.searchUser(fullname);
	}
	public int updateUserDetail(int userId, String fullname, String phone_number, String address) {
		return usersDAO.updateUserDetail(userId, fullname, phone_number, address);
	}
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}
	public int updatePassword(int userId, String newPassword){
		return usersDAO.updatePassword(userId, newPassword);
	}
	public String getOldPassword(int userId) {
		return usersDAO.getOldPassword(userId);
	}
	public int updateRole(int userId, int roleId) {
		return usersDAO.updateRole(userId, roleId);
	}
	public boolean checkUsernameExists(String username) {
		return usersDAO.checkUsernameExists(username);
	}
	public boolean checkEmailExists(String email) {
		return usersDAO.checkEmailExists(email);
	}
	public List<Roles> getListRoles(){
		return usersDAO.getListRoles();
	}

}
