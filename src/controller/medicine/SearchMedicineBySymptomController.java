package controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Medicine;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;

public class SearchMedicineBySymptomController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 제품 개수

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		try {


			MedicineManager medicineManager = MedicineManager.getInstance();
			List<Medicine> medicine_list = null;

			String content = request.getParameter("symptom");

			medicine_list = medicineManager.findMedicineListBySymptom(content);
			


			//		List<Medicine> medList = manager.findMedicineList();
			// List<Medicine> medList = manager.findMedicineList(currentPage, countPerPage);

			// medList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
			request.setAttribute("medicine_list", medicine_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// 약품 리스트 화면으로 이동(forwarding)
			return "/medicine/listBySymptom.jsp";        
		}catch(Exception e) {
			/* UserNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
			 */
			request.setAttribute("medicineNotFound", true);
			request.setAttribute("exception", new MedicineNotFoundException("약을 찾을 수 없습니다."));
			return "/medicine/listBySymptom.jsp";			
		}	
	}
}
