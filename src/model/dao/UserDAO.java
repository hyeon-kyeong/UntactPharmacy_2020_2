package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;

	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(User user) throws SQLException{

		String sql = "INSERT INTO CLIENT VALUES (?, userno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 1) ";
		Object[] param = new Object[]	{	
				user.getUser_id(), 
				user.getUser_password(), 
				user.getUser_name(), 
				user.getEmail(), 
				user.getPhone(), 
				user.getGender(), 
				user.getBirth_date(), 
				user.getSymptom()};
		jdbcUtil.setSqlAndParameters(sql, param);
		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}


	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(User user) throws SQLException {
		String sql = "UPDATE CLIENT "
				+ "SET user_password=?, user_name=?, email=?, phone=?, gender=?, birth_date=?, symptom=? "
				+ "WHERE user_id=?";
		Object[] param = new Object[] {
				user.getUser_password(), 
				user.getUser_name(), 
				user.getEmail(), 
				user.getPhone(), 
				user.getGender(), 
				user.getBirth_date(), 
				user.getSymptom(), 
				user.getUser_id()};			
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String user_id) throws SQLException {
		String sql = "DELETE FROM CLIENT WHERE user_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public User findUser(String user_id) throws SQLException {
		String sql = "SELECT user_password, user_name, email, phone, gender, TO_CHAR(birth_date,'YYYYMMDD'), symptom, user_level "
				+ "FROM CLIENT "
				+ "WHERE user_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				User user = new User(		// User 객체를 생성하여 학생 정보를 저장
						user_id,
						rs.getString("user_password"),
						rs.getString("user_name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("gender"),
						rs.getString("TO_CHAR(birth_date,'YYYYMMDD')"),
						rs.getString("symptom"),
						rs.getInt("user_level"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}


	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<User> findUserList() throws SQLException {
//		String sql = "SELECT user_id, user_no, user_password, user_name, email, phone, gender, birth_date, symptom, user_level "
//				+ "FROM CLIENT "
//				+ "ORDER BY user_no";
		String sql = "SELECT user_id, user_no, user_password, user_name, email, phone, gender, TO_CHAR(birth_date,'YYYYMMDD'), symptom, user_level "
				+ "FROM CLIENT "
				+ "ORDER BY user_no";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<User> userList = new ArrayList<User>(); // User들의 리스트 생성
			while (rs.next()) {

				User user = new User(
						rs.getString("user_id"),
						rs.getString("user_no"), 
						rs.getString("user_password"), 
						rs.getString("user_name"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getString("gender"), 
						rs.getString("TO_CHAR(birth_date,'YYYYMMDD')"), 
						rs.getString("symptom"), 
						rs.getInt("user_level"));
				userList.add(user);
			}
			return userList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT user_id, user_name, email " 
				+ "FROM CLIENT "
				+ "ORDER BY user_no";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						

		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
				do {
					User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
							rs.getString("user_id"),
							rs.getString("user_name"),
							rs.getString("email"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String user_id) throws SQLException {
		String sql = "SELECT count(*) FROM CLIENT WHERE user_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
