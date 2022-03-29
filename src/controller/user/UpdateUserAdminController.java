package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;
import model.Community;
import model.User;

public class UpdateUserAdminController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserAdminController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ���� form ��û	
    		// ������ UpdateUserFormController�� ó���ϴ� �۾��� ���⼭ ����
    		String updateId = request.getParameter("user_id");
//    		System.out.println("xxxxxxxxxx"+updateId);
    		

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		
    		UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// �����Ϸ��� ����� ���� �˻�
			request.setAttribute("user", user);			
			
			System.out.println(user);

			HttpSession session = request.getSession();
			
			String curUserId = UserSessionUtils.getLoginUserId(session);
			
			
			if (UserSessionUtils.isLoginUser(updateId, session) ||
				UserSessionUtils.isLoginUser("somsom", session)	
//				||
//				UserSessionUtils.isManager(curUserId, session)
				
					) {
				// ���� �α����� ����ڰ� ���� ��� ������̰ų� �������� ��� -> ���� ����
								
//				List<Community> commList = manager.findCommunityList();	// Ŀ�´�Ƽ ����Ʈ �˻�
//				request.setAttribute("commList", commList);	
				
				return "/admin/updateForm.jsp";   // �˻��� ����� ������ update form���� ����     
			}    
			
			// else (���� �Ұ����� ���) ����� ���� ȭ������ ���� �޼����� ����
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("Ÿ���� ������ ������ �� �����ϴ�."));            
			return "/user/view.jsp";	// ����� ���� ȭ������ �̵� (forwarding)
	    }	
    	
    	// POST request (ȸ�������� parameter�� ���۵�)
    	User updateUser = new User(
//    		request.getParameter("user_id"),
//    		request.getParameter("password"),
//    		request.getParameter("name"),
//    		request.getParameter("email"),
//    		request.getParameter("phone"),
//    		request.getParameter("gender"),
////    		request.getParameter("birth_date"),
//    		request.getParameter("symptom")
    			
    			request.getParameter("user_id"),
    			request.getParameter("user_password"),
    			request.getParameter("user_name"),
    			request.getParameter("email"),
    			request.getParameter("phone"),
    			request.getParameter("gender"),
    			request.getParameter("birth_date"),
    			request.getParameter("symptom")
//    			,
//    			Integer.parseInt(request.getParameter("user_level"))
    		
    			);

    	log.debug("Update User : {}", updateUser);

		UserManager manager = UserManager.getInstance();
		manager.update(updateUser);			
        return "redirect:/admin/list";			
    }
}
