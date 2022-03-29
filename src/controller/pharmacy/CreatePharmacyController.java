package controller.pharmacy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.PharmacyDTO;
import model.service.PharmacyManager;

public class CreatePharmacyController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreatePharmacyController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PharmacyDTO pharmacy = new PharmacyDTO(
    		request.getParameter("pharm_name"),
			request.getParameter("position"));
        
		try {
			PharmacyManager pharmacyManager = PharmacyManager.getInstance();
			pharmacyManager.createPharmacy(pharmacy);
	        return "redirect:/pharmacy/list";	// ������ ��ϵ� �౹ ����Ʈ�� redirection
	        
		} catch (Exception e) {	
			log.debug("Create Pharmacy : {}", pharmacy.getPharm_name());
			// ���� �߻� �� �Է� form���� forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("pharmacy", pharmacy);
			return "/pharmacy/createForm.jsp";
		}
    }
}
