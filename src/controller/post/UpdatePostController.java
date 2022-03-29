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
    		// GET request: 커뮤니티 수정 form 요청	
			
			log.debug("UpdateForm Request : {}", post_id);
			
    		PostManager manager = PostManager.getInstance();
    		Post post = manager.findPost(post_id); //수정하려는 게시판 정보 검색
			request.setAttribute("post", post);			
					
			return "/post/updateForm.jsp";   // 검색한 정보를 update form으로 전송     
	    }	
    	
    	// POST request (커뮤니티 정보가 parameter로 전송됨)
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
