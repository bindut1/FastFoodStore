package Model.BO;

import java.sql.Connection;

import Model.Bean.Users;
import Model.DAO.RegisterDAO;

public class RegisterBO {
	private RegisterDAO registerDAO = new RegisterDAO();
	public boolean InsertAccount(Connection conn, Users users) {
		return registerDAO.InsertAccount(conn, users);
	}
	public boolean checkUser(String username) {
		return registerDAO.checkUser(username);
	}
}
