package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.Post;

public class ViewPostController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Post post = null;
		PostManager manager = PostManager.getInstance();
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		post = manager.findPost(post_id);		// �Խ��� ���� �˻�			
		
		request.setAttribute("post", post);	// �Խ��� ���� ����				
		return "/post/view.jsp";				// �Խ��� ���� ȭ������ �̵�
    }
}
