package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Post;
import edu.SMtool.interfaces.PostService;
import edu.SMtool.interfaces.dao.PostDAO;

@Service("postService")
public class PostServiceImpl implements PostService {

	private static final long serialVersionUID = -7388582200613936660L;
	
	@Autowired
	PostDAO postDAO;

	@Override
	public void addPost(Post post) {
		postDAO.addPost(post);
	}

	@Override
	public void deletePost(Post post) {
		postDAO.deletePost(post);
	}

	@Override
	public void editPost(Post post) {
		postDAO.editPost(post);
	}

	@Override
	public Post getPostById(int idPost) {
		return postDAO.getPostById(idPost);
	}

	@Override
	public List<Post> getAllPosts() {
		return postDAO.getAllPosts();
	}

}
