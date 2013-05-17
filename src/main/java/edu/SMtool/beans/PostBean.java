package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Post;
import edu.SMtool.interfaces.PostService;

@Component
public class PostBean implements Serializable {

	private static final long serialVersionUID = 7594062054020573671L;
	private List<Post> postList;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@PostConstruct
	public void init(){
		postList = postService.getAllPosts();
	}
	
	public void onEdit(RowEditEvent event){
		Post newValue = (Post) event.getObject();
		postService.editPost(newValue);
	}
	
	public void addNewPost(){
		Post newPost = new Post();
		newPost.setIdCampaign(serviceUtils.getDefaultCampaign());
		postService.addPost(newPost);
		postList.add(newPost);
	}
	
	public void removePost(Post post){
		postService.deletePost(post);
		postList.remove(post);
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	
	

}
