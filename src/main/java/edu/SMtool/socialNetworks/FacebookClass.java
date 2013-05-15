package edu.SMtool.socialNetworks;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;
import com.restfb.types.Page;
import com.restfb.types.User;


public class FacebookClass {
	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAP3gZBW8mwHZBJGZBZAZCq2Tm5oQAZCvKP5BIA90JLaPpiq2ZAZCF8Pwoy2yP44olkmUsh8GKIEU6qFOZBAJDrLztGLApICuQn9k95EqhJd2Q9hVSB85qSQlxlb33N0TYgSZCfAZBI19RKdQ8ZCDRE58oYPtAgPsdVYyowZDZD";
	
	public static void main (String[] args)throws FacebookException{
		FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		User user = facebookClient.fetchObject("me", User.class);
		Page page = facebookClient.fetchObject("BESTChisinau", Page.class);
		System.out.println("User name: " + user.getName());
		System.out.println("Page likes: " + page.getLikes());
	}
	

}
