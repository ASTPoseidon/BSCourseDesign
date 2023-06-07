package servlet.publicfile;

import bean.Student;
import bean.Teacher;
import bean.User;
import dao.SemesterDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        if (account == "" || password == "") {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("您的用户名或者密码为空，请重新登陆");
            printWriter.flush();
            printWriter.close();
        } else {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.login(account, password, type);
            if (user == null) {
                PrintWriter printWriter = response.getWriter();
                printWriter.print("<script type='text/javascript'>alert('用户名或者密码错误！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                printWriter.flush();
                printWriter.close();
            }
            if (type.equals("student".toString())) {
                //查询学生表详细信息，并设置session
                StudentDAO studentDAO = new StudentDAO();
                Student student = studentDAO.getInfo(user.getAccount());
                if (student == null) {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.print("<script type='text/javascript'>alert('没有您的登录信息，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                    printWriter.flush();
                    printWriter.close();
                } else {
                    SemesterDAO semesterDAO = new SemesterDAO();
                    String semester = null;
                    try {
                        semester = semesterDAO.getCurrentSemester();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (semester == null) {
                        PrintWriter printWriter = response.getWriter();
                        printWriter.print("<script type='text/javascript'>alert('学期列表出现错误，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                        printWriter.flush();
                        printWriter.close();
                        response.setStatus(500);
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo", student);
                    session.setAttribute("type", "student");
                    session.setAttribute("semester", semester);
                    //重定向到另外一个servlet
                    response.setStatus(302);
                    response.sendRedirect("content");
                }
            } else if (type.equals("teacher")) {
                //查询教师表详细信息，并设置session
                TeacherDAO teacherDAO = new TeacherDAO();
                Teacher teacher = teacherDAO.getInfo(user.getAccount());
                if (teacher == null) {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.print("<script type='text/javascript'>alert('没有您的登录信息，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                    printWriter.flush();
                    printWriter.close();
                } else {
                    SemesterDAO semesterDAO = new SemesterDAO();
                    String semester = null;
                    try {
                        semester = semesterDAO.getCurrentSemester();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (semester == null) {
                        PrintWriter printWriter = response.getWriter();
                        printWriter.print("<script type='text/javascript'>alert('学期列表出现错误，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                        printWriter.flush();
                        printWriter.close();
                        response.setStatus(500);
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo", teacher);
                    session.setAttribute("type", "teacher");
                    session.setAttribute("semester", semester);
                    response.setStatus(302);
                    response.sendRedirect("content");
                }
            } else if (type.equals("root")) {
                TeacherDAO teacherDAO = new TeacherDAO();
                Teacher teacher = teacherDAO.getInfo(user.getAccount());
                if (teacher == null) {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.print("<script type='text/javascript'>alert('没有您的登录信息，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                    printWriter.flush();
                    printWriter.close();
                } else {
                    //设置管理员身份标识
                    teacher.setType("root");
                    //设置管理员登录标识
                    SemesterDAO semesterDAO = new SemesterDAO();
                    String semester = null;
                    try {
                        semester = semesterDAO.getCurrentSemester();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (semester == null) {
                        PrintWriter printWriter = response.getWriter();
                        printWriter.print("<script type='text/javascript'>alert('学期列表出现错误，请联系管理员！');window.location.href='" + request.getContextPath() + "/index.jsp'</script>");
                        printWriter.flush();
                        printWriter.close();
                        response.setStatus(500);
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo", teacher);
                    session.setAttribute("type", "root");
                    session.setAttribute("semester", semester);
                    //重定向到另外一个servlet
                    response.setStatus(302);
                    response.sendRedirect("content");
                }
            }
        }
    }
}
