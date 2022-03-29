package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ���� 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;

	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}

	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
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
			int result = jdbcUtil.executeUpdate(); // insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}


	/**
	 * ������ ����� ������ ����.
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
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String user_id) throws SQLException {
		String sql = "DELETE FROM CLIENT WHERE user_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public User findUser(String user_id) throws SQLException {
		String sql = "SELECT user_password, user_name, email, phone, gender, TO_CHAR(birth_date,'YYYYMMDD'), symptom, user_level "
				+ "FROM CLIENT "
				+ "WHERE user_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				User user = new User(		// User ��ü�� �����Ͽ� �л� ������ ����
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
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}


	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<User> findUserList() throws SQLException {
//		String sql = "SELECT user_id, user_no, user_password, user_name, email, phone, gender, birth_date, symptom, user_level "
//				+ "FROM CLIENT "
//				+ "ORDER BY user_no";
		String sql = "SELECT user_id, user_no, user_password, user_name, email, phone, gender, TO_CHAR(birth_date,'YYYYMMDD'), symptom, user_level "
				+ "FROM CLIENT "
				+ "ORDER BY user_no";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			List<User> userList = new ArrayList<User>(); // User���� ����Ʈ ����
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
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ�
	 * �ش��ϴ� ����� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT user_id, user_name, email " 
				+ "FROM CLIENT "
				+ "ORDER BY user_no";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						

		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<User> userList = new ArrayList<User>();	// User���� ����Ʈ ����
				do {
					User user = new User(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
							rs.getString("user_id"),
							rs.getString("user_name"),
							rs.getString("email"));
					userList.add(user);							// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * �־��� ����� ID�� �ش��ϴ� ����ڰ� �����ϴ��� �˻� 
	 */
	public boolean existingUser(String user_id) throws SQLException {
		String sql = "SELECT count(*) FROM CLIENT WHERE user_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}

}
