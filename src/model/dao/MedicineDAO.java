package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Medicine;

public class MedicineDAO {

private static SqlSessionFactory sqlSessionFactory;
	
	public MedicineDAO() {			
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static List<Medicine> findMedicine(String med_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).searchMedicineByPrimaryKey(med_id);			
		} finally {
			sqlSession.close();
		}
	}
	
	public static Medicine getMedicine(String med_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).findMedicine(med_id);			
		} finally {
			sqlSession.close();
		}
	}
	
	// 약품 수정
	public int update(Medicine medicine) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MedicineMapper.class).updateMedicine(medicine);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// 약품 재고 수정
	public int updateQuantity(Medicine medicine) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MedicineMapper.class).updateMedicineQuantity(medicine);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}
		
	public Medicine create(Medicine Medicine) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MedicineMapper.class).createMedicine(Medicine);
			if (result > 0) {
				sqlSession.commit();
			} 
			return Medicine;
		} finally {
			sqlSession.close();
		}			
	}
	
	public static int remove(String med_id) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MedicineMapper.class).deleteMedicine(med_id);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public static List<Medicine> findMedicineList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).ListAllMedicine();			
		} finally {
			sqlSession.close();
		}
	}
	
	// 증상으로 약 검색
	public static List<Medicine> findMedicineListBySymptom(String symptom) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).searchMedicineListBySymptom(symptom);			
		} finally {
			sqlSession.close();
		}
	}
	
	// 카테고리로 약 검색
	
	public static List<Medicine> findMedicineListByMed_category(String med_category) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).searchMedicineListBySymptom(med_category);			
		} finally {
			sqlSession.close();
		}
	}
	
	// 약품 이름으로 검색
	public static List<Medicine> findMedicineListByMed_name(String med_name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).searchMedicineByMed_name(med_name);			
		} finally {
			sqlSession.close();
		}
	}

	public boolean existingMedicine(String med_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MedicineMapper.class).searchMedicineByPrimaryKey(med_id) != null;			
		} finally {
			sqlSession.close();
		}
	}
	
}