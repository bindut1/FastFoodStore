package Model.BO;

import Model.DAO.ForgotPasswordDAO;

public class ForgotPasswordBO {
	private ForgotPasswordDAO forgotPasswordDAO = new ForgotPasswordDAO();
	
	public void Edit_Pass(String pass, String mail) {
		forgotPasswordDAO.Edit_Pass(pass, mail);
	}
	
	
}
