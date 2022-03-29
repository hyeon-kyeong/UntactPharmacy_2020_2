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
		Medicine medicine = medicineManager.getMedicine(med_id);	// 업데이트 할 약품 검색
		request.setAttribute("medicine", medicine);						
		
		HttpSession session = request.getSession();
		if (UserSessionUtils.isLoginUser("somsom", session)) {
			// 현재 로그인한 사용자가 관리자인 경우 -> 수정 가능
			
			return "/medicine/updateForm.jsp";   // 검색한 약정보를 update form으로 전송     
		}
		
		// else (수정 불가능한 경우) 약품 리스트 화면으로 오류 메세지를 전달
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", 
			new IllegalStateException("관리자가 아닌 경우 수정할 수 없습니다."));            
		return "/medicine/view.jsp";	// 약품 리스트 화면으로 이동 (forwarding)
    }
}
