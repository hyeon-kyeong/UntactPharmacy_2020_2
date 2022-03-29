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
		
		request.setAttribute("pharmacy_list", pharmacy_list); // pharmacyList ��ü�� request�� �����Ͽ� Ŀ�´�Ƽ ����Ʈ ȭ������ �̵�(forwarding)
		return "/pharmacy/list.jsp";        
    }
}
