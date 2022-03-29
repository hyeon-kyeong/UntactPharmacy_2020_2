package controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Medicine;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;

public class SearchMedicineBySymptomController implements Controller {
	// private static final int countPerPage = 100;	// �� ȭ�鿡 ����� ��ǰ ����

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		try {


			MedicineManager medicineManager = MedicineManager.getInstance();
			List<Medicine> medicine_list = null;

			String content = request.getParameter("symptom");

			medicine_list = medicineManager.findMedicineListBySymptom(content);
			


			//		List<Medicine> medList = manager.findMedicineList();
			// List<Medicine> medList = manager.findMedicineList(currentPage, countPerPage);

			// medList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
			request.setAttribute("medicine_list", medicine_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// ��ǰ ����Ʈ ȭ������ �̵�(forwarding)
			return "/medicine/listBySymptom.jsp";        
		}catch(Exception e) {
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
			request.setAttribute("medicineNotFound", true);
			request.setAttribute("exception", new MedicineNotFoundException("���� ã�� �� �����ϴ�."));
			return "/medicine/listBySymptom.jsp";			
		}	
	}
}
