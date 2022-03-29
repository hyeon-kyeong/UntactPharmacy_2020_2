package controller.pharmacy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.PharmacyManager;

public class DeletePharmacyController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeletePharmacyController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String delete_id = request.getParameter("pharm_name");
    	log.debug("Delete Pharmacy : {}", delete_id);

    	PharmacyManager manager = PharmacyManager.getInstance();		

		manager.remove(delete_id);			// �౹ ���� ����
		return "redirect:/pharmacy/list";		// �౹ ����Ʈ�� �̵�
	}
}
