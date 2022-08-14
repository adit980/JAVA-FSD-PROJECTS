package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Product;

@WebServlet("/list")
public class display extends HttpServlet 

{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter(); 
		resp.setContentType("text/html");
		SessionFactory factory = HibernateUtil.getSessionFactory();
         
         Session session = factory.openSession();
         // using HQL
         List<Product> list = session.createQuery("from Product").list();
         
         session.close();
         
         out.println("<html><body>");
         out.println("<b>Product Listing</b><br>");
         
         for(Product p: list) {
             out.println("ID: " + String.valueOf(p.getPid()) + ", Name: " + p.getPname() +
                             ", Price: " + String.valueOf(p.getPprice()) + "<br>");
             
             
         out.println("</body></html>");
     }
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

	
}
