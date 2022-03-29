package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.medicine.UserSessionUtils;
import model.Medicine;
import model.Post;
import model.Reservation;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;
import model.service.PostManager;
import model.service.ReservationManager;

public class ListMyPostController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
			PostManager postManager = PostManager.getInstance();
			List<Post> post_list = null;

			String content = request.getParameter("user_id");

			post_list = postManager.findPostByUser_id(content);
			
			// postList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
			request.setAttribute("post_list", post_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// 게시글 리스트 화면으로 이동(forwarding)
			return "/post/listMyPost.jsp";        
		
		
	}
}