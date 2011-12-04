package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class individual
 */
@WebServlet("/individual")
public class individual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public individual() {
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
				goToIndividualPage(request, response);
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
					goToIndividualPage(request, response);
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
		else if (request.getParameter("varskenda") != null) {
			try {
				varskendaIndivual(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				goToIndividualPage(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				goToIndividualPage(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}

	private void varskendaIndivual(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String piirivalvur = request.getParameter("piirivalvur_id");
		String alates = request.getParameter("alates");
		String kuni = request.getParameter("kuni");
		HttpSession session =  request.getSession();
		String avaja = (String) session.getAttribute("kasutaja");
		
		java.sql.Connection con;
		java.sql.Statement s;
		java.sql.ResultSet rs;

		con=null;
		s=null;
		rs=null;
		
		 
		String url=	"jdbc:hsqldb:PiiriDB";
		String id= "sa";
		String pass = "";
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = java.sql.DriverManager.getConnection(url, id, pass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "SELECT p.piiriloik, v.nimetus, alates, kuni FROM PIIRIVALVUR pr,  PIIRILOIK p, VAHTKOND v, VAHTKONNA_LIIGE vl, VAHTKONND_PIIRILOIGUL vpl WHERE p.PIIRILOIK_ID = vpl.PIIRILOIK_ID AND " +
				"v.VAHTKOND_ID = vpl.VAHTKOND_ID AND  "+alates+"  BETWEEN  "+kuni;
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

	private void goToIndividualPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			request.setAttribute("rs", andmed());
			RequestDispatcher view = request.getRequestDispatcher("toograafik.jsp");
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
		
		 
		String url=	"jdbc:hsqldb:PiiriDB";
		String id= "sa";
		String pass = "";
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = java.sql.DriverManager.getConnection(url, id, pass);
		}
		catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}
		
		String sql = "SELECT * FROM VAHTKONNA_LIIGE";
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
