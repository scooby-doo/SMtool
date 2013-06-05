package edu.SMtool.socialNetworks;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Component;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;

import edu.SMtool.entity.Event;
import edu.SMtool.entity.FacebookObject;

@Component
@RemoteProxy(name="facebookBean")
public class FacebookBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7850775153972751371L;
	//private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAHc29SNRi0Tx6ZBt45q2CnNmZAJ9KX2eNN7NVdLG7ZBmBCBGIaXriPRV4RmYvN98ykAJF9hrDeZAVMqEO14EmoTTwExkbbu7touiXLIQVjokIgpZCTb6UdTPp5kNlYDm1vZA2ZB5j5DrC2SnSpdxsrKMgcgi9cr1wZDZD";
			
	
	private static final String APP_ID = "377737765678750";
	private static final String APP_SECRET = "79f359aff8466938a83e2805ca06816f";
	private FacebookClient facebookClient;
	

	private FacebookObject facebookObject;
	
	private String accessToken;
	
	private String pageName;
	private String info = "default";
	private String post;
	
	//private AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
	
	
	public String getAccessToken() {
		return accessToken;
	}
	
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

	/*
	public ConnectionFactoryLocator connectionFactoryLocator(){
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(APP_ID, APP_SECRET));
		return registry;
	}
	*/
	
	public void getPageInfo(){
		AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
		facebookClient = new DefaultFacebookClient(accessTOKEN.getAccessToken());
		Page page = facebookClient.fetchObject(pageName, Page.class);
		System.out.println("Page likes: " + page.getLikes());
		setInfo("Page about: "+ page.getAbout());
	}
	
	public void publishPost(String post1){
		String tokenviafunction = autoritzacion();
		System.out.println("token via function");
		System.out.println(tokenviafunction);
		//AccessToken accessTOKEN = new DefaultFacebookClient().obtainExtendedAccessToken(APP_ID, APP_SECRET);
		///String access_token = accessTOKEN.getAccessToken();
		facebookClient = new DefaultFacebookClient(tokenviafunction);
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
	
	
	
	
	
	public void getPages(){
		
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
