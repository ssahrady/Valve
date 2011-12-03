package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.sql.*;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session =  request.getSession();
		if(session.getAttribute("kasutaja") == null) {
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
//		else if (request.getParameter("view").equals("toograafik")) {
//			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
//			view.forward(request, response);
//		}	
		else {
			try {
				goToMainPage(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		if (request.getParameter("login") != null) {
			login(request, response);
			if(session.getAttribute("kasutaja") != null) {
				try {
					goToMainPage(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else {
	        	RequestDispatcher view = request.getRequestDispatcher("login.jsp");
	            view.forward(request, response);
	        }
        }
		else if (request.getParameter("logout") != null) {
			logout(request, response);
        }
		else if (request.getParameter("lisaVahtkond") != null) {
			try {
				lisaVahtkond(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				goToMainPage(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				goToMainPage(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}

	private void lisaVahtkond(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String kood = request.getParameter("kood");
		String nimetus = request.getParameter("nimetus");
		String piiripunkt = request.getParameter("piiripunkt");
		String alates = request.getParameter("alates");
		String kuni = request.getParameter("kuni");
		String kommentaar = request.getParameter("kommentaar");
		HttpSession session =  request.getSession();
		String avaja = (String) session.getAttribute("kasutaja");
		
		java.sql.Connection con;
		java.sql.Statement s;
		java.sql.ResultSet rs;

		con=null;
		s=null;
		rs=null;
		
		 
		String url=	"jdbc:hsqldb:C:/Users/Aram/workspace/DB/ValveDB";
		String id= "sa";
		String pass = "";
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = java.sql.DriverManager.getConnection(url, id, pass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "INSERT INTO VAHTKOND (VAHTKOND_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, PIIRIPUNKT_ID, VAEOSA_ID_ID) VALUES (10, '" + avaja + "', CURRENT_DATE, '" + avaja + "', CURRENT_DATE, '" +avaja + "', CURRENT_DATE, '" + kood + "', '" + nimetus + "', '" + kommentaar + "', '" + alates + "', '" + kuni + "', 111, 2)"; 
		try{
			s = con.createStatement();
			rs = s.executeQuery(sql);
			request.setAttribute("done", "done");
		}
		catch(Exception e){ e.printStackTrace(); request.setAttribute("done", "not done");}
		finally{
			if(s!=null) s.close();
			if(con!=null) con.close();
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.invalidate();
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

	private void goToMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			request.setAttribute("rs", andmed());
			RequestDispatcher view = request.getRequestDispatcher("vahtkond.jsp");
			view.forward(request, response);
			
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(true); 
		if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("Aiwei7ya")) {
			session.setAttribute("kasutaja", "admin");
		}
		else if(request.getParameter("username").equals("valvur") && request.getParameter("password").equals("valvur")) {
			session.setAttribute("kasutaja", "valvur");
		}
		else if(request.getParameter("username").equals("ylem") && request.getParameter("password").equals("ylem")) {
			session.setAttribute("kasutaja", "ylem");
		}
	}
	
	private static ResultSet andmed() throws SQLException {
		java.sql.Connection con;
		java.sql.Statement s;
		java.sql.ResultSet rs;
//		java.sql.PreparedStatement pst;
		
		con=null;
		s=null;
//		pst=null;
		rs=null;
		
		 
		String url=	"jdbc:hsqldb:C:/Users/Aram/workspace/DB/ValveDB";
		String id= "sa";
		String pass = "";
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = java.sql.DriverManager.getConnection(url, id, pass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "SELECT * FROM PIIRIPUNKT";
		try{
			s = con.createStatement();
			rs = s.executeQuery(sql);
		}
		catch(Exception e){ e.printStackTrace(); }
		finally{
			if(s!=null) s.close();
			if(con!=null) con.close();
		}
		return rs;
	}

}
