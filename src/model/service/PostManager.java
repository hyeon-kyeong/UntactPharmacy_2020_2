package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Medicine;
import model.Post;
import model.dao.PostDAO;

public class PostManager {
	
	private static PostManager postMan = new PostManager();
	
	private PostDAO postDAO;
	private PostManager() {
		try {
			postDAO = new PostDAO();
			new PostAnalysis(postDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PostManager getInstance() {
		return postMan;
	}

	public Post findPost(int post_id) throws SQLException, PostNotFoundException {
		Post post = postDAO.findPost(post_id);

		if (post == null) {
			throw new PostNotFoundException(post_id + "는 존재하지 않는 게시글 입니다.");
		}
		return post;
	}

	public List<Post> findPostList() throws SQLException {
		return postDAO.findPostList();
	}
	
	public List<Post> findPostByUser_id(String user_id)
			throws Exception {
			List<Post> post_list = PostDAO.findPostByUser_id(user_id);
			if (post_list.isEmpty()) {
//				throw new Exception(user_id + "로 작성된 게시글이 없습니다.");
				return null;
			}		
			return post_list;
		}

	public Post createPost(Post post) throws SQLException {
		return postDAO.create(post);
	}

	public int updatePost(Post post) throws SQLException {
		return postDAO.update(post);
	}

	public int remove(int delete_id) throws SQLException {
		return postDAO.remove(delete_id);	
	}
	
	public PostDAO getPostDAO() {
		return this.postDAO;
	}

}
