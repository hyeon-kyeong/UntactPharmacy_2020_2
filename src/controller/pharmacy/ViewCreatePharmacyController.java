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
		request.setAttribute("pharmacy", pharmacy);	// 약국 정보 저장
		
		return "/pharmacy/createForm.jsp";				// 약국 보기 화면으로 이동
    }
}
