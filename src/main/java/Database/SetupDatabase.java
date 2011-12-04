package Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetupDatabase
 */
@WebServlet("/SetupDatabase")
public class SetupDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetupDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:${user.home}/i377/Team18/db;shutdown=true");
			out.println("Baasi nimi: " + conn.getMetaData().getDatabaseProductName());
			
			Statement s =  conn.createStatement();
			//s.execute("INSERT INTO PIIRIPUNKT (PIIRIPUNKT_ID,KOOD,NIMETUS,GPS_LONGITUIDE,GPS_LATITUDE,KORGUS_MEREPINNAST,KOMMENTAAR,ALATES,KUNI,AVAJA,AVATUD,MUUTJA,MUUDETUD,SULGEJA,SULETUD) VALUES (2,'P101','Ela2',42482, 41378, 331,'Test','2011-11-11','2011-11-13','Henrik','2011-11-11','Aram','2011-11-12','Napik','2011-11-13')");
			s.execute("INSERT INTO RIIGI_ADMIN_YKSUSE_LIIK (RIIGI_ADMIN_YKSUSE_LIK_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI) VALUES (2, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene', 'nimetus1', 'kommentaar', CURRENT_DATE, CURRENT_DATE)");
			s.execute("INSERT INTO RIIGI_ADMIN_YKSUS (RIIGI_ADMIN_YKSUS_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, RIIGI_ADMIN_YKSUSE_LIK_ID) VALUES (2, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene', 'nimetus1', 'kommentaar', CURRENT_DATE, CURRENT_DATE, 2)");
			s.execute("INSERT INTO VAEOSA (VAEOSA_ID_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, RIIGI_ADMIN_YKSUS_ID, ALATES, KUNI) VALUES (2, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene', 'nimetus1', 'kommentaar', 2, CURRENT_DATE, CURRENT_DATE)");
			s.execute("INSERT INTO PIIRILOIK (PIIRILOIK_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD,KOOD, NIMETUS, GPS_KOORDINAADID, KOMMENTAAR) values (2, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene loik', 'nimetus1', '10,222 56.222243', 'kommentaar')");
			s.execute("INSERT INTO VAHTKOND (VAHTKOND_ID, AVAJA, AVATUD, MUUTJA, MUUDETUD, SULGEJA, SULETUD, KOOD, NIMETUS, KOMMENTAAR, ALATES, KUNI, PIIRIPUNKT_ID, VAEOSA_ID_ID ) VALUES(2, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'ylem', CURRENT_DATE, 'esimene', 'nimetus1', 'kommentaar', CURRENT_DATE, CURRENT_DATE,2,1)");
			
			out.println("Tabel loomine ");
			conn.close();
		} catch (Exception e) {
			out.println("!Andmebaasi error: " + e.getMessage());
		}
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
