package controller.pharmacy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.PharmacyDTO;

public class ViewCreatePharmacyController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	PharmacyDTO pharmacy = null;
    	
	    String pharm_name = request.getParameter("pharm_name");		
	    String position = request.getParameter("position");
	
	    pharmacy = new PharmacyDTO(pharm_name, position);
		request.setAttribute("pharmacy", pharmacy);	// �౹ ���� ����
		
		return "/pharmacy/createForm.jsp";				// �౹ ���� ȭ������ �̵�
    }
}
