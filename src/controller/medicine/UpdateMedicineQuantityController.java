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
import model.Post;

public class UpdateMedicineQuantityController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateMedicineQuantityController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	if (request.getMethod().equals("POST")) {	
    	
			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser("somsom", session)) {
				// 현재 로그인한 사용자가 관리자인 경우 -> 수정 가능
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
//				medicineManager.update(updateMed);			
				medicineManager.updateQuantity(updateMed);
				return "redirect:/medicine/admin/list";	  // 검색한 약품 정보를 update form으로 전송     
			}    
			else {
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", new IllegalStateException("관리자가 아닌 경우 수정할 수 없습니다."));            
			return "/medicine/view.jsp";	// 약품 보기 화면으로 이동 (forwarding)
	    }}	
    	
        return "redirect:/medicine/admin/list";			
    }
}
