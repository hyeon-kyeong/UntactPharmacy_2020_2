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
	        return "redirect:/post/list";	// ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
	        
		} catch (Exception e) {		// ���� �߻� �� �Է� form���� forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("post", post);
			return "/post/creationForm.jsp";
		}
    }
}
