package servlet.root;

import dao.SemesterDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/runingcontrol")
public class runingcontrol extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        SemesterDAO semesterDAO = new SemesterDAO();
        ArrayList<String> result = new ArrayList<String>();
        try {
            result = semesterDAO.getSemesterList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("semester", result);
        request.getRequestDispatcher("app/root/runingcontrol.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
