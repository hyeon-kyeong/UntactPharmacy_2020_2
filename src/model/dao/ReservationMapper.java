package model.dao;

import java.util.List;

import model.Reservation;

public interface ReservationMapper {

	public int insertReservation(Reservation reservation);
	
	public int updateReservation(Reservation reservation);
	
	public int deleteReservation(int reserv_id);
	
	public Reservation selectReservation(int reserv_id);
	
	public List<Reservation> findReservationListByUser_id(String user_id);
	
	public List<Reservation> selectAllResrvations();
}
