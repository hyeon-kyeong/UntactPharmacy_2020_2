package controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ReservationManager;

public class DeleteReservationController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteReservationController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int reserv_id = Integer.parseInt(request.getParameter("reserv_id"));
    	log.debug("Delete Reservation : {}", reserv_id);

    	ReservationManager manager = ReservationManager.getInstance();		

		manager.remove(reserv_id);				// 게시판 정보 삭제
			return "redirect:/reservation/list";		// 게시판 리스트로 이동
	}
}
