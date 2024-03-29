package servlet.student;

import bean.CourseSemester;
import bean.SelectList;
import bean.Student;
import dao.CourseSemesterDAO;
import dao.SelectListDAO;
import dao.SemesterDAO;
import dao.StudyCourseDAO;
import view.Course_select;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/select_course")
public class select_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        String semester = request.getParameter("semester");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("userinfo");
        String sno = student.getSno();
        Integer status = 200;
        StudyCourseDAO studyCourseDAO = new StudyCourseDAO();
        if (type.equals("ensure")) {
            //这里写要选择课程的操作：
            try {
                Boolean ok = studyCourseDAO.Select_Course(sno, semester, cno);
                if (!ok)
                    status = 502;
            } catch (SQLException e) {
                e.printStackTrace();
                status = 500;
            }
        } else {
            //这里写要取消课程的操作
            try {
                Boolean ok = studyCourseDAO.Cancle_Course(sno, semester, cno);
                if (!ok)
                    status = 502;
            } catch (Exception e) {
                e.printStackTrace();
                status = 500;
            }
        }
        response.setStatus(status);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String college = request.getParameter("college");
        String capaticy = request.getParameter("capaticy");
        if (cno == null)
            cno = "";
        if (cname == null)
            cname = "";
        if (college == null)
            college = "all";
        if (capaticy == null)
            capaticy = "all";
        HttpSession session = request.getSession();
        if (session == null) {
            response.setStatus(302);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        Student student = (Student) session.getAttribute("userinfo");
        if (student == null)
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        String major = student.getMajor();
        String sno = student.getSno();
        SemesterDAO semesterDAO = new SemesterDAO();
        SelectListDAO selectListDAO = new SelectListDAO();
        CourseSemesterDAO courseSemesterDAO = new CourseSemesterDAO();
        ArrayList<SelectList> selectLists = null;
        ArrayList<Course_select> courselist = null;
        ArrayList<CourseSemester> selected = null;
        String cnolist = null;
        String semester = null;
        try {
            semester = semesterDAO.getCurrentSemester();
            selectLists = selectListDAO.getinfoByCondition(major, semester, "1");
            if (selectLists.size() != 0) {
                cnolist = selectLists.get(0).getCno();
                courselist = courseSemesterDAO.select_course(semester, cnolist, sno, cno, cname, college, capaticy);
                request.setAttribute("courselist", courselist);
                request.getRequestDispatcher("page/student/select_course.jsp").forward(request, response);
            } else {
                request.setAttribute("courselist", new ArrayList<Course_select>());
                request.getRequestDispatcher("page/student/select_course.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
