package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		String id= req.getParameter("id");
		String name= req.getParameter("bname"); 
		String number= req.getParameter("number");
		String date= req.getParameter("date");
		String etime= req.getParameter("etime");
		String exittime= req.getParameter("etime");
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/arpan","root","root");
		   PreparedStatement pst=  con.prepareStatement("UPDATE bookground SET name=?,number=?,date=?,etime=?,exittime=? WHERE id=?");
		   pst.setString(1,name);
		   pst.setString(2,number);
		   pst.setString(3,date);
		   pst.setString(4,etime);
		   pst.setString(5,exittime);
		   pst.executeUpdate();
		   out.println("<html><body>");
		   out.println("<h1>Your Booking is Updated</h1>");
		   out.println("<a href='Display'>Display</a>");
		   out.println("</body></html>");
		}
    	catch(Exception e){
		    System.out.print(e);
		}
	}

}
