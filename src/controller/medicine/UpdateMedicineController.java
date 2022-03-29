package controller.medicine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.MedicineManager;
import model.Medicine;

public class UpdateMedicineController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateMedicineController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	String med_id = request.getParameter("med_id");
    	if (request.getMethod().equals("GET")) {	
    	
    		log.debug("UpdateForm Request : {}", med_id);
    		
    		MedicineManager medicineManager = MedicineManager.getInstance();
			Medicine medicine = medicineManager.getMedicine(med_id);	// �����Ϸ��� ��ǰ ���� �˻�
			request.setAttribute("medicine", medicine);			

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser("somsom", session)) {
				// ���� �α����� ����ڰ� �������� ��� -> ���� ����
				return "/medicine/updateForm.jsp";   // �˻��� ��ǰ ������ update form���� ����     
			}    
			
			// else (���� �Ұ����� ���) ��ǰ ���� ȭ������ ���� �޼����� ����
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", new IllegalStateException("�����ڰ� �ƴ� ��� ������ �� �����ϴ�."));            
			return "/medicine/view.jsp";	// ��ǰ ���� ȭ������ �̵� (forwarding)
	    }	
    	
   	// POST request 
    	Medicine updateMed = new Medicine(
    			request.getParameter("med_id"),
    	        request.getParameter("med_name"),
    	        request.getParameter("symptom"),
    	        request.getParameter("co_name"),
    	        request.getParameter("med_category"),
    	        Integer.parseInt(request.getParameter("price")),
    	        Integer.parseInt(request.getParameter("quantity")));

    	log.debug("Update Medicine : {}", updateMed);

		MedicineManager medicineManager = MedicineManager.getInstance();
		medicineManager.update(updateMed);			
        return "redirect:/medicine/admin/list";			
    }
}
