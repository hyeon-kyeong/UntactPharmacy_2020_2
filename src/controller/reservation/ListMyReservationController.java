package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.medicine.UserSessionUtils;
import model.Medicine;
import model.Reservation;
import model.service.MedicineManager;
import model.service.MedicineNotFoundException;
import model.service.ReservationManager;

public class ListMyReservationController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
			ReservationManager reservationManager = ReservationManager.getInstance();
			List<Reservation> reservation_list = null;

			String content = request.getParameter("user_id");

			reservation_list = reservationManager.findReservationListByUser_id(content);
			
			// reervationList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
			request.setAttribute("reservation_list", reservation_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// 예약 리스트 화면으로 이동(forwarding)
			return "/reservation/listMyReservation.jsp";        
		
		
	}
}