package controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Medicine;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;

public class SearchMedicineController implements Controller {
	// private static final int countPerPage = 100;	// �� ȭ�鿡 ����� ��ǰ ����

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		try {


			MedicineManager medicineManager = MedicineManager.getInstance();
			List<Medicine> medicine_list = null;

			String select = request.getParameter("select");
			String content = request.getParameter("search");
			System.out.println(select);
			System.out.println(content);

			switch(select) {
			case "id":
				medicine_list = medicineManager.findMedicineListById(content);
				break;
			case "name":
				medicine_list = medicineManager.findMedicineListByName(content);
				break;
			case "symptom":
				medicine_list = medicineManager.findMedicineListBySymptom(content);
				break;
			case "category":
				medicine_list = medicineManager.findMedicineListByCategory(content);
				break;
			default:
				break;
			}


			//		List<Medicine> medList = manager.findMedicineList();
			// List<Medicine> medList = manager.findMedicineList(currentPage, countPerPage);

			// medList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
			request.setAttribute("medicine_list", medicine_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// ��ǰ ����Ʈ ȭ������ �̵�(forwarding)
			return "/search/medSearchForm.jsp";        
		}catch(Exception e) {
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
			request.setAttribute("medicineNotFound", true);
			request.setAttribute("exception", new MedicineNotFoundException("���� ã�� �� �����ϴ�."));
			return "/search/medSearchForm.jsp";			
		}	
	}
}
