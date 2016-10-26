/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DreamDiary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
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

	public boolean addDream(String id, String dream) {
		String sql = "INSERT INTO DREAMS (id, content, date, interp, userid) VALUES ('1', 'Mig dreymdi ís.', '123', 'Þú munt deyja á morgun.', '999');";
		return update(sql);
	}
        
        public String testQuery() {
            Connection connection = null;
            Statement statement = null;
            String str = "";
            
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/afkfpofr",
				"afkfpofr", "C2UETIervjxGCirloUj6XhQMC3T_z4XS");
                statement = connection.createStatement();
                String sql = "SELECT * FROM DREAMS";
                
                ResultSet rs = statement.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String content = rs.getString("content");
                    int date = rs.getInt("date");
                    String interp = rs.getString("interp");
                    int userid = rs.getInt("userid");
                    
                    str = "" + id
                            + " " + content
                            + " " + date
                            + " " + interp
                            + " " + userid;   
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
            return str;
        }
        
        public void createTable() {
            String sql = "CREATE TABLE DREAMS(id int, content varchar(500), date int, interp varchar(200), userid int);";
            update(sql);
        }
        
        public void dropTable() {
            String sql = "DROP TABLE DREAMS";
            update(sql);
        }

}
