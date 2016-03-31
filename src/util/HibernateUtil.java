package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import ca.myseneca.a2.*;

public class HibernateUtil {
	
	final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // JDBC driver
	final String SYS_NAME = "zenit.senecac.on.ca"; // database server
	final String DB_NAME = "dbj565_161a09"; // database name
	
    // Database credentials
	final String USERID = "dbj565_161a09";
	final String PASSWORD = "cnTN9559";
	
	
	
	
	// VALIDATION
	
		public boolean validation(String uname){
			
			boolean ch = true;
			 
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName(DRIVER_NAME);
	 			String url = "jdbc:mysql://" + SYS_NAME + "/" + DB_NAME;
	 			conn = DriverManager.getConnection(url, USERID, PASSWORD);
			    stmt = conn.createStatement();
	 			String sql = "select userId from User where email='"+uname+"'";
	 	        rs = stmt.executeQuery(sql);
	 	       if(rs.absolute(1))
	 	    	ch = false;
	   	    }
			catch (ClassNotFoundException cnfex) {
				System.err.println("Failed to load JDBC driver.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Exception: " + e.getMessage());
			}
	 
			
			finally {
				try {
					if (stmt != null)
						stmt.close();
	 				if (conn != null)
						conn.close();
				} catch (SQLException e) {
				  }
			}
			
		return ch; 
			
		}
		
		public int validateLogin(String username,String passwd){
			int uId = 0;
			 
			
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					Class.forName(DRIVER_NAME);
		 			String url = "jdbc:mysql://" + SYS_NAME + "/" + DB_NAME;
		 			conn = DriverManager.getConnection(url, USERID, PASSWORD);
				    stmt = conn.createStatement();
		 			String sql = "select userId from User where email='"+username+"' and password='"+passwd+"'";
		 	        rs = stmt.executeQuery(sql);
		 	       if(rs.absolute(1))
		 	    	uId = rs.getInt("userId");
		   	    }
				catch (ClassNotFoundException cnfex) {
					System.err.println("Failed to load JDBC driver.");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Exception: " + e.getMessage());
				}
		 
				
				finally {
					try {
						if (stmt != null)
							stmt.close();
		 				if (conn != null)
							conn.close();
					} catch (SQLException e) {
					  }
				}
				
			return uId; 
			
		}
		
		
		public boolean tablesExist(){
			
			boolean ch = false;
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					Class.forName(DRIVER_NAME);
		 			String url = "jdbc:mysql://" + SYS_NAME + "/" + DB_NAME;
		 			conn = DriverManager.getConnection(url, USERID, PASSWORD);
		 			java.sql.DatabaseMetaData dbm = conn.getMetaData();
		            rs = dbm.getTables(null, null, "Use", null);
		            if (rs.next()) {
		                System.out.println("Customer Table Exists !");
		                ch = true;
		            }else{
		                System.out.println("Customer Table Doesn't Exist !");
		            }
		 			
		   	    }
				catch (ClassNotFoundException cnfex) {
					System.err.println("Failed to load JDBC driver.");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Exception: " + e.getMessage());
				}
			
				finally {
					try {
						if (stmt != null)
							stmt.close();
		 				if (conn != null)
							conn.close();
					} catch (SQLException e) {
					  }
				}
			
			return ch;
			
			
		}
		
	public void createSchema(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Quiz.class);
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Answer.class);
		
		System.out.println("CREATING DB");
		
		// http://stackoverflow.com/questions/14977018/jpa-how-to-get-entity-based-on-field-value-other-than-id
		cfg.configure();
		new SchemaExport(cfg).create(true,false);
		
		
		
		SessionFactory f = cfg.buildSessionFactory();
		Session current = f.getCurrentSession();
		current.beginTransaction();
	    current.getTransaction().commit();
		
		
	}
	
	

}
