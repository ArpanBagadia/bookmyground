package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/arpan","root","root");
			PreparedStatement pst=con.prepareStatement("select * from bookground");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String id=rs.getString(1);
				String name=rs.getString(2);
				String number=rs.getString(3);
				String date=rs.getString(4);
				String etime=rs.getString(5);
				String exittime=rs.getString(6);
				out.println("<html><body><table>");
				out.println("<tr><td>"+id+"</td></tr>");
				out.println("<tr><td>"+name+"</td></tr>");
				out.println("<tr><td>"+number+"</td></tr>");
				out.println("<tr><td>"+date+"</td></tr>");
				out.println("<tr><td>"+etime+"</td></tr>");
				out.println("<tr><td>"+exittime+"</td></tr>");
				out.println("</table></body></html>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
