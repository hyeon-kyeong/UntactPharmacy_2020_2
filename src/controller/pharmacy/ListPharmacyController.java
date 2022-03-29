package controller.pharmacy;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.PharmacyDTO;
import model.service.PharmacyManager;

public class ListPharmacyController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	PharmacyManager pharmacyManager = PharmacyManager.getInstance();
    	
		List<PharmacyDTO> pharmacy_list = pharmacyManager.findPharmacyList();
		
		request.setAttribute("pharmacy_list", pharmacy_list); // pharmacyList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		return "/pharmacy/list.jsp";        
    }
}
