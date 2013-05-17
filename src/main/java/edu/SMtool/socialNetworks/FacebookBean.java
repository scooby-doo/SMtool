package edu.SMtool.socialNetworks;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;

import edu.SMtool.entity.Event;

@Component
public class FacebookBean {
	
	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAHc29SNRi0Tx6ZBt45q2CnNmZAJ9KX2eNN7NVdLG7ZBmBCBGIaXriPRV4RmYvN98ykAJF9hrDeZAVMqEO14EmoTTwExkbbu7touiXLIQVjokIgpZCTb6UdTPp5kNlYDm1vZA2ZB5j5DrC2SnSpdxsrKMgcgi9cr1wZDZD";
			
	FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
	//private static final String APP_ID = "377737765678750";
	//private static final String APP_SECRET = "79f359aff8466938a83e2805ca06816f";
	
	//private static AccessToken accessToken = new DefaultFacebookClient().obtainExtendedAccessToken("377737765678750", "79f359aff8466938a83e2805ca06816f");
	//private static AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(APP_ID, APP_SECRET);
	///private FacebookClient fbClient = new DefaultFacebookClient(accessToken.getAccessToken());
	private String pageName;
	private String info = "default";
	private String post;

	
	public void getPageInfo(){
		Page page = facebookClient.fetchObject(pageName, Page.class);
		System.out.println("Page likes: " + page.getLikes());
		setInfo("Page about: "+ page.getAbout());
	}
	
	public void publishPost(String post1){
		FacebookType publishMessage = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", post1));
		System.out.println("published message ID: " + publishMessage.getId());
	}
	
	public void publishEvent(Event event){
		Date startDate = event.getStartDate();
		Date endDate = event.getEndDate();
		String name = event.getName();
		FacebookType publishEventResponse = facebookClient.publish("me/events", FacebookType.class,
		  Parameter.with("name", name), Parameter.with("start_time", startDate),
		    Parameter.with("end_time", endDate));
		System.out.println("published event id" + publishEventResponse.getId());
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

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
}
