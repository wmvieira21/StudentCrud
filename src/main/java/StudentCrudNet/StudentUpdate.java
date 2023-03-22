/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package StudentCrudNet;

import DAOUtils.DAO;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willi
 */
@WebServlet(name = "StudentUpdate", urlPatterns = {"/StudentUpdate"})
public class StudentUpdate extends HttpServlet {
    
    private static Integer id;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String command = request.getParameter("command");
        
        switch (command) {
            case "SAVE":
                this.dispatchIndex(request, response);
                break;
            default:
                this.loadInformationForm(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            
            String name = request.getParameter("name");
            String course = request.getParameter("course");
            Double fee = Double.valueOf(request.getParameter("fee"));
            
            DAO.updateStudent(new Student(id, name, course, fee));
            
            response.sendRedirect("ServletStudent?command=SAVED");
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }
    
    private void dispatchIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ServletStudent");
        dispatcher.forward(request, response);
    }
    
    private void loadInformationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        Double fee = Double.valueOf(request.getParameter("fee"));
        
        request.setAttribute("name", name);
        request.setAttribute("course", course);
        request.setAttribute("fee", fee);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        dispatcher.forward(request, response);
    }
}
