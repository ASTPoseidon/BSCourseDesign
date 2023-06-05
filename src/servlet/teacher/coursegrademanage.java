package servlet.teacher;

import bean.StudyCourse;
import dao.StudyCourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/coursegrademanage")
public class coursegrademanage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        String semester = request.getParameter("semester");
        String sno = request.getParameter("sno");
        Integer grade = Integer.parseInt(request.getParameter("grade"));
        StudyCourseDAO db = new StudyCourseDAO();
        Integer status = 200;
        Boolean ok = false;
        try {
            ok = db.changeGrade(sno, semester, cno, grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!ok)
            status = 404;
        response.setStatus(status);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String cno = request.getParameter("cno");
        String semester = request.getParameter("semester");
        StudyCourseDAO db = new StudyCourseDAO();
        ArrayList<StudyCourse> result = new ArrayList<StudyCourse>();
        try {
            result = db.getStudents(cno, semester);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("studentlist", result);
        request.getRequestDispatcher("app/teacher/gradestudentlist.jsp").forward(request, response);
    }
}
