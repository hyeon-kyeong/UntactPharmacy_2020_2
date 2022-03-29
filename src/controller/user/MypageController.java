package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.medicine.UserSessionUtils;
import model.Medicine;
import model.Post;
import model.Reservation;
import model.User;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;
import model.service.PostManager;
import model.service.ReservationManager;
import model.service.UserManager;
import model.service.UserNotFoundException;

public class MypageController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		PostManager postManager = PostManager.getInstance();
		List<Post> post_list = null;

		String content = request.getParameter("user_id");
		UserManager manager = UserManager.getInstance();
		
    	User user = null;
		try {
			user = manager.findUser(content);	// ����� ���� �˻�
		} catch (UserNotFoundException e) {				
	        return "/index.jsp";
		}	
		

		post_list = postManager.findPostByUser_id(content);
		
		
			ReservationManager reservationManager = ReservationManager.getInstance();
			List<Reservation> reservation_list = null;

			content = request.getParameter("user_id");

			reservation_list = reservationManager.findReservationListByUser_id(content);
			
			
			request.setAttribute("user", user);		// ����� ���� ����		
			request.setAttribute("post_list", post_list);	
			request.setAttribute("reservation_list", reservation_list);	
			request.setAttribute("curUserId", 
			UserSessionUtils.getLoginUserId(request.getSession()));		

			// ���� ����Ʈ ȭ������ �̵�(forwarding)
			return "/user/mypage.jsp";        
		
		
	}
}