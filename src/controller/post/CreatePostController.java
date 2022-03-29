package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Post;
import model.service.PostManager;

public class CreatePostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreatePostController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Post post = new Post(
    		0, request.getParameter("user_id"),
			request.getParameter("med_id"),
			request.getParameter("post_date"),
			request.getParameter("title"),
			request.getParameter("content"),
			request.getParameter("ingestion_start"),
			request.getParameter("ingestion_end"));		

		try {
			PostManager manager = PostManager.getInstance();
			manager.createPost(post);
			
	    	log.debug("Create Psot : {}", post);
	        return "redirect:/post/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("post", post);
			return "/post/creationForm.jsp";
		}
    }
}
