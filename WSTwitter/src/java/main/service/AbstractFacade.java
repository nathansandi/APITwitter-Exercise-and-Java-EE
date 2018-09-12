/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author nsand
 */
public abstract class AbstractFacade<T> {
    //public EntityManager em;
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    
    public String topFollowers() throws SQLException {
        //List <T> OrderBy = 
             Connection con = insertDB.connectDB();
           con = insertDB.connectDB();
           String sqlInt = "select distinct top 5 userId, followers from tbTweetsData order by followers desc";
           ResultSet rs = insertDB.selectData(con, sqlInt);
           String test = "";
           List<String> testList = new ArrayList<>();
           while (rs.next()) {
                       
                        //testList.add("oi");
                        // String testff = "";
                        testList.add(rs.getString(1));
            		//test = rs.getString(1);
             }
           
               Gson gsonBuilder = new GsonBuilder().create();
 
                String jsonFromJavaArrayList = gsonBuilder.toJson(testList);
                //System.out.println(jsonFromJavaArrayList);
           
           return jsonFromJavaArrayList;       
        
       
    }
    public  String groupPerHour() throws SQLException {
           Connection con = insertDB.connectDB();
           con = insertDB.connectDB();
           String sqlInt = "SELECT DATEPART(hour,data) as hour, count(*) as numberOfTweets FROM tbTweetsData WHERE DATEPART(day,SYSDATETIME()) = DATEPART(day, data)  and DATEPART(month,SYSDATETIME()) = DATEPART(month, data) and DATEPART(YEAR,SYSDATETIME()) = DATEPART(year, data) GROUP BY  DATEPART(hour,data)";
           ResultSet rs = insertDB.selectData(con, sqlInt);
           String test = "";
           List<groupByDate> testList = new ArrayList<>();
           while (rs.next()) {
                        groupByDate t = new groupByDate();
                        t.setCount(Integer.parseInt(rs.getString(1)));
                        t.setHour(rs.getString(1));
                        testList.add(t);
            		//test = rs.getString(1);
             }
           
               Gson gsonBuilder = new GsonBuilder().create();
 
                String jsonFromJavaArrayList = gsonBuilder.toJson(testList);
                //System.out.println(jsonFromJavaArrayList);
           
           return jsonFromJavaArrayList;       
       
    }
    public  String groupByLanguage() throws SQLException {
           Connection con = insertDB.connectDB();
           con = insertDB.connectDB();
           String sqlInt = "select language, count(*), hashtag from tbTweetsData group by [language],hashtag order by hashtag asc";
           ResultSet rs = insertDB.selectData(con, sqlInt);
           String test = "";
           List<groupByLanguage> testList = new ArrayList<>();
           while (rs.next()) {
                        groupByLanguage t = new groupByLanguage();
                        t.setLanguage(rs.getString(1));
                        t.setHashtag(rs.getString(3));
                        t.setCount(Integer.parseInt(rs.getString(2)));
                        testList.add(t);
            		//test = rs.getString(1);
             }
           
               Gson gsonBuilder = new GsonBuilder().create();
 
                String jsonFromJavaArrayList = gsonBuilder.toJson(testList);
                //System.out.println(jsonFromJavaArrayList);
           
           return jsonFromJavaArrayList;       
       
    }

}
