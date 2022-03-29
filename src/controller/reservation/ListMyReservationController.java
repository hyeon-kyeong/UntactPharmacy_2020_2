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
			
			// reervationList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
			request.setAttribute("reservation_list", reservation_list);	
			request.setAttribute("curUserId", 
					UserSessionUtils.getLoginUserId(request.getSession()));		

			// ���� ����Ʈ ȭ������ �̵�(forwarding)
			return "/reservation/listMyReservation.jsp";        
		
		
	}
}