package servlet.course;

import bean.Course;
import dao.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searcharrange")
public class searcharrange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String dept = request.getParameter("college");
        String status = request.getParameter("status");
        CourseDAO courseDAO = new CourseDAO();
        try {
            List<Course> courselist = courseDAO.SearchClass(cno, cname, dept, status);
            request.setAttribute("courselist", courselist);
            request.getRequestDispatcher("page/root/coursearrangement.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        CourseDAO courseDAO = new CourseDAO();
        Course course = null;
        try {
            course = courseDAO.SelectByCno(cno);
            List<Course> courselist = new ArrayList<Course>();
            courselist.add(course);
            request.setAttribute("courselist", courselist);
            request.getRequestDispatcher("page/root/courseinfo.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('服务器出错');history.back();</script>");
            printWriter.flush();
            printWriter.close();
        }
    }
}
