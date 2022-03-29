package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.LineItem;
import model.Medicine;
import model.Reservation;

public class ReservationDAO {
	private static SqlSessionFactory sqlSessionFactory;

    public ReservationDAO() {
        String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


	public Reservation create(Reservation reservation) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("reservation create");
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).insertReservation(reservation);
			System.out.println("reservation create");

			if (result > 0) {
				sqlSession.commit();
			} 
			return reservation;
		} finally {
			sqlSession.close();
		}
	}
	
	public Reservation create_choi(Reservation reservation) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).insertReservation(reservation);
			
			for (int i = 0; i < reservation.getLineItems().size(); i++) {
				LineItem lineitem = (LineItem) reservation.getLineItems().get(i);
				lineitem.setReserv_id(Integer.toString(reservation.getReserv_id()));
//				lineitem.setPrice(0);
//				lineitem.setQuantity(0);
//				lineitem.setTotal_price(0);
				sqlSession.getMapper(LineItemMapper.class).insertLineItem(lineitem);
			}
			System.out.println("reservation create");

			if (result > 0) {
				sqlSession.commit();
			} 
			return reservation;
		} finally {
			sqlSession.close();
		}
	}
	
	
	public int update(Reservation reservation) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).updateReservation(reservation);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}
	

	public int remove(int reserv_id) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).deleteReservation(reserv_id);
			List<LineItem> li = sqlSession.getMapper(LineItemMapper.class).getLineItemsByReservationId(reserv_id);
			
			for (int i = 0; i < li.size(); i++) {
				LineItem lineitem = (LineItem) li.get(i);
				Medicine medicine = sqlSession.getMapper(MedicineMapper.class).findMedicine(li.get(i).getMed_id());
				medicine.setQuantity(medicine.getQuantity() + li.get(i).getQuantity());
				sqlSession.getMapper(MedicineMapper.class).updateMedicineQuantity(medicine);
				sqlSession.getMapper(LineItemMapper.class).deleteLineItem(lineitem);
			}
			
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}

	public Reservation findReservation(int reserv_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectReservation(reserv_id);			
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	public static List<Reservation> findReservationListByUser_id(String user_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ReservationMapper.class).findReservationListByUser_id(user_id);			
		} finally {
			sqlSession.close();
		}
	}
	

	public List<Reservation> findReservationList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectAllResrvations();			
		} finally {
			sqlSession.close();
		}
	}
	
	public List<LineItem> getLineItemsByReservationId(int reserv_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(LineItemMapper.class).getLineItemsByReservationId(reserv_id);			
		} finally {
			sqlSession.close();
		}
	}
}
