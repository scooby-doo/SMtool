package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Post;

public interface PostDAO extends Serializable {
	public void addPost(Post post);
	public void deletePost(Post post);
	public void editPost(Post post);
	public Post getPostById(int idPost);
	public List<Post> getAllPosts();

}
