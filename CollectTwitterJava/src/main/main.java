/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import static main.connectTwitter.twitter;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;


/**
 *
 * @author nsand
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //Open DB Connection
        Connection con = insertDB.connectDB();
        //Connect with Twitter 
        Twitter connect = connectTwitter.connectTwitter();
        //Collect Data for openbanking
       
       
        minerar("#openBanking", con );
        minerar("#apifirst", con );
        minerar("#devops", con );
        minerar("#cloudfirst", con );
        minerar("#microservices", con );
        minerar("#apigetway", con );
        minerar("#oauth", con );
        minerar("#swagger", con );
        minerar("#raml", con );
        minerar("#openapis", con );
        
        
       System.out.println("Finished");
      // Getting Twitter Timeline using Twitter4j API                
       // Twitter twitter = new TwitterFactory(cb.build()).getInstance();
       
    }public static String convertDate(Date data){
       String dataR="";
       //2012-01-05 15:05:23
    
       
       dataR = data.getYear()+1900+"-"+(data.getMonth()+1)+"-"+data.getDate() + " " +data.getHours()+":"+data.getMinutes()+":"+data.getSeconds()+"";
       return dataR;
    }
    public static void minerar(String hashtag, Connection con){
         ArrayList<Status> tweets = collectTweets.collect(hashtag);
        //Insert Data in Database 
        
        //System.out.println("Primeiro user - id -- "+tweets.get(0).getUser().getScreenName()  + " // idioma -- " +tweets.get(0).getLang()+ "// seguidores -- "+tweets.get(0).getUser().getFollowersCount()+"// pais -- ");
        System.out.println("Gathered " + tweets.size() + " tweets"+"\n"); 
        String test = convertDate(tweets.get(0).getCreatedAt()); 
        for (int i = 0; i < tweets.size(); i++) {
              if(tweets.get(i).getPlace() != null ){
                  String status = insertDB.insertData(hashtag, tweets.get(i).getUser().getScreenName(), tweets.get(i).getPlace().getCountry(), tweets.get(i).getLang(), tweets.get(i).getUser().getFollowersCount(),convertDate(tweets.get(0).getCreatedAt()), con);
              }else{
                  String status = insertDB.insertData(hashtag, tweets.get(i).getUser().getScreenName(), "Sem local", tweets.get(i).getLang(), tweets.get(i).getUser().getFollowersCount(),convertDate(tweets.get(0).getCreatedAt()), con);
              }

          }
    }
  
}
