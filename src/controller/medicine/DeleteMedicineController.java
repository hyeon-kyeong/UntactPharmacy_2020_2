package controller.medicine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Medicine;
import model.service.MedicineManager;

public class DeleteMedicineController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteMedicineController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String med_id = request.getParameter("med_id");
    	log.debug("Delete Medicine : {}", med_id);

		MedicineManager medicineManager = MedicineManager.getInstance();		
		HttpSession session = request.getSession();	
	
		if (UserSessionUtils.isLoginUser("somsom", session)){ //�α����� ����ڰ� �������� ��� ���� ���� ����
				
			medicineManager.remove(med_id);				// ��ǰ ���� ����
			if (UserSessionUtils.isLoginUser("somsom", session))	// �α����� ����ڰ� ������ 	
				return "redirect:/medicine/admin/list";		// ��ǰ ����Ʈ�� �̵�
			else 								
				return "redirect:/user/logout";		// logout ó��
		}
		
		/* ������ �Ұ����� ��� */
		Medicine medicine = medicineManager.getMedicine(med_id);	// ��ǰ ���� �˻�
		request.setAttribute("medicine", medicine);						
		request.setAttribute("deleteFailed", true);
		String msg = (UserSessionUtils.isLoginUser("somsom", session)) 
				   ? "�ý��� �����ڰ� �ƴ� ��� ������ �� �����ϴ�."		
				   : "�����ڸ��� ������ �� �ֽ��ϴ�.";													
		request.setAttribute("exception", new IllegalStateException(msg));            
		return "/medicine/view.jsp";	
	}
}