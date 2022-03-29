package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.PostManager;

public class DeletePostController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeletePostController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int post_id = Integer.parseInt(request.getParameter("post_id"));
    	log.debug("Delete Post : {}", post_id);

    	PostManager manager = PostManager.getInstance();		

		manager.remove(post_id);				// �Խ��� ���� ����
			return "redirect:/post/list";		// �Խ��� ����Ʈ�� �̵�
	}
}
