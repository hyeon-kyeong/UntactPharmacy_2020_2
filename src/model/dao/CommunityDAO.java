package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Community;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * Community ���̺��� Ŀ�´�Ƽ ������ �߰�, ����, ����, �˻� ���� 
 */
public class CommunityDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public CommunityDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * Ŀ�´�Ƽ ���̺� ���ο� �� ���� (PK ���� Sequence�� �̿��Ͽ� �ڵ� ����)
	 */
	public Community create(Community comm) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommunityMapper.class).insertCommunity(comm);
			if (result > 0) {
				sqlSession.commit();
			} 
			return comm;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * ������ Ŀ�´�Ƽ ������ ����
	 */
	public int update(Community comm) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommunityMapper.class).updateCommunity(comm);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Ŀ�´�Ƽ�� ȸ���� ����  
	 */
	public int updateChair(Community comm) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommunityMapper.class).updateChair(comm);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * �־��� ID�� �ش��ϴ� Ŀ�´�Ƽ ������ ����.
	 */
	public int remove(int commId) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommunityMapper.class).deleteCommunity(commId);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * �־���  ID�� �ش��ϴ� Ŀ�´�Ƽ ������ �����ͺ��̽����� ã�� Community ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public Community findCommunity(int commId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommunityMapper.class).selectCommunityByPrimaryKey(commId);			
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * �־���  ID�� �ش��ϴ� Ŀ�´�Ƽ ������ �����ͺ��̽����� ã�� Community ������ Ŭ������ 
	 * �����ϰ�, ���ÿ� �� Ŀ�´�Ƽ�� ���� ��� ȸ������ ������ ã�� List<UserInfo> �� �����Ͽ� �Բ� ��ȯ��  
	 */
	public Community findCommunityWithMembers(int commId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommunityMapper.class).selectCommunityWithMembers(commId);			
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * ��ü Ŀ�´�Ƽ ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Community> findCommunityList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommunityMapper.class).selectAllCommunities();			
		} finally {
			sqlSession.close();
		}
	}
	
}
