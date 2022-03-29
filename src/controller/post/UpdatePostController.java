package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.PostManager;
import model.Post;

public class UpdatePostController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdatePostController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: Ŀ�´�Ƽ ���� form ��û	
			
			log.debug("UpdateForm Request : {}", post_id);
			
    		PostManager manager = PostManager.getInstance();
    		Post post = manager.findPost(post_id); //�����Ϸ��� �Խ��� ���� �˻�
			request.setAttribute("post", post);			
					
			return "/post/updateForm.jsp";   // �˻��� ������ update form���� ����     
	    }	
    	
    	// POST request (Ŀ�´�Ƽ ������ parameter�� ���۵�)
		Post updatePost = new Post(
			post_id,
			request.getParameter("user_id"),
			request.getParameter("med_id"),
			request.getParameter("post_date"),
			request.getParameter("title"),
			request.getParameter("content"),
			request.getParameter("ingestion_start"),
			request.getParameter("ingestion_start"));
		
    	log.debug("Update Post : {}", updatePost);

		PostManager manager = PostManager.getInstance();
		manager.updatePost(updatePost);			
        return "redirect:/post/list";			
    }
}
