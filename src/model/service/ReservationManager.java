package model.service;

import java.sql.SQLException;
import java.util.List;

import model.LineItem;
import model.Medicine;
import model.Post;
import model.Reservation;
import model.dao.ReservationDAO;

public class ReservationManager {
	private static ReservationManager reservMan = new ReservationManager();
	private ReservationDAO reservDAO;
	private ReservationManager() {
		try {
			reservDAO = new ReservationDAO();
			new ReservationAnalysis(reservDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ReservationManager getInstance() {
		return reservMan;
	}

	public Reservation findReservation(int reserv_id) throws SQLException, ReservationNotFoundException {
		Reservation reservation = reservDAO.findReservation(reserv_id);

		if (reservation == null) {
			throw new ReservationNotFoundException(reserv_id + "해당하는 예약내역은 존재하지 않습니다.");
		}
		return reservation;
	}

	public List<Reservation> findReservationList() throws SQLException {
		return reservDAO.findReservationList();
	}
	
	public List<Reservation> findReservationListByUser_id(String user_id) throws Exception {
		List<Reservation> reservation_list = ReservationDAO.findReservationListByUser_id(user_id);
		if (reservation_list.isEmpty()) {
			return null;
		}		
		return reservation_list;
}

	public Reservation createReservation(Reservation reservation) throws SQLException {
		System.out.println("createreservation");
		return reservDAO.create_choi(reservation);
	}

	public int updateReservation(Reservation reservation) throws SQLException {
		return reservDAO.update(reservation);
	}

	public int remove(int delete_id) throws SQLException {
		return reservDAO.remove(delete_id);	
	}
	
	public ReservationDAO getReservationDAO() {
		return this.reservDAO;
	}
	
	public List<LineItem> getLineItemsByReservationId(int reserv_id) throws SQLException {
		return reservDAO.getLineItemsByReservationId(reserv_id);
	}

}
