package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.medicine.UserSessionUtils;
import model.Reservation;
import model.service.ReservationManager;

public class ListReservationController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		ReservationManager manager = ReservationManager.getInstance();
		List<Reservation> reservation_list = manager.findReservationList();
		// ReservationList ��ü�� request�� �����Ͽ� Ŀ�´�Ƽ ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("reservation_list", reservation_list);			
		
	    request.setAttribute("curUserId", 
	    		UserSessionUtils.getLoginUserId(request.getSession())); 
	     
		return "/reservation/list.jsp";        
    }
}
