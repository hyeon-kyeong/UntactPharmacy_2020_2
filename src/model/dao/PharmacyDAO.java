package model.dao;
import java.sql.SQLException;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.PharmacyDTO;

public class PharmacyDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	public PharmacyDAO() {			
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static PharmacyDTO findPharmacy(String pharm_name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PharmacyMapper.class).searchPharmacyByPrimaryKey(pharm_name);			
		} finally {
			sqlSession.close();
		}
	}
		
	public PharmacyDTO create(PharmacyDTO pharmacy) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PharmacyMapper.class).createPharmacy(pharmacy);
			if (result > 0) {
				sqlSession.commit();
			} 
			return pharmacy;
		} finally {
			sqlSession.close();
		}			
	}
	
	public static int remove(String pharm_name) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PharmacyMapper.class).deletePharmacy(pharm_name);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public static List<PharmacyDTO> findPharmacyList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PharmacyMapper.class).ListAllPharmacy();			
		} finally {
			sqlSession.close();
		}
	}

	public boolean existingPharmacyByPharm_name(String pharm_name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PharmacyMapper.class).searchPharmacyByPrimaryKey(pharm_name) != null;			
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	
}