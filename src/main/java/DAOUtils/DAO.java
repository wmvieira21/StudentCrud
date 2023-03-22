package DAOUtils;

import Model.Student;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author willi
 */
public class DAO {

    public static Connection getConnection() throws ServletException {
        try {
            Connection conn;
            PreparedStatement pst;
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    public static void insertStudent(Student student) throws Exception {

        Connection conn = DAO.getConnection();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("insert into records (name,course,fee) values (?,?,?)");
            pst.setString(1, student.getName());
            pst.setString(2, student.getCourse());
            pst.setDouble(3, student.getFee());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        } finally {
            closeConection(conn, pst, null);
        }
    }

    public static void updateStudent(Student student) throws Exception {

        Connection conn = DAO.getConnection();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("update records "
                    + "set name=?,"
                    + "course=?,"
                    + "fee=? "
                    + "where id = ?");
            pst.setString(1, student.getName());
            pst.setString(2, student.getCourse());
            pst.setDouble(3, student.getFee());
            pst.setInt(4, student.getId());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        } finally {
            closeConection(conn, pst, null);
        }
    }

    public static void deleteStudent(int id) throws Exception {

        Connection conn = DAO.getConnection();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("delete from records where id = ?");
            pst.setInt(1, id);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        } finally {
            closeConection(conn, pst, null);
        }
    }

    public static List<Student> selectAllStudents() throws Exception {

        Connection conn = DAO.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        try {
            pst = conn.prepareStatement("select * from records");
            rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("course"), rs.getDouble("fee")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        } finally {
            closeConection(conn, null, rs);
        }
    }

    private static void closeConection(Connection conn, PreparedStatement pst, ResultSet rs) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}
