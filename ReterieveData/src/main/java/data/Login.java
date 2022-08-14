package data;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		
		Properties props=new Properties();
		
		InputStream in= getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		
		Connection conn=DBConfig.getConnection(props);
		String p_ID = req.getParameter("p_ID");
		
		if(conn!=null)
		{
			out.println("Connection is established");
			out.println();
		System.out.println("yes");
		
		 out.println("Displaying the Product Details...\n");
		  out.println("Product Id\t\t Product Name\t\t Product Price\t\t Date Added On");
		
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet  rs=stmt.executeQuery("select * from eproduct where id ="+p_ID+"");
			
			while(rs.next()) {
				
				
				
				 
			        out.print(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t\t"+
			        		  rs.getTimestamp(4));
			        
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
		else
		{
			out.print("Error  While  Connecting");
			System.out.println("no");
		}
			
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	

}