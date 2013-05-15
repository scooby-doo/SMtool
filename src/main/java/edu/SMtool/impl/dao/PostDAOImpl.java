package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Post;
import edu.SMtool.interfaces.dao.PostDAO;

@Repository
public class PostDAOImpl implements PostDAO {

	private static final long serialVersionUID = -2064131778227811761L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addPost(Post post) {
		sessionFactory.getCurrentSession().saveOrUpdate(post);
	}

	@Override
	@Transactional
	public void deletePost(Post post) {
		sessionFactory.getCurrentSession().delete(post);
	}

	@Override
	@Transactional
	public void editPost(Post post) {
		sessionFactory.getCurrentSession().update(post);
	}

	@Override
	@Transactional
	public Post getPostById(int idPost) {
		Post post = (Post) sessionFactory.getCurrentSession().get(Post.class, idPost);
		return post;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> getAllPosts() {
		List<Post> postList = sessionFactory.getCurrentSession().createQuery("from Post").list();
		return postList;
	}

}
