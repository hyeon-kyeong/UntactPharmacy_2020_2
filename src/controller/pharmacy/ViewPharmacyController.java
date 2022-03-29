package controller.pharmacy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PharmacyManager;
import model.PharmacyDTO;

public class ViewPharmacyController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	PharmacyDTO pharmacy = null;
		PharmacyManager manager = PharmacyManager.getInstance();
		String pharm_name = request.getParameter("pharm_name");
		
		pharmacy = manager.findPharmacy(pharm_name);		// �౹ ���� �˻�			
		
		request.setAttribute("pharmacy", pharmacy);	// �౹ ���� ����				
		return "/pharmacy/view.jsp";				// �౹ ���� ȭ������ �̵�
    }
}
