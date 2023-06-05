package servlet.course;

import bean.Message;
import dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studenthelp")
public class studenthelp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO = new MessageDAO();
        List<Message> result = messageDAO.getAllUncomplete();
        request.setAttribute("helplist", result);
        request.getRequestDispatcher("page/root/studenthelp.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
