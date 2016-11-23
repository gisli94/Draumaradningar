/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DreamDiary.controllers;
import DreamDiary.entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author Gisli
 */

public class DatabaseController{
	
	private boolean update(String sql) {
		boolean complete = false;
		Connection connection;
		Statement statement;

		try {
			Class.forName("org.postgresql.Driver");
                        System.out.println("A");
			connection = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/afkfpofr",
				"afkfpofr", "C2UETIervjxGCirloUj6XhQMC3T_z4XS");
			connection.setAutoCommit(false);
			statement = connection.createStatement();
                        System.out.println("Á");
			statement.executeUpdate(sql);
                        System.out.println("B");
			statement.close();
			connection.commit();
			connection.close();
			complete = true;
			System.out.println("yolo mofo");
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
		}
		return complete;
	}

	public boolean addDream(Dream dream) {
        // name, userid, content, id, date, interpretation
        //String sql = "INSERT INTO DREAMS (name, userid, content, id, date, interpretation) VALUES ('1', 'Mig dreymdi ís.', '123', 'Þú munt deyja á morgun.', '999');";

		//String sql = "INSERT INTO DREAMS (id, userid, date, name, content, interpretation) VALUES ('" + dream.getId() + "', '" + dream.getUserId() + "', '" + dream.getDate() + "', '" + dream.getName() + "', '" + dream.getContent() + "', '" + dream.getInterpretation() + "');";

		String sql = "INSERT INTO DREAMS2 (id, userid, date, name, content, interpretation) VALUES ('" + dream.getId() + "', '" + dream.getUserId() + "', '" + dream.getDate() + "', '" + dream.getName() + "', '" + dream.getContent() + "', '" + dream.getInterpretation() + "');";

		return update(sql);
	}
  
    public ArrayList<Dream> getDreams(int user) {
        Connection connection = null;
        Statement statement = null;
        String str = "";
        ArrayList<Dream> list = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/afkfpofr",
            "afkfpofr", "C2UETIervjxGCirloUj6XhQMC3T_z4XS");
            statement = connection.createStatement();
            String sql = "SELECT * FROM DREAMS2 WHERE userid=" + user + " order by date desc limit 10";
                
            ResultSet rs = statement.executeQuery(sql);
                
            while (rs.next()) {
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");
                LocalDate date = rs.getDate("date").toLocalDate();
                String name = rs.getString("name");
                String content = rs.getString("content");
                String interpretation = rs.getString("interpretation");
                list.add(new Dream(id, userid, date, name, content,interpretation));
            }
            rs.close();
            statement.close();
            //connection.commit();
            connection.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }  

        return list;//.toArray(new Dream[list.size()]);
    }

    public boolean addUser(User user){
        String sql = "INSERT INTO USERS2 (name, password) VALUES ('" + user.getName() + "', '" + user.getPassword() + "')";
        return update(sql);
    }
    
    public User[] getUsers(String user, String pass){
        Connection connection = null;
        Statement statement = null;
        String str = "";
        ArrayList<User> list = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/afkfpofr",
            "afkfpofr", "C2UETIervjxGCirloUj6XhQMC3T_z4XS");
            statement = connection.createStatement();
            String sql = "SELECT * FROM USERS2 WHERE name='" + user + "' AND password='" + pass + "';";
            // SELECT * FROM USERS WHERE name='Gísli' AND password='asdf';
                
            ResultSet rs = statement.executeQuery(sql);
                
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                list.add(new User(id, name, password));
            }
            rs.close();
            statement.close();
            //connection.commit();
            connection.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }  

        return list.toArray(new User[list.size()]);
    }
        
    private void createTable() {
        String sql = "CREATE TABLE DREAMS(id int, content varchar(500), date int, interp varchar(200), userid int);";
        update(sql);
    }
        
    private void dropTable() {
        String sql = "DROP TABLE DREAMS";
        update(sql);
    }

}
