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
	
		if (UserSessionUtils.isLoginUser("somsom", session)){ //로그인한 사용자가 관리자일 경우 삭제 수행 가능
				
			medicineManager.remove(med_id);				// 약품 정보 삭제
			if (UserSessionUtils.isLoginUser("somsom", session))	// 로그인한 사용자가 관리자 	
				return "redirect:/medicine/admin/list";		// 약품 리스트로 이동
			else 								
				return "redirect:/user/logout";		// logout 처리
		}
		
		/* 삭제가 불가능한 경우 */
		Medicine medicine = medicineManager.getMedicine(med_id);	// 약품 정보 검색
		request.setAttribute("medicine", medicine);						
		request.setAttribute("deleteFailed", true);
		String msg = (UserSessionUtils.isLoginUser("somsom", session)) 
				   ? "시스템 관리자가 아닌 경우 삭제할 수 없습니다."		
				   : "관리자만이 삭제할 수 있습니다.";													
		request.setAttribute("exception", new IllegalStateException(msg));            
		return "/medicine/view.jsp";	
	}
}