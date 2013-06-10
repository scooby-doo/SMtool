package edu.SMtool.socialNetworks;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.stereotype.Component;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;

import edu.SMtool.entity.Event;
import edu.SMtool.entity.FacebookObject;
import edu.SMtool.entity.Post;
import edu.SMtool.interfaces.EventService;
import edu.SMtool.interfaces.PostService;

@Component
@RemoteProxy(name="facebookBean")
public class FacebookBean implements Serializable{
	
	/**
	 * 
	 */
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private EventService eventService;
	
	private static final long serialVersionUID = -7850775153972751371L;
	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAMmhZC51EPtMgvaAYjZAChIj1TJEoBZCJCICWbq8SLiLRiVJ2aW08Pn7gXzTdkNhy4vfE7EZBLhhPTOcRFwBHspQGcLKE4OaJsZCp8RiMPMtEBUVYZCPjX2MBrzgWZAEjP2JAFMVZADHTZCvSov79fIPgZAWAyKApBbAZDZD";
	private static final String APP_ID = "377737765678750";
	private static final String APP_SECRET = "79f359aff8466938a83e2805ca06816f";
	private FacebookClient facebookClient;
	

	private FacebookObject facebookObject;
	
	private String accessToken;
	private String info = "default";
	private List<Page> pages = new ArrayList<Page>();
	private Post post;
	private String pageName;
	private Event event = new Event();
	

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getAccessToken() {
		return accessToken;
	}
	
	/*@PostConstruct
	public void init(){
		getUserPages();
	}*/
	
	@RemoteMethod
	public void processData(String accessToken){
		facebookObject = new FacebookObject();
		facebookObject.setAccessToken(accessToken);
		System.out.println("access token is");
		System.out.println(facebookObject.getAccessToken());
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void getUserPages(){
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		Connection<Page> myPages = facebookClient.fetchConnection("me/accounts", Page.class);
		for(List<Page> myPage: myPages) {
			for(Page page : myPage){
				pages.add(page);
			}
		}
	}
	
	public void selectPost(String id){
		post = postService.getPostById(Integer.parseInt(id));
		setPost(post);
	}
	
	public void postOnPage(String pageReceived){
		System.out.println("post is");
		System.out.println(getPost().getContent());
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		Connection<Page> myPages = facebookClient.fetchConnection("me/accounts", Page.class);
		
		
		
		for(List<Page> myPage: myPages) {
			for(Page page : myPage){
				if (pageReceived.equals(page.getName())) {
					String pageId = page.getId();
					FacebookClient facebookPageClient = new DefaultFacebookClient(page.getAccessToken());
					facebookPageClient.publish(pageId+"/feed", FacebookType.class, 
							Parameter.with("message", getPost().getContent()),
							Parameter.with("link", getPost().getLink())			
							);
				}
			}
		}
	}
	
	public void selectEvent(String id){
		System.out.println("id event "+id);
		event = eventService.getEventById(Integer.parseInt(id));
		System.out.println("event is ");
		System.out.println(event.getDescription());
		setEvent(event);
	}
	
	public void eventOnPage(String pageName){
		System.out.println(getEvent().getName());
		System.out.println(getEvent().getStartDate());
		System.out.println(getEvent().getEndDate());
		System.out.println("page name"+pageName);
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		Connection<Page> myPages = facebookClient.fetchConnection("me/accounts", Page.class);
		for(List<Page> myPage: myPages) {
			for(Page page : myPage){
				if (pageName.equals(page.getName())) {
					String pageId = page.getId();
					FacebookClient facebookPageClient = new DefaultFacebookClient(page.getAccessToken());
					facebookPageClient.publish(pageId+"/events", FacebookType.class,
							  Parameter.with("name", getEvent().getName()), 
							  Parameter.with("start_time", getEvent().getStartDate()),
							  Parameter.with("end_time", getEvent().getEndDate())						  
							);
							
				}
			}
		}
		
		
		
	}
	
	/*public void getPageInfo(){
		AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
		facebookClient = new DefaultFacebookClient(accessTOKEN.getAccessToken());
		Page page = facebookClient.fetchObject(pageName, Page.class);
		System.out.println("Page likes: " + page.getLikes());
		setInfo("Page about: "+ page.getAbout());
	}
	*/
	/*public void publishPost(String post1){
		//String tokenviafunction = autoritzacion();
		System.out.println("token via function");
		
		//AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
		///String access_token = accessTOKEN.getAccessToken();
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		Connection<Page> myPages = facebookClient.fetchConnection("me/pages", Page.class);
		for(List<Page> myPage: myPages) {
			for(Page page : myPage){
				System.out.println("Page " + page);
			}
		}
		FacebookType publishMessage = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", post1));
		System.out.println("published message ID: " + publishMessage.getId());
	}
	
	public void publishEvent(Event event){
		AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
		facebookClient = new DefaultFacebookClient(accessTOKEN.getAccessToken());
		Date startDate = event.getStartDate();
		Date endDate = event.getEndDate();
		String name = event.getName();
		FacebookType publishEventResponse = facebookClient.publish("me/events", FacebookType.class,
		  Parameter.with("name", name), Parameter.with("start_time", startDate),
		    Parameter.with("end_time", endDate));
		System.out.println("published event id" + publishEventResponse.getId());
	}
	
	
	
	private String autoritzacion(){

	    String accessTokenUrl ="https://graph.facebook.com/oauth/access_token?type=client_id="+APP_ID+"&client_secret="+APP_SECRET+"&SCOPE=manage_pages,read_stream,user_about_me,user_location,gender,user_birthday,user_education_history,read_friendlists";


	    String accessToken = null;
	    Integer expires = 0;
	    BufferedReader in = null;
	    try {
	            URL url = new URL(accessTokenUrl);
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            URLConnection yc = url.openConnection();
	            InputStream is = url.openStream();
	            int r;
	            while ((r = is.read()) != -1) {
	                    baos.write(r);
	            }
	            String s = new String(baos.toByteArray());

	            String[] pairs = s.split("&");
	            for (String pair : pairs) {
	                    String[] kv = pair.split("=");
	                    if (kv.length != 2) {
	                            throw new RuntimeException("Unexpected auth response");
	                    } else {
	                            if (kv[0].equals("access_token")) {
	                                    accessToken = kv[1];
	                            }
	                            if (kv[0].equals("expires")) {
	                                    expires = Integer.valueOf(kv[1]);
	                            }
	                    }
	            }

	    } // end try

	    catch (Exception e) {
	        e.printStackTrace();
	        return "401 Error intentado conseguir la autorizacion";
	    } finally {

	      if (in != null) try {
	              in.close();
	      } catch (IOException e) {             
	              e.printStackTrace();  //To change body of catch statement use File
	              return "401 Error intentado conseguir la autorizacion";
	      }
	    } 
	    return accessToken;
	}
	
	*/
	
	
	
	public List<Page> getPages(){
		return pages;
	}


	public String getPageName() {
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
