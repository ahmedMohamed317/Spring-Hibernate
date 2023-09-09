package testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String user = "root";
	String pass = "134679258";
	String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp";
	String driver ="com.mysql.jdbc.Driver";
	 
	// get connection to database
			try {
				PrintWriter out = response.getWriter();
				
				out.println("Connecting to database: " + url);
				
				Class.forName(driver);
				
				Connection myConn = DriverManager.getConnection(url, user, pass);
				
				out.println("SUCCESS!!!");
				
				myConn.close();
				
			}
			catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc);
			}
		
		
		}

	}







