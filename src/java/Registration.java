/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String name=request.getParameter("name");
            String Last=request.getParameter("last");
            String email=request.getParameter("email");
            String pass=request.getParameter("password");
            String contact=request.getParameter("mobile");
            String gender=request.getParameter("gender");
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
                
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","");	

	        PreparedStatement ps=cn.prepareStatement("insert into Registration(First_Name,Last_Name,Email,Password,Contact,Gender) values (?,?,?,?,?,?)");
        
                 ps.setString(1, name);
                ps.setString(2, Last);
                ps.setString(3, email);
                ps.setString(4, pass);
                ps.setString(5, contact);
                ps.setString(6, gender);            
             boolean b=ps.execute();
		
		if(b==false)
                {
                   out.println("<h2>User have successfully Registered</h2>");  
                     RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.include(request, response);
                   
                
                }
        cn.close();

        }
        catch(Exception e)
        {
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
