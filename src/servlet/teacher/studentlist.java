package servlet.teacher;

import bean.CourseSemester;
import bean.Teacher;
import dao.CourseSemesterDAO;
import dao.StudyCourseDAO;
import view.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/studentlist")
public class studentlist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (session == null) {
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        }
        String semester = (String) session.getAttribute("semester");
        String tempvalue = request.getParameter("cno");
        String[] t = tempvalue.split("-");
        String cno = t[0];
        String cname = t[1];
        String sno = request.getParameter("sno");
        Teacher teacher = (Teacher) session.getAttribute("userinfo");
        String tno = teacher.getTno();
        StudyCourseDAO db = new StudyCourseDAO();
        CourseSemesterDAO dbseme = new CourseSemesterDAO();
        ArrayList<CourseSemester> resseme = null;
        ArrayList<StudentInfo> res = null;
        try {
            resseme = dbseme.getCourseList(tno, semester);
            res = db.getStudentList(sno, cno, semester, cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("courselist", resseme);
        request.setAttribute("studentlist", res);
        request.getRequestDispatcher("page/teacher/studentlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null) {
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        }
        Teacher teacher = (Teacher) session.getAttribute("userinfo");
        String tno = teacher.getTno();
        String semester = (String) session.getAttribute("semester");
        CourseSemesterDAO db = new CourseSemesterDAO();
        ArrayList<CourseSemester> res = null;
        try {
            res = db.getCourseList(tno, semester);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("courselist", res);
        request.getRequestDispatcher("page/teacher/studentlist.jsp").forward(request, response);
    }
}
