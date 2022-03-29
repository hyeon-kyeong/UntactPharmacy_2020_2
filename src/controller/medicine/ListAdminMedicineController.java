package controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Medicine;
import model.service.MedicineManager;

public class ListAdminMedicineController implements Controller {
	// private static final int countPerPage = 100;	// �� ȭ�鿡 ����� ��ǰ ����

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
		MedicineManager medicineManager = MedicineManager.getInstance();
		List<Medicine> medicine_list = medicineManager.findMedicineList();
		// List<Medicine> medList = manager.findMedicineList(currentPage, countPerPage);
		
			request.setAttribute("medicine_list", medicine_list);				
			request.setAttribute("curUserId", 
			UserSessionUtils.getLoginUserId(request.getSession()));	// ��ǰ ����Ʈ ȭ������ �̵�(forwarding)
			return "/medicine/medListAdmin.jsp";      
		
		  
    }
}
