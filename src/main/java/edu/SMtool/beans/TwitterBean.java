package edu.SMtool.beans;

import org.springframework.stereotype.Component;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Component
public class TwitterBean {

	private String CONSUMER_KEY = "foTxBqxlB79G2P2qTe5ZNQ";
	private String CONSUMER_SECRET = "I1C7btx2ss2CiWnNztBNyz0Z5YmmrRlqrq0h8K4pWY";
	private String ACCESSTOKEN = "173815099-sKuOSFxxZ7ZwcmAkq1Md6oo3dXhzOO14wjgMh4Lc";
	private String ACCESS_TOKEN_SECRET = "q0KQVSvCw9g1oeWOvQ3ks0Rl54iWhpaj6w8dnUevk";

	public void postTweet(String tweet) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = twitter.getOAuthAccessToken();
		twitter.updateStatus(tweet);
	}

}
