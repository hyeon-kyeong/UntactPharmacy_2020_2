package controller.medicine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;
import model.Medicine;

public class DetailViewMedicineController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
		MedicineManager medicineManager = MedicineManager.getInstance();
		String med_id = request.getParameter("med_id");
		
    	Medicine medicine = null;
		try {
			medicine = medicineManager.getMedicine(med_id);	// 약품 정보 검색
		} catch (MedicineNotFoundException e) {				
	        return "redirect:/";
		}	
		
		request.setAttribute("medicine", medicine);	// 약품 정보 저장	
		return "/medicine/detailView.jsp";				// 약품 보기 화면으로 이동
    }
}
