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
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
    		String updateId = request.getParameter("user_id");
//    		System.out.println("xxxxxxxxxx"+updateId);
    		

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		
    		UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);			
			
			System.out.println(user);

			HttpSession session = request.getSession();
			
			String curUserId = UserSessionUtils.getLoginUserId(session);
			
			
			if (UserSessionUtils.isLoginUser(updateId, session) ||
				UserSessionUtils.isLoginUser("somsom", session)	
//				||
//				UserSessionUtils.isManager(curUserId, session)
				
					) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
								
//				List<Community> commList = manager.findCommunityList();	// 커뮤니티 리스트 검색
//				request.setAttribute("commList", commList);	
				
				return "/admin/updateForm.jsp";   // 검색한 사용자 정보를 update form으로 전송     
			}    
			
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/user/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
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
