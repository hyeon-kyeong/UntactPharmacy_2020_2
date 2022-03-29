package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReservationManager;
import model.LineItem;
import model.Reservation;

public class ViewReservationController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

		Reservation reservation = null;
		ReservationManager manager = ReservationManager.getInstance();
		int reserv_id = Integer.parseInt(request.getParameter("reserv_id"));
		reservation = manager.findReservation(reserv_id);

		List<LineItem> lineitem_list = manager.getLineItemsByReservationId(reserv_id);

		System.out.println(lineitem_list);

		request.setAttribute("reservation", reservation);
		request.setAttribute("lineitem_list", lineitem_list);

		return "/reservation/view.jsp";			// ���� ���� ȭ������ �̵�
	}
}
