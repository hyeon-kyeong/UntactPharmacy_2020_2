package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Medicine;
import model.Post;

public class PostDAO {
	private static SqlSessionFactory sqlSessionFactory;

    public PostDAO() {
        String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//	�Խù� ����
	public Post create(Post post) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).insertPost(post);
			if (result > 0) {
				sqlSession.commit();
			} 
			return post;
		} finally {
			sqlSession.close();
		}
	}
	

//     �Խù� ���� ����
	public int update(Post post) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).updatePost(post);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
//		�Խù� ����
	public int remove(int post_id) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).deletePost(post_id);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
//	�Խù� ����
	public Post findPost(int post_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PostMapper.class).selectPost(post_id);			
		} finally {
			sqlSession.close();
		}
	}
	
	public static List<Post> findPostByUser_id(String user_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PostMapper.class).findPostByUser_id(user_id);			
		} finally {
			sqlSession.close();
		}
	}
	
//     �Խù� ��ü ��� ����
	public List<Post> findPostList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(PostMapper.class).selectAllPosts();			
		} finally {
			sqlSession.close();
		}
	}

}
