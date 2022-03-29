package model.dao;

import java.util.List;

import model.Post;

public interface PostMapper {

	public int insertPost(Post post);
	
	public int updatePost(Post post);
	
	public int deletePost(int post_id);
	
	public Post selectPost(int post_id);
	
	public List<Post> findPostByUser_id(String user_id);
	
	public List<Post> selectAllPosts();

}
