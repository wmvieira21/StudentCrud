/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package StudentCrudNet;

import DAOUtils.DAO;
import Model.Student;
import java.io.IOException;
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
@WebServlet(name = "ServletStudent", urlPatterns = {"/ServletStudent"})
public class ServletStudent extends HttpServlet {

    private static String message = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = (request.getParameter("command") == null ? "" : request.getParameter("command"));

            switch (command) {
                case "DELETE":
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    DAO.deleteStudent(id);
                    request.setAttribute("listStudents", DAO.selectAllStudents());
                    break;
                default:
                    request.setAttribute("listStudents", DAO.selectAllStudents());
            }

        } catch (Exception ex) {
            message = ex.getMessage();
        } finally {
            request.setAttribute("message", message);
            dispatchIndex(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            String name = request.getParameter("stdName");
            String course = request.getParameter("course");
            Double fee = Double.valueOf(request.getParameter("fee"));

            Student tempStudent = new Student(name, course, fee);
            DAO.insertStudent(tempStudent);

            message = "Student " + name + " was successfully saved!";
        } catch (Exception e) {
            e.printStackTrace();
            //message = Arrays.toString(e.getStackTrace());
            message = e.getMessage();
        } finally {
            response.sendRedirect("ServletStudent");
        }
    }

    private void dispatchIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
