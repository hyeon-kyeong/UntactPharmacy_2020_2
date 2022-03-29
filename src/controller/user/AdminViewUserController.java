package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.User;

public class AdminViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/admin/login/form";		// login form ��û���� redirect
        }
    	
    	
		UserManager manager = UserManager.getInstance();
		String user_id = request.getParameter("user_id");
		
    	User user = null;
		try {
			user = manager.findUser(user_id);	// ����� ���� �˻�
		} catch (UserNotFoundException e) {				
	        return "redirect:/admin/list";
		}	
		
		request.setAttribute("user", user);		// ����� ���� ����				
		return "/admin/view.jsp";				// ����� ���� ȭ������ �̵�
    }
}
