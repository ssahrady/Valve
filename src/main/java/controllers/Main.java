package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
       private static String DBurl=	"jdbc:hsqldb:file:${user.home}/i377/Team18/db;shutdown=true";
       private static String DBid= "sa";
       private static String DBpass = "";
       private static String DBdriverName = "org.hsqldb.jdbcDriver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	try {
			Class.forName(DBdriverName);
			Connection conn = DriverManager.getConnection(DBurl);
			
			Statement s =  conn.createStatement();
			s.execute("INSERT INTO PIIRIPUNKT (PIIRIPUNKT_ID,KOOD,NIMETUS,GPS_LONGITUIDE,GPS_LATITUDE,KORGUS_MEREPINNAST,KOMMENTAAR,ALATES,KUNI,AVAJA,AVATUD,MUUTJA,MUUDETUD,SULGEJA,SULETUD) VALUES (IDENTITY(),'P101','Ikla',42482, 41378, 331,'Test_kommentaar','2011-11-11','2011-11-13','Henrik','2011-11-11','','','','')");
			s.execute("INSERT INTO RIIGI_ADMIN_YKSUSE_LIIK (RIIGI_ADMIN_YKSUSE_LIK_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI) VALUES (IDENTITY(), 'ylem', CURRENT_DATE, '', '', '', '', 'Riigi_admin_yksys_liik_1', 'Riigi_admin_yksys_liik_nimetus', 'kommentaar', CURRENT_DATE, CURRENT_DATE)");
			s.execute("INSERT INTO RIIGI_ADMIN_YKSUS (RIIGI_ADMIN_YKSUS_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, RIIGI_ADMIN_YKSUSE_LIK_ID) VALUES (IDENTITY(), 'ylem', CURRENT_DATE, '', '', '', '', 'Riigi_admin_yksys_1', 'Riigi_admin_yksys_nimetus', 'kommentaar', CURRENT_DATE, CURRENT_DATE, 1)");
			s.execute("INSERT INTO VAEOSA (VAEOSA_ID_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, RIIGI_ADMIN_YKSUS_ID, ALATES, KUNI) VALUES (IDENTITY(), 'ylem', CURRENT_DATE, '', '', '', '', 'esimene', 'nimetus1', 'kommentaar', 1, CURRENT_DATE, CURRENT_DATE)");
			s.execute("INSERT INTO PIIRILOIK (PIIRILOIK_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD,KOOD, NIMETUS, GPS_KOORDINAADID, KOMMENTAAR) values (IDENTITY(), 'ylem', CURRENT_DATE, '', '', '', '', 'esimene loik', 'nimetus1', '10.222 56.222243', 'kommentaar')");
			s.execute("INSERT INTO VAHTKOND (VAHTKOND_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, PIIRIPUNKT_ID, VAEOSA_ID_ID ) VALUES(IDENTITY(), 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene', 'nimetus1', 'kommentaar', CURRENT_DATE, CURRENT_DATE,2,1)");
			 s.execute("INSERT INTO PIIRIVALVUR (PIIRIVALVUR_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, ISIKUKOOD, EESNIMED, PEREKONNANIMI, SUGU, SODURI_KOOD, KOMMENTAAR) VALUES (IDENTITY(), 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, '49027364527', 'Maksim', 'Kirsipuu', 'M', '63726348', 'komm')");
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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
		
		try{
			Class.forName(DBdriverName);
			con = java.sql.DriverManager.getConnection(DBurl, DBid, DBpass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "INSERT INTO VAHTKOND (VAHTKOND_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, PIIRIPUNKT_ID, VAEOSA_ID_ID) VALUES (IDENTITY(), '" + avaja + "', CURRENT_DATE, '" + avaja + "', CURRENT_DATE, '" +avaja + "', CURRENT_DATE, '" + kood + "', '" + nimetus + "', '" + kommentaar + "', '" + alates + "', '" + kuni + "', 111, 2)"; 
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
			request.setAttribute("piiripunkt", Piiripunkt());
			request.setAttribute("piirivalvur", Piirivalvur());
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
	
	private static ResultSet Piiripunkt() throws SQLException {
		Connection con = null;
		Statement s = null;
		ResultSet piiripunkt = null;		
		try{
			Class.forName(DBdriverName);
			con = java.sql.DriverManager.getConnection(DBurl, DBid, DBpass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "SELECT * FROM PIIRIPUNKT";
		try{
			s = con.createStatement();
			piiripunkt = s.executeQuery(sql);
		}
		catch(Exception e){ e.printStackTrace(); }
		finally{
			if(s!=null) s.close();
			if(con!=null) con.close();
		}
		return piiripunkt;
	}
	
	private static ResultSet Piirivalvur() throws SQLException {
		Connection con = null;
		Statement s = null;
		ResultSet piirivalvur = null;
		
		try{
			Class.forName(DBdriverName);
			con = java.sql.DriverManager.getConnection(DBurl, DBid, DBpass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "SELECT * FROM PIIRIVALVUR";
		try{
			s = con.createStatement();
			piirivalvur = s.executeQuery(sql);
		}
		catch(Exception e){ e.printStackTrace(); }
		finally{
			if(s!=null) s.close();
			if(con!=null) con.close();
		}
		
		return piirivalvur;
	}

}
