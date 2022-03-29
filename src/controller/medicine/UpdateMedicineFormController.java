package controller.medicine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.MedicineManager;
import model.Medicine;

public class UpdateMedicineFormController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateMedicineFormController.class);

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String med_id = request.getParameter("med_id");
		
		log.debug("UpdateForm Request : {}", med_id);

		MedicineManager medicineManager = MedicineManager.getInstance();
		Medicine medicine = medicineManager.getMedicine(med_id);	// ������Ʈ �� ��ǰ �˻�
		request.setAttribute("medicine", medicine);						
		
		HttpSession session = request.getSession();
		if (UserSessionUtils.isLoginUser("somsom", session)) {
			// ���� �α����� ����ڰ� �������� ��� -> ���� ����
			
			return "/medicine/updateForm.jsp";   // �˻��� �������� update form���� ����     
		}
		
		// else (���� �Ұ����� ���) ��ǰ ����Ʈ ȭ������ ���� �޼����� ����
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", 
			new IllegalStateException("�����ڰ� �ƴ� ��� ������ �� �����ϴ�."));            
		return "/medicine/view.jsp";	// ��ǰ ����Ʈ ȭ������ �̵� (forwarding)
    }
}
