package controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Medicine;
import model.service.MedicineManager;

public class ListAdminMedicineController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 제품 개수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
		MedicineManager medicineManager = MedicineManager.getInstance();
		List<Medicine> medicine_list = medicineManager.findMedicineList();
		// List<Medicine> medList = manager.findMedicineList(currentPage, countPerPage);
		
			request.setAttribute("medicine_list", medicine_list);				
			request.setAttribute("curUserId", 
			UserSessionUtils.getLoginUserId(request.getSession()));	// 약품 리스트 화면으로 이동(forwarding)
			return "/medicine/medListAdmin.jsp";      
		
		  
    }
}
