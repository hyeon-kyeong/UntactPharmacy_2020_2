package controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ReservationManager;
import model.Reservation;

public class UpdateReservationController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateReservationController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int reserv_id = Integer.parseInt(request.getParameter("reserv_id"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: Ŀ�´�Ƽ ���� form ��û	
			
			log.debug("UpdateForm Request : {}", reserv_id);
			
			ReservationManager manager = ReservationManager.getInstance();
			Reservation reservation = manager.findReservation(reserv_id); //�����Ϸ��� �Խ��� ���� �˻�
			request.setAttribute("reservation", reservation);			
					
			return "/reservation/updateForm.jsp";   // �˻��� ������ update form���� ����     
	    }	
    	
    	// POST request (Ŀ�´�Ƽ ������ parameter�� ���۵�)
		Reservation updateReservation = new Reservation(
			reserv_id,
			request.getParameter("user_id"),
			request.getParameter("med_id"),
			request.getParameter("pharm_name"),
			request.getParameter("reserv_date"),
			request.getParameter("address"));
		
    	log.debug("Update Reservation : {}", updateReservation);

    	ReservationManager manager = ReservationManager.getInstance();
		manager.updateReservation(updateReservation);			
        return "redirect:/reservation/list";			
    }
}
