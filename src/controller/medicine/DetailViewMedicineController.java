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
			medicine = medicineManager.getMedicine(med_id);	// ��ǰ ���� �˻�
		} catch (MedicineNotFoundException e) {				
	        return "redirect:/";
		}	
		
		request.setAttribute("medicine", medicine);	// ��ǰ ���� ����	
		return "/medicine/detailView.jsp";				// ��ǰ ���� ȭ������ �̵�
    }
}
