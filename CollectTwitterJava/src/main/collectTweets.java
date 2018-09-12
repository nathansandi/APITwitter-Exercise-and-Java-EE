/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import static main.connectTwitter.twitter;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StreamController.User;
import twitter4j.Twitter;

/**
 *
 * @author nsand
 */
public class collectTweets {
    
    public static ArrayList<Status> collect(String hash){
        Query query = new Query(hash);
           int numberOfTweets = 100;
           long lastID = Long.MAX_VALUE;
        
           ArrayList<Status> tweets = new ArrayList<Status>();
           
           while (tweets.size () < numberOfTweets) {
             if (numberOfTweets - tweets.size() > 100)
               query.setCount(100);
             else 
               query.setCount(numberOfTweets - tweets.size());
             try {
               QueryResult result = twitter.search(query);
               tweets.addAll(result.getTweets());
          
               //temp solution - if getPlace null -  post getPlace
                      

               for (Status t: tweets) 
                 if(t.getId() < lastID) 
                     lastID = t.getId();

            } catch (Exception e) {
                 System.out.println("Error--"+e);
            }
        }
        return tweets;
    }
}
