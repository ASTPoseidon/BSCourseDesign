package servlet.course;

import dao.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/accessnewcourse")
public class accessnewcourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        CourseDAO courseDAO = new CourseDAO();
        try {
            Boolean ok = courseDAO.accessCourse(cno);
            if (ok) {
                response.setStatus(200);
            } else {
                response.setStatus(500);
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<script>alert('操作失败');</script>");
                printWriter.flush();
                printWriter.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
