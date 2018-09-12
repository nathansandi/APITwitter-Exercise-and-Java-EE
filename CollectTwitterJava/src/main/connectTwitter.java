/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 *
 * @author nsand
 */
public class connectTwitter {
        	private static final String token = "187563605-nNhFluApOG7t7SdqSsu3AkMuqa0NVWsEXG1DOAIJ";
	        private static final String tokenSecret = "zHDEKhyV5CXiqpm0vdejiUiQzGO8UgwuBBupxM6uLK4IZ";
	        private static final String consumerKey = "Hany2ium2gwSk4fuSeQA";
	        private static final String consumerSecret = "wgjCdPRib471QvJgaEbJJ8nR6zYGigMuQduFrlaw"; 
                //Site para redirecinamento de tweets
	        private static final String tweetLink = "https://twitter.com/tweet/status/";                
                public static Twitter twitter = null;
                public static Twitter connectTwitter(){
                if (twitter == null) {

                    twitter = TwitterFactory.getSingleton();
                    AccessToken accessToken = new AccessToken(token, tokenSecret);
                    twitter.setOAuthConsumer(consumerKey, consumerSecret);
                    twitter.setOAuthAccessToken(accessToken);
                }
                return twitter;
        }
}
