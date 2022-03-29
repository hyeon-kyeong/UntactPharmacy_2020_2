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
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/admin/login/form";		// login form 요청으로 redirect
        }
    	
    	
		UserManager manager = UserManager.getInstance();
		String user_id = request.getParameter("user_id");
		
    	User user = null;
		try {
			user = manager.findUser(user_id);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/admin/list";
		}	
		
		request.setAttribute("user", user);		// 사용자 정보 저장				
		return "/admin/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
