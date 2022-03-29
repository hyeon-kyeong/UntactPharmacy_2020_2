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
	        return "redirect:/pharmacy/list";	// 성공시 등록된 약국 리스트로 redirection
	        
		} catch (Exception e) {	
			log.debug("Create Pharmacy : {}", pharmacy.getPharm_name());
			// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("pharmacy", pharmacy);
			return "/pharmacy/createForm.jsp";
		}
    }
}
