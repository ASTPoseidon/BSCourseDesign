package servlet.publicfile;

import dao.StudentDAO;
import dao.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeinfo")
public class changeinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String identity = request.getParameter("identity");
        String kind = request.getParameter("kind");
        String value = request.getParameter("value");
        String account = request.getParameter("account");
        if (identity.equals("teacher")) {
            String sql = "update teacher set ";
            TeacherDAO teacherDAO = new TeacherDAO();
            Boolean ok = null;
            try {
                ok = teacherDAO.changeInfo(sql, account, kind, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (ok) {
                response.setStatus(200);
            } else {
                response.setStatus(404);
            }
        } else {
            String sql = "update student set ";
            StudentDAO studentDAO = new StudentDAO();
            Boolean ok = null;
            try {
                ok = studentDAO.changeInfo(sql, account, kind, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (ok) {
                response.setStatus(200);
            } else {
                response.setStatus(404);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
