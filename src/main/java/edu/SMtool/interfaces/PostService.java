package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Post;

public interface PostService {
	public void addPost();
	public void deletePost();
	public void editPost(Post post);
	public Post getPostById(int idPost);
	public List<Post> getAllPosts();

}
